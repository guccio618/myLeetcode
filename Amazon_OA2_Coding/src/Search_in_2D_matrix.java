public class Search_in_2D_matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row * col - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int x = mid / col;
            int y = mid % col;
            
            if(matrix[x][y] > target) {
                end = mid;
            } else if(matrix[x][y] < target) {
                start = mid;
            } else {
                return true;
            }
        }
        
        if(matrix[start / col][start % col] == target || matrix[end / col][end % col] == target) {
            return true;
        } else {
            return false;   
        }
    }
}
