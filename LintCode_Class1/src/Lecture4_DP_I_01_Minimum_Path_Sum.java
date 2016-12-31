
public class Lecture4_DP_I_01_Minimum_Path_Sum {
	/***************************************************************************************
	 * 坐标型动态规划
	 * 	  	只能往右或往下移动
	 * 		state:     sum[i][j] 表示跳到grid[i][j]时的最短路径;
	 * 		function:  sum[i][j] = Math(sum[i－1][j], sum[i][j-1]) + grid[i][j];
	 * 		initial:   sum[0][0] = grid[0][0] && sum[0][j] = sum[0][j-1] + grid[0][j];
	 * 											 sum[i][0] = sum[i-1][0] + grid[i][0];
	 * 		answer:    sum[m-1][n-1];
	 * 
	 ***************************************************************************************/
	
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }
}
