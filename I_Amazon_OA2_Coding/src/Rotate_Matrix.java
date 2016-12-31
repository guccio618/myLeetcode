
public class Rotate_Matrix {
	public int[][] rotate(int[][] matrix, int flag) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        
        int start = 0, end = matrix.length - 1;
        int row = matrix.length, col = matrix[0].length;
        int[][] ansMatrix = new int[row][col];
        
        for (int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++){
        		ansMatrix[i][j] = matrix[i][j];
        	}
        }
        
        while(start < end){
        	if(flag == 1){
        		for(int i = 0; i < end - start; i++){
                    int temp = ansMatrix[start][start + i];
                    ansMatrix[start][start + i] = ansMatrix[end - i][start];   // row -> col ！！！
                    ansMatrix[end - i][start] = ansMatrix[end][end - i];
                    ansMatrix[end][end - i] = ansMatrix[start + i][end];
                    ansMatrix[start + i][end] = temp;
                }
        	} else {
        		for(int i = 0; i < end - start; i++){
                    int temp = ansMatrix[start][start + i];
                    ansMatrix[start][start + i] = ansMatrix[start + i][end];   // col -> row ！！！
                    ansMatrix[start + i][end] = ansMatrix[end][end - i];
                    ansMatrix[end][end - i] = ansMatrix[end - i][start];
                    ansMatrix[end - i][start] = temp;
                }
        	}
                       
            start++;
            end--;
        }
        
        return ansMatrix;
    }
	
	
	
	
	
	// solution 2
	public int[][] Solution(int[][] matrix, int flag) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  return matrix;
        //int m = matrix.length, n = matrix[0].length;
        int[][] rvalue;
        rvalue = transpose(matrix);
        flip(rvalue, flag);
        return rvalue;
    }

    private int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rvalue = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                rvalue[i][j] = matrix[j][i];
        return rvalue;
    }

    private void flip(int[][] matrix, int flag) {
        int m = matrix.length, n = matrix[0].length;
        if (flag == 1) {    //clock wise
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n / 2; j++) {
                    matrix[i][j] ^= matrix[i][n-j-1];
                    matrix[i][n-j-1] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[i][n-j-1];
                }
        }
        else {
            for (int i = 0; i < m / 2; i++)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] ^= matrix[m-i-1][j];
                    matrix[m-i-1][j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[m-i-1][j];
                }
        }
    }
    
    
    
    
	
	public static void main(String[] args){
		Rotate_Matrix t = new Rotate_Matrix();
		int[][] matrix = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		
		int flag = 1;
		int[][] ans = t.rotate(matrix, flag);
		int len = matrix.length;
		
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				System.out.print(ans[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		int[][] matrix2 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		
		matrix2 = t.Solution(matrix2, flag);
		
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				System.out.print(matrix2[i][j] + ", ");
			}
			System.out.println();
		}
		
	}
}
