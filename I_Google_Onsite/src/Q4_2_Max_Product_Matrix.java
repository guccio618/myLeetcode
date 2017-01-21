public class Q4_2_Max_Product_Matrix {
	public int getMaxProductMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int row = matrix.length, col = matrix[0].length;
		int[][] maxMatrix = new int[row][col];
		int[][] minMatrix = new int[row][col];
		maxMatrix[0][0] = minMatrix[0][0] = matrix[0][0];
		
		for(int i = 1; i < row; i++) {
			maxMatrix[i][0] = maxMatrix[i - 1][0] * matrix[i][0];
			minMatrix[i][0] = minMatrix[i - 1][0] * matrix[i][0];
		}
		
		for(int j = 1; j < col; j++) {
			maxMatrix[0][j] = maxMatrix[0][j - 1] * matrix[0][j];
			minMatrix[0][j] = minMatrix[0][j - 1] * matrix[0][j];
		}
		
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(matrix[i][j] > 0) {
					maxMatrix[i][j] = Math.max(maxMatrix[i - 1][j] * matrix[i][j], maxMatrix[i][j - 1] * matrix[i][j]);
					minMatrix[i][j] = Math.min(minMatrix[i - 1][j], minMatrix[i][j - 1]) * matrix[i][j];
				} else {
					maxMatrix[i][j] = Math.max(minMatrix[i - 1][j] * matrix[i][j], minMatrix[i][j - 1] * matrix[i][j]);
					minMatrix[i][j] = Math.min(maxMatrix[i - 1][j] * matrix[i][j], maxMatrix[i][j - 1] * matrix[i][j]);
				}
			}
		}
		
		return maxMatrix[row - 1][col - 1];
	}
	
	
	
	
	
	
	/******************************* main function ************************************/
	
	public static void main(String[] args) {
		Q4_2_Max_Product_Matrix t = new Q4_2_Max_Product_Matrix();
		int[][] matrix = {
				{1,5,2},
				{8,-6,3},
				{4,-7,9}
		};
		
		System.out.println(t.getMaxProductMatrix(matrix));
	}
}
