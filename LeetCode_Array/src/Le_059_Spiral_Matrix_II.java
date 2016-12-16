
public class Le_059_Spiral_Matrix_II {
	public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int row_start = 0, row_end = n - 1, col_start = 0, col_end = n - 1;
        int index = 1;
        
        while(col_start <= col_end && row_start <= row_end){     // 注意有等号！！！
            for(int i = col_start; i <= col_end; i++){           // 注意有等号！！！
                ans[row_start][i] = index++;
            }
            row_start++;
            
            for(int i = row_start; i <= row_end; i++){
                ans[i][col_end] = index++;
            }
            col_end--;
            
            for(int i = col_end; i >= col_start; i--){
                ans[row_end][i] = index++;
            }
            row_end--;
            
            for(int i = row_end; i >= row_start; i--){
                ans[i][col_start] = index++;
            }
            col_start++;
        }
        
        return ans;
    }
}
