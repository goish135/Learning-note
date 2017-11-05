//ref:https://github.com/Samjayyy/logicpuzzles/tree/master/nonogram

static void updateCols(int row){
		long ixc = 1L;
		for(int c=0;c<C;c++,ixc<<=1){
			// row==0 (最一開始)設為0 ,其他要參考上一row的情況 所以"copy上一row" 
			colVal[row][c]=(row==0 ? 0 : colVal[row-1][c]);
			colIx[row][c]=(row==0 ? 0 : colIx[row-1][c]);
			
			if((grid[row]&ixc)==0){ // check 格子[row][column] 是否沒塗 
				if(row > 0 && colVal[row-1][c] > 0){ 
					colVal[row][c]=0; // 產生斷點
					colIx[row][c]++;  // 供rowMask check是否完成某一column的條件
				}
			}else{
				colVal[row][c]++; // 有塗 做累加
			}
		}
}