import java.util.*;
/*****
 * 
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
	There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
	
 * 
 * */

public class Le_317_Shortest_Distance_from_All_Buildings {
	/***************************************************************************************************************
	 * The main idea is the following:
	 * 		Traverse the matrix. For each building, use BFS to compute the shortest distance from each '0' to 
	 * 		this building. After we do this for all the buildings, we can get the sum of shortest distance
	 * 		from every '0' to all reachable buildings. This value is stored in 'distance[][]'. 
	 * 		For example, if grid[2][2] == 0, distance[2][2] is the sum of shortest distance from this block to all reachable buildings.
	 * 		Time complexity: O(number of 1)O(number of 0) ~ O(m^2 * n^2)
	 * 
	 * 		We also count how many building each '0' can be reached. It is stored in reach[][]. This can be done during the BFS. 
	 * 		We also need to count how many total buildings are there in the matrix, which is stored in 'buildingNum'.
	 * 		Finally, we can traverse the distance[][] matrix to get the point having shortest distance to all buildings. O(m*n)
	 * 		The total time complexity will be O(m^2 * n^2), which is quite high!. Please let me know if I did the analysis wrong or you have better solution.
	 * 
	 ****************************************************************************************************************/
	
	public int shortestDistance(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
	    int row = grid.length, col = grid[0].length;
	    int[][] dist = new int[row][col];  // total distance for each "0"
	    List<Tuple> buildings = new ArrayList<>();
	    
	    // Initialize building list and accessibility matrix `grid`
	    // record how many buildings it can reach for each "0"
	    // put 1 and 2 to -1 and -2
	    for (int i = 0; i < row; ++i) {
	        for (int j = 0; j < col; ++j) {
	            if (grid[i][j] == 1) {
	                buildings.add(new Tuple(i, j, 0));
	            }
	            grid[i][j] = -grid[i][j];
	        }
	    }
	    
	    // BFS from every building
	    for (int k = 0; k < buildings.size(); ++k) {
	        bfs(buildings.get(k), k, dist, grid, row, col);
	    }
	    
	    // Find the minimum distance
	    int ans = -1;
	    
	    for (int i = 0; i < row; ++i) {
	        for (int j = 0; j < col; ++j) {
	            if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans)) {
	                ans = dist[i][j];
	            }
	        }
	    }
	    
	    return ans;
	}
	
	// BFS, k means currently how many building it can reach
	public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int row, int col) {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
	    Queue<Tuple> queue = new LinkedList<>();
	    queue.add(root);
	    
	    while (!queue.isEmpty()) {
	        Tuple t = queue.poll();
	        dist[t.y][t.x] += t.distance;
	        
	        for (int i = 0; i < 4; ++i) {
	            int newX = t.x + dx[i];
	            int newY = t.y + dy[i];
	            
	            if (newX >= 0 && newX < col && newY >= 0 && newY < row && grid[newY][newX] == k) {
	                grid[newY][newX] = k + 1;
	                queue.add(new Tuple(newY, newX, t.distance + 1));
	            }
	        }
	    }
	}
	
	class Tuple {
	    public int y;
	    public int x;
	    public int distance;

	    public Tuple(int y, int x, int distance) {
	        this.y = y;
	        this.x = x;
	        this.distance = distance;
	    }
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Le_317_Shortest_Distance_from_All_Buildings t = new Le_317_Shortest_Distance_from_All_Buildings();
		int[][] grid = {
				{1,0,2,0,1}, 
				{0,0,0,0,0},
				{0,0,1,0,0}
		};
		
		System.out.println(t.shortestDistance(grid));
	}
}
