//ref:https://github.com/Samjayyy/logicpuzzles/tree/master/nonogram
/*
3 3
1
1
1
1
3
1
correct is: no answer,but
rum result is:
100
010
010
*/
static boolean dfs(int row){
		if(row==R){
			return true;
		}
		rowMask(row); // rowMask(0):直接return ，其他可依updateCols做判斷而設定mask(for check when bit==1)和value
		for(int i=0;i<rowPerms[row].length;i++){ //rowPerms save 所有列排列
			if((rowPerms[row][i]&mask[row])!=val[row]){ // &mask 做檢查(查詢) 不等於已確認的話直接進下一個列排列
				continue;
			}
			grid[row] = rowPerms[row][i];
			updateCols(row); // colVal:紀錄目前行條件(其中之一)中佔了幾格 ，when colVal被歸零 colIx++
			                 // colIx可判斷是否已達那一col的所有條件
			if(dfs(row+1)){  // 往下一row去搜尋，直到最後一個row =>return true或中途發現沒有proper的列排列 return false =>可能沒答案或往下繼續搜尋
				return true;
			}
		}
		return false;
}
