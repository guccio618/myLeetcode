
public class Lecture4_DP_I_02_Unique_Paths {
	/***************************************************************************************
	 * 坐标型动态规划
	 * 	  	只能往右或往下移动
	 * 		state:     sum[i][j] 表示跳到点 (i,j) 时的路径数;
	 * 		function:  sum[i][j] = sum[i－1][j] + sum[i][j-1];
	 * 		initial:   sum[i][0] = 1 & sum[0][j] = 1;
	 * 		answer:    sum[m-1][n-1];
	 * 
	 ***************************************************************************************/
	
	public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }
}
