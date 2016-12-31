
public class Search_in_2D_matrix_II {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int x = 0, y = col - 1;
        
        while(x < row && y >= 0) {
            if(matrix[x][y] > target) {
                y--;
            } else if(matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
