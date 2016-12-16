import java.util.ArrayList;
import java.util.List;


public class Le_054_Spiral_Matrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return ans;
        }

        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix[0].length - 1;
        
        while(row_start <= row_end && col_start <= col_end){  // 是&& ！！！ 注意有等号, 防止单行或单列的情况， test case: [[1]]！！！
            for(int i = col_start; i <= col_end; ++i){        // 注意有等号！！！
                ans.add(matrix[row_start][i]);
            }
            row_start++;
            
            for(int i = row_start; i <= row_end; ++i){
                ans.add(matrix[i][col_end]);
            }
            col_end--;
            
            if (row_start <= row_end) {          // 防止 test case [[2,3]],  [[2], [3]], 这里有等号 ！！！
                for(int i = col_end; i >= col_start; --i){
                    ans.add(matrix[row_end][i]);
                }
            }
            row_end--;      // 移动继续，为了可以顺利退出，不会死循环
            
            if(col_start <= col_end){            // 防止 test case [[2,3]],  [[2], [3]]
                for(int i = row_end; i >= row_start; --i){
                    ans.add(matrix[i][col_start]);
                }
            }
            col_start++;   // 移动继续，为了可以顺利退出，不会死循环
        }
        
        return ans;
    }
}
