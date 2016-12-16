
public class Maximum_Minimum_Path {
	// DFS
	public int solution(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		
		// index 0: local min, index 1: global max
		int[] minArray = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		DFS(matrix, minArray, 0, 0);
		return minArray[1];
	}
	
	public void DFS(int[][] matrix, int[] minArray, int x, int y){
		if(x >= matrix.length || y >= matrix[0].length){
			return ;
		} else if(x == matrix.length - 1 && y == matrix[0].length - 1){
			minArray[0] = Math.min(minArray[0], matrix[x][y]);
			minArray[1] = Math.max(minArray[1], minArray[0]);
			return ;
		}
		
		minArray[0] = Math.min(minArray[0], matrix[x][y]);
		DFS(matrix, minArray, x + 1, y);
		DFS(matrix, minArray, x, y + 1);
	}
	
	
	// DP
	public int solution2(int[][] matrix) {
		int[] result = new int[matrix[0].length];
		result[0] = matrix[0][0];
		int row = matrix.length, col = matrix[0].length;
		
		for (int i = 1; i < col; i++) {
			result[i] = Math.min(result[i - 1], matrix[0][i]);
		}
		
		for (int i = 1; i < row; i++) {
			result[0] = Math.min(matrix[i][0], result[0]);
			
			for (int j = 1; j < col; j++) {
				result[j] = (result[j] < matrix[i][j] && result[j - 1] < matrix[i][j]) ? Math.max(result[j - 1], result[j]) : matrix[i][j];
			}
		}
		
		return result[result.length - 1];
	}
	
	public int solution3(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		int[][] ans = new int[row][col];
		ans[0][0] = matrix[0][0];
		
		
		for (int i = 1; i < col; i++) {
			ans[0][i] = Math.min(ans[0][i - 1], matrix[0][i]);
		}
		
		for (int i = 1; i < row; i++) {
			ans[i][0] = Math.min(ans[i - 1][0], matrix[0][i]);
		}
		
		for (int i = 1; i < row; i++) {
//			ans[0] = Math.min(matrix[i][0], ans[0]);
			
			for (int j = 1; j < col; j++) {
				ans[i][j] = (ans[i - 1][j] < matrix[i][j] && ans[i][j - 1] < matrix[i][j]) ? Math.max(ans[i][j - 1], ans[i - 1][j]) : matrix[i][j];
			}
		}
		
		return ans[row - 1][col - 1];
	}
	
	
	
	
	
	
	
	
	
	
	/*******************************************************************************/
	public static void main(String[] args){
		Maximum_Minimum_Path t = new Maximum_Minimum_Path();
		int[][] matrix = {
				{8, 4, 7},
				{6, 5, 9}
		};
		
		System.out.println(t.solution(matrix));
		System.out.println(t.solution2(matrix));
		System.out.println(t.solution3(matrix));
	}
}
