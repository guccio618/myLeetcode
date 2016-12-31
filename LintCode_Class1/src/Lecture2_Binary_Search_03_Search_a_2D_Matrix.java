
public class Lecture2_Binary_Search_03_Search_a_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0, right = row * column - 1;
        
        while(left <= right){
            int mid = (left + right) / 2; 
            if(target > matrix[mid / column][mid % column]){
                left = mid + 1;
            }
            else if(target < matrix[mid / column][mid % column]){
                right = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
