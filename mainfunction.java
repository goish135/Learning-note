// ref:https://github.com/Samjayyy/logicpuzzles/tree/master/nonogram
public static void main(String[] args) throws Exception {
		final InputReader in = new InputReader(System.in);
		final OutputWriter out = new OutputWriter(System.out);
		// 設定盤面長寬
		// 25*25 的 nonogram
		R = 25;
		C = 25;
		long startTime = System.currentTimeMillis();
		{

			rows = new int[R][];
			for(int r=0;r<R;r++){
				String[] l = in.readLine().split("	");
				rows[r] = new int[l.length];
				for(int i=0;i<l.length;i++){
					rows[r][i] = Integer.parseInt(l[i]); // 第r列第i個的"連續黑塊的大小"
				}
			}
			
			cols = new int[C][];
			for(int c=0;c<C;c++){
				String[] l = in.readLine().split("	");
				cols[c] = new int[l.length];
				for(int i=0;i<l.length;i++){
					cols[c][i] = Integer.parseInt(l[i]); // 第r行第i個的"連續黑塊的大小"
				}
			}
			grid = new long[R];
		}
		// 計算 所有 每一row(依條件) 的組合 並將組合放入res裡
		rowPerms = new long[R][];
		for(int r=0;r<R;r++){
			LinkedList<Long> res = new LinkedList<Long>();
			int spaces = C - (rows[r].length-1);
			for(int i=0;i<rows[r].length;i++){
				spaces -= rows[r][i];
			}
			calcPerms(r, 0, spaces, 0, 0,res); // 使用遞迴的方法找出列組合 => p1
			if(res.isEmpty()){
				throw new RuntimeException("Impossible to find solution with row "+r);
			}
			rowPerms[r] = new long[res.size()];
			while(!res.isEmpty()){
				rowPerms[r][res.size()-1]=res.pollLast();
			}
		}
		// 使用DFS(深先法) 求出最後答案 => p2
		colVal = new int[R][C];
		colIx = new int[R][C];
		mask = new long[R];
		val = new long[R];
		if(dfs(0)){
			// Print
			for(int r=0;r<R;r++){
				for(int c=0;c<C;c++){
					out.print((grid[r]&(1L<<c))==0 ? EMPTY : FILLED);
				}
				out.printLine();
			}
		}else{
			out.printLine("No solution was found");
		}
		System.err.println("Time: "+(System.currentTimeMillis()-startTime)+"ms");
		out.close();
	}
 	
