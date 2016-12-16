/***********
 * 
Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4.
 * 
 * */


public class Le_221_Maximal_Square {
	/*****************************************************************************
	 * 	State:    dp[i][j]: row = i, col = j 时的最大矩阵边长;
	 * 	Function: dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
	 * 	Initial:  dp[0][j] = matrix[0][j] - '0',  dp[i][0] = matrix[i][0] - '0';
	 * 	Answer:   max(dp[i][j]) ^ 2;
	 * 
	 *****************************************************************************/
	// solution 1: DP, time O(n^2), space O(n^2)
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        
        for(int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i] - '0';
            maxLen = Math.max(maxLen, dp[0][i]);
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        
        return maxLen * maxLen;
    }
	
	
	
	
	
	// solution 2: 空间优化 space O(n)
	public int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[2][col];
		int maxLen = 0;

		for (int i = 0; i < col; ++i) {
			dp[0][i] = matrix[0][i] - '0';
			maxLen = Math.max(maxLen, dp[0][i]);
		}

		for (int i = 1; i < row; ++i) {
			dp[i % 2][0] = matrix[i][0] - '0';
			maxLen = Math.max(maxLen, dp[i % 2][0]);

			for (int j = 1; j < col; ++j) {
				if (matrix[i][j] == '1') { // 对DP矩阵优化过程中，matrix[i][j]中使用i，而不是 i%2
					dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
					maxLen = Math.max(maxLen, dp[i % 2][j]);
				} else {
					dp[i % 2][j] = 0;      // 空间优化后，必须要update 零值 ！！！
				}
			}
		}

		return maxLen * maxLen;
	}
	
	
	
	/**********************************************************
	 * follow up 求矩阵中最大的对角线矩阵的面积：
	 * 		diagonal[i][j]: row = i, col = j 时的最大对角矩阵边长
	 * 		up[i][j]: row = i, col = j 位置，向上延伸，0的最长长度
	 * 		left[i][j]: row = i, col = j 位置，向左延伸，0的最长长度
	 * 		亦可空间优化。
	 * 
	 **********************************************************/

	public int maximalDiagonal(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] diagonal = new int[row][col];
		int[][] left = new int[row][col];
		int[][] up = new int[row][col];
		diagonal[0][0] = matrix[0][0] - '0';
		up[0][0] = left[0][0] = 1 - diagonal[0][0];
		int maxLen = Math.max(0, diagonal[0][0]);
		
		for(int i = 1; i < row; ++i){
			diagonal[i][0] = matrix[i][0] - '0';
			maxLen = Math.max(maxLen, diagonal[i][0]);
			left[i][0] = 1 - diagonal[i][0];
			up[i][0] = (matrix[i][0] == '0') ? up[i - 1][0] + 1 : 0;
		}
		
		for(int i = 1; i < col; ++i){
			diagonal[0][i] = matrix[0][i] - '0';
			maxLen = Math.max(maxLen, diagonal[0][i]);
			up[0][i] = 1 - diagonal[0][i];
			left[0][i] = (matrix[0][i] == '0') ? left[0][i - 1] + 1 : 0;
		}
		
		for(int i = 1; i < row; ++i){
			for(int j = 1; j < col; ++j){
				if(matrix[i][j] == '1'){
					diagonal[i][j] = Math.min(diagonal[i - 1][j - 1], Math.min(up[i - 1][j], left[i][j - 1])) + 1;
					maxLen = Math.max(maxLen, diagonal[i][j]);
					up[i][j] = 0;
					left[i][j] = 0;
				} else {
					diagonal[i][j] = 0;
					up[i][j] = up[i - 1][j] + 1;
					left[i][j] = left[i][j - 1] + 1;
				}
			}
		}
		
		return maxLen * maxLen;
	}
	
	
	
	/************************* main function ******************************/
	
	public static void main(String[] args){
		Le_221_Maximal_Square t = new Le_221_Maximal_Square();
		char[][] matrix = {
				{'1', '0', '0'},
				{'1', '1', '0'},
				{'1', '1', '1'},
		};
		
		char[][] matrix2 = {
				{'1', '0', '0'},
				{'0', '1', '0'},
				{'0', '0', '1'},
		};
		
		char[][] matrix3 = {
				{'1', '0', '0'},
				{'1', '1', '0'},
				{'1', '1', '0'},
		};
		
		char[][] matrix4 = {
				{'1'}
		};
		
		char[][] matrix5 = {
				{'0', '0', '0'},
				{'0', '0', '0'},
				{'1', '1', '1'},
		};
		
		char[][] matrix6 = {
				{'1', '1', '1'},
		};
		
		System.out.print(t.maximalSquare(matrix) + ", ");
		System.out.println(t.maximalDiagonal(matrix));
		
		System.out.print(t.maximalSquare(matrix2) + ", ");
		System.out.println(t.maximalDiagonal(matrix2));
		
		System.out.print(t.maximalSquare(matrix3) + ", ");
		System.out.println(t.maximalDiagonal(matrix3));
		
		System.out.print(t.maximalSquare(matrix4) + ", ");
		System.out.println(t.maximalDiagonal(matrix4));
		
		System.out.print(t.maximalSquare(matrix5) + ", ");
		System.out.println(t.maximalDiagonal(matrix5));
		
		System.out.print(t.maximalSquare(matrix6) + ", ");
		System.out.println(t.maximalDiagonal(matrix6));
	}
}
