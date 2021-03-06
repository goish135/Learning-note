import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.io.FileWriter;

public class nonogram {
	

	// nonogram
	static int R, C;
	static int[][]rows, cols;
	static long[]grid;
	static long[][]rowPerms; // bitwise possible permutations per row
	static final char EMPTY = '0', FILLED = '1';
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("output.txt",true);
		
		
		File file = new File("input.txt"); 
		
		Scanner scan=new Scanner(file);
		
		// READ & INIT
		//R = in.readInt();
		//C = in.readInt();
		R = 25;
		C = 25;
		while(scan.hasNextLine())
		{	
			String input;
			
			input=scan.nextLine();
			System.out.println(input);
			fw.write(input+"\r\n");
			
			long startTime = System.currentTimeMillis();
			// read rows
			int num = 0;
			//while(scan.hasNext())
			{
				
				rows = new int[R][];
				for(int r=0;r<R;r++){
					//String[] l = in.readLine().split("	");
					String[] l = scan.nextLine().split("	");
					rows[r] = new int[l.length];
					for(int i=0;i<l.length;i++){
						rows[r][i] = Integer.parseInt(l[i]);
					}
					//num++;
				}
				// read columns
				cols = new int[C][];
				for(int c=0;c<C;c++){
					//String[] l = in.readLine().split("	");
					String[] l = scan.nextLine().split("	");
					cols[c] = new int[l.length];
					for(int i=0;i<l.length;i++){
						cols[c][i] = Integer.parseInt(l[i]);
					}
					//num++;
				}
			
				grid = new long[R];
				
			}
			// Precalc
			rowPerms = new long[R][];
			for(int r=0;r<R;r++){
				LinkedList<Long> res = new LinkedList<Long>();
				int spaces = C - (rows[r].length-1);
				for(int i=0;i<rows[r].length;i++){
					spaces -= rows[r][i];
				}
				calcPerms(r, 0, spaces, 0, 0,res);
				if(res.isEmpty()){
					throw new RuntimeException("Impossible to find solution with row "+r);
				}
				rowPerms[r] = new long[res.size()];
				while(!res.isEmpty()){
					rowPerms[r][res.size()-1]=res.pollLast();
				}
			}
			// Calculate
			colVal = new int[R][C];
			colIx = new int[R][C];
			mask = new long[R];
			val = new long[R];
			if(dfs(0)){
				// Print
				for(int r=0;r<R;r++){
					for(int c=0;c<C;c++){
						System.out.print((grid[r]&(1L<<c))==0 ? EMPTY : FILLED);
						fw.write((grid[r]&(1L<<c))==0 ? EMPTY : FILLED);
						fw.flush();
					}
					//System.out.printLine();
					System.out.println();
					fw.write("\r\n");
					fw.flush();

				}
			}else{
				
				System.out.println("No solution was found");
				fw.write("No solution was found\r\n");
			}
			System.err.println("Time: "+(System.currentTimeMillis()-startTime)+"ms");
			
		}
		
	}
	
	static int[][]colVal, colIx;
	static long[] mask, val;
	static boolean dfs(int row){
		if(row==R){
			return true;
		}
		rowMask(row); // calculate mask to stay valid in the next row
		for(int i=0;i<rowPerms[row].length;i++){
			if((rowPerms[row][i]&mask[row])!=val[row]){
				continue;
			}
			grid[row] = rowPerms[row][i];
			updateCols(row);
			if(dfs(row+1)){
				return true;
			}
		}
		return false;
	}
	
	static void rowMask(int row){
		mask[row]=val[row]=0;
		if(row==0){
			return;
		}
		long ixc=1L;
		for(int c=0;c<C;c++,ixc<<=1){
			if(colVal[row-1][c] > 0){
				// when column at previous row is set, we know for sure what has to be the next bit according to the current size and the expected size
				mask[row] |= ixc; 
				if(cols[c][colIx[row-1][c]] > colVal[row-1][c]){
					val[row] |= ixc; // must set
				}
			}else if(colVal[row-1][c] == 0 && colIx[row-1][c]==cols[c].length){
				// can not add anymore since out of indices
				mask[row] |= ixc;
			}
		}
	}
	static void updateCols(int row){
		long ixc = 1L;
		for(int c=0;c<C;c++,ixc<<=1){
			// copy from previous
			colVal[row][c]=row==0 ? 0 : colVal[row-1][c];
			colIx[row][c]=row==0 ? 0 : colIx[row-1][c];
			if((grid[row]&ixc)==0){
				if(row > 0 && colVal[row-1][c] > 0){ 
					// bit not set and col is not empty at previous row => close blocksize
					colVal[row][c]=0;
					colIx[row][c]++;
				}
			}else{
				colVal[row][c]++; // increase value for set bit
			}
		}
	}
	
	static void calcPerms(int r, int cur, int spaces, long perm, int shift, LinkedList<Long> res){
		if(cur == rows[r].length){
			if((grid[r]&perm)==grid[r]){
				res.add(perm);				
			}
			return;
		}
		while(spaces>=0){
			calcPerms(r, cur+1, spaces, perm|(bits(rows[r][cur])<<shift), shift+rows[r][cur]+1,res);
			shift++;
			spaces--;
		}
	}
	
	static long bits(int b){
		return (1L<<b)-1; // 1 => 1, 2 => 11, 3 => 111, ...
	}
	
}