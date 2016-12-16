
public class Q311_Sparse_Matrix_Multiplication {
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
