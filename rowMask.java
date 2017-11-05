static void rowMask(int row){
		mask[row]=val[row]=0;
		if(row==0){
			return;
		}
		long ixc=1L; // long型態的1
		for(int c=0;c<C;c++,ixc<<=1){ // 每一bit(column)的設定
			if(colVal[row-1][c] > 0){
				// 前一row的那一column 非零(有塗黑) 
				mask[row] |= ixc; // 那一bit 必須開啟檢查模式
				if(cols[c][colIx[row-1][c]] > colVal[row-1][c]){ // 依條件 可決定下一row的那一column 要不要填
					val[row] |= ixc; // 還有多的size可填 ex:需連續填5個，but 目前只填了3個 所以下一格需填 // 驗證用
				}
			}else if(colVal[row-1][c] == 0 && colIx[row-1][c]==cols[c].length){
				// 那一col 已符合條件 所以下一row 不用塗黑
				mask[row] |= ixc; // 開啟檢查模式
			}
		}
}