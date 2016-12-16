/*******
 * 
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 * 
 * */

public class Le_329_Longest_Increasing_Path_in_a_Matrix {
	/*******************************************************************
	 * 矩阵搜索题通常考虑2种辅助做法，(1). visited  (2). memoSearch
	 * 此题需要求出长度，因此用visited时间复杂度不佳，重复计算比较多；
	 * memoSearch比较适合此题，可以去除重复计算； bfs遍历
	 *  
	 *******************************************************************/
	
	public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length, col = matrix[0].length;
        int[][] memo = new int[row][col];
        int maxLen = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxLen = Math.max(maxLen, memoSearch(matrix, memo, i, j));
            }
        }
        
        return maxLen;
    }
    
    public int memoSearch(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] > 0) {
            return memo[x][y];
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[x][y] < matrix[newX][newY]) {
                memo[x][y] = Math.max(memo[x][y], memoSearch(matrix, memo, newX, newY));
            }
        }
        
        memo[x][y] += 1;
        return memo[x][y];
    }
    
    
    
    
    
    
    
    
    
	
	/**************************************************************/
	// by other
	int[][] dis = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[][] state = new int[matrix.length][matrix[0].length];
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res = Math.max(res, dfs(i, j, matrix, state));
			}
		}
		return res;
	}

	public int dfs(int i, int j, int[][] matrix, int[][] state) {
		if (state[i][j] > 0) {
			return state[i][j];
		}
		
		int max = 0;
		for (int m = 0; m < dis.length; m++) {
			if (i + dis[m][0] >= 0 && i + dis[m][0] < matrix.length
					&& j + dis[m][1] >= 0 && j + dis[m][1] < matrix[0].length
					&& matrix[i + dis[m][0]][j + dis[m][1]] > matrix[i][j]) {
				max = Math.max(max,
						dfs(i + dis[m][0], j + dis[m][1], matrix, state));
			}
		}
		state[i][j] = 1 + max;
		return state[i][j];

	}
}
