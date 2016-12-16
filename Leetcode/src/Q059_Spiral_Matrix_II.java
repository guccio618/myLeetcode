
public class Q059_Spiral_Matrix_II {
	// by Jackie
	public int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }
        
        int[][] ans = new int[n][n];
        int num = 1;
        int row_start = 0, row_end = n - 1;
        int col_start = 0, col_end = n - 1;
        
        while(row_start <= row_end && col_start <= col_end){
            for(int i = col_start; i <= col_end; ++i){
                ans[row_start][i] = num++;
            }
            row_start++;
            
            for(int i = row_start; i <= row_end; ++i){
                ans[i][col_end] = num++;
            }
            col_end--;
                     
            for(int i = col_end; i >= col_start; --i){
                ans[row_end][i] = num++;
            }
            row_end--;
            
            for(int i = row_end; i >= row_start; --i){
                ans[i][col_start] = num++;
            }
            col_start++;
        }
        return ans;
    }
}
