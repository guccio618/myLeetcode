
public class Q11_2_Print_Zigzag_Matrix {
	public void printZigzagMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		
		int row = matrix.length, col = matrix[0].length;
		
		for(int j = 0; j < col; j++) {
			if(j % 2 == 0) {
				for(int i = 0; i < row; i++) {
					System.out.print(matrix[i][j] + " ");
				}
			} else {
				for(int i = row - 1; i >= 0; i--) {
					System.out.print(matrix[i][j] + " ");
				}
			}
			
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	/******************************* main function **********************************/
	
	public static void main(String[] args) {
		Q11_2_Print_Zigzag_Matrix t = new Q11_2_Print_Zigzag_Matrix();
		int[][] matrix = {
				{1,8,9,16,17},
				{2,7,10,15,18},
				{3,6,11,14,19},
				{4,5,12,13,20},
				
		};
		
		t.printZigzagMatrix(matrix);
	}
}
