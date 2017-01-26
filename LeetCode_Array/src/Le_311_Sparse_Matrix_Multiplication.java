/******
 *
Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
                  
 * 
 * */

public class Le_311_Sparse_Matrix_Multiplication {
	public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0){
            return new int[0][0];
        }
        
        int row1 = A.length, col1 = A[0].length;
        int row2 = B.length, col2 = B[0].length;
        int[][] ans = new int[row1][col2];
        
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col1; j++){
                if(A[i][j] != 0){
                    for(int k = 0; k < col2; k++){
                        if(B[j][k] != 0){
                            ans[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}
