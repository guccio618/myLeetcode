import java.util.*;
/******
 * 
Given an m x n matrix of non-negative integers representing the height of each unit cell 
in a continent, the "Pacific ocean" touches the left and top edges of the matrix and 
the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another 
one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic 
ocean.

Note:
	The order of returned grid coordinates does not matter.
	Both m and n are less than 150.

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

 * 
 * */


public class Le_417_Pacific_Atlantic_Water_Flow {
	// using DFS
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> ans = new ArrayList<>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ans;
		}

		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visitedAtlantic = new boolean[row][col];
		boolean[][] visitedPacific = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			canFlow(matrix, visitedPacific, 0, i, 0);
			canFlow(matrix, visitedAtlantic, 0, i, col - 1);
		}

		for (int j = 0; j < col; j++) {
			canFlow(matrix, visitedPacific, 0, 0, j);
			canFlow(matrix, visitedAtlantic, 0, row - 1, j);
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (visitedAtlantic[i][j] && visitedPacific[i][j]) {
					ans.add(new int[] {i, j});
				}
			}
		}

		return ans;
	}

	public void canFlow(int[][] matrix, boolean[][] visited, int height, int x, int y) {
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
		    int newX = x + dx[i];
		    int newY = y + dy[i];
		    
		    if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y]) {
		        canFlow(matrix, visited, matrix[newX][newY], newX, newY);
		    }
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/**************************** main function *****************************/
	public void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 },
				{ 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };

		// int[][] matrix = {
		// {1,2,3},
		// {8,9,4},
		// {7,6,5}
		// };

		Le_417_Pacific_Atlantic_Water_Flow t = new Le_417_Pacific_Atlantic_Water_Flow();
		List<int[]> ans = t.pacificAtlantic(matrix);

		for (int[] array : ans) {
			System.out.println(array[0] + ", " + array[1]);
		}
	}
}
