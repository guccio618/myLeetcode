import java.util.ArrayList;
import java.util.List;

/*******
 * 
Given a triangle, find the minimum path sum from top to bottom. 
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.
 * 
 * */


public class Q120_Triangle {
	// solution 1: using DP, time O(n^2), space O(n^2)
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int row = triangle.size();
		int col = triangle.get(row - 1).size();
		int[][] cost = new int[row][col];

		for (int i = 0; i < col; i++) {
			cost[row - 1][i] = triangle.get(row - 1).get(i);
		}

		for (int i = row - 2; i >= 0; i--) {
			int size = triangle.get(i).size();

			for (int j = 0; j < size; j++) {
				cost[i][j] = Math.min(cost[i + 1][j], cost[i + 1][j + 1])
						+ triangle.get(i).get(j);
			}
		}

		return cost[0][0];
	}

	
	
	
	// solution 2: follow up, improve the space, time O(n^2), space O(n)
	public int minimumTotal2(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int row = triangle.size();
		int col = triangle.get(row - 1).size();
		int[][] cost = new int[2][col];

		for (int i = 0; i < col; i++) {
			cost[(row - 1) % 2][i] = triangle.get(row - 1).get(i);
		}

		for (int i = row - 2; i >= 0; i--) {
			int size = triangle.get(i).size();

			for (int j = 0; j < size; j++) {
				cost[i % 2][j] = Math.min(cost[(i + 1) % 2][j],
						cost[(i + 1) % 2][j + 1]) + triangle.get(i).get(j);
			}
		}

		return cost[0][0];
	}

	public static void main(String[] args) {
		Q120_Triangle t = new Q120_Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		int[][] nums = { { -1 }, { 2, 3 }, { 1, -1, -3 } };

		for (int i = 0; i < nums.length; ++i) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < nums[i].length; ++j) {
				list.add(nums[i][j]);
			}
			triangle.add(list);
		}

		System.out.println(t.minimumTotal(triangle));
	}
}
