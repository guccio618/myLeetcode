
public class Q038_Search_a_2D_Matrix_II {
	/********
	 * Star
	 ********/
	
	// by Jackie
	// 从左下角或右上角开始，一次排除一行或一列
	public int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]){
            return 0;
        }
        int row = matrix.length, column = matrix[0].length;
        int x = row - 1, y = 0, count = 0;
        
        while(x >= 0 && y < column){
            if(target > matrix[x][y]){
                y++;
            }
            else if(target < matrix[x][y]){
                x--;
            }
            else{
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}
