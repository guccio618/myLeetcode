/*******
 * 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

 * 
 * */

public class Le_074_Searcha_2D_Matrix {
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
	
	
	
	
	
	
	
	
	/******************************* main function ********************************/
	
	public static void main(String[] args){
		Le_074_Searcha_2D_Matrix t = new Le_074_Searcha_2D_Matrix();
		int[][] matrix = {
				{-10,-10},
				{-9,-9},
				{-8,-6},
				{-4,-2},
				{0,1},
				{3,3},
				{5,5},
				{6,8}
		};
//		int[][] matrix = {{1, 3}};
		System.out.println(t.searchMatrix(matrix, -7));
	}
}
