import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 


public class rw { 
static int[][]rows,cols;
public static void main(String[] args) throws FileNotFoundException { 
	
	File file = new File("input.txt"); 
	Scanner scan=new Scanner(file); 
	
	
	String input;
    while(scan.hasNextLine())	
    {		
	
		input=scan.nextLine();
		System.out.println(input);
	
		String[] l = new String[100]; 
		String[] ll = new String[100];
	
		int num = 0;
		int r = 0;
		int c = 0;
		while (scan.hasNext()){ 
	    
			if(num==50) {
				break;
			}	
			l = scan.nextLine().split("	");
		
		
			if(num<25)
			{
				rows = new int[30][];
				rows[r] = new int[l.length];	
				for(int i=0;i<l.length;i++){
					rows[r][i] = Integer.parseInt(l[i]);
					System.out.print(rows[r][i]);
				}
				System.out.println();
				r++;
			}
			else 
			{
				cols = new int[30][];			
				cols[c] = new int[l.length];
				for(int i=0;i<l.length;i++){
					cols[c][i] = Integer.parseInt(l[i]);
					System.out.print(cols[c][i]);
				}
				System.out.println();
				c++;
			}
			num++;
		} // while hasNext
	}	// while hasNextLine
	} // main
} //class