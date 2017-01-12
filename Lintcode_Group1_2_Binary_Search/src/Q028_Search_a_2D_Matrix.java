
public class Q028_Search_a_2D_Matrix {
	// by Jackie
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0, right = row * column - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2; 
            if(target > matrix[mid / column][mid % column]){
                left = mid;
            }
            else if(target < matrix[mid / column][mid % column]){
                right = mid;
            }
            else{
                return true;
            }
        }
        
        if(matrix[left / column][left % column] == target){
        	return true;
        } else if(matrix[right / column][right % column] == target){
        	return true;
        }
        return false;
    }
}
