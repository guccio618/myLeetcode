
public class Le_463_Island_Perimeter {
	// solution 1: using DFS, TLE
	public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }    
        
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    return DFS(grid, visited, i, j);
                }
            }
        }
        
        return 0;
    }
    
    public int DFS(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int curCount = getGridPerimeter(grid, x, y);
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == 1) {
                curCount += DFS(grid, visited, newX, newY);
            }
        }
        
        return curCount;
    }
    
    public int getGridPerimeter(int[][] grid, int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                continue;
            } else {
                count++;
            }
        }
        
        return count;
    }
    
    
    
    /***********************************************************************
    * 1. loop over the matrix and count the number of islands;
    * 2. if the current dot is an island, count if it has any right neighbour or down neighbour;
    * 3. the result is islands * 4 - neighbours * 2
    * 
    * each island grid has four sides, and just need to count right neighbour or down neighbour;
    * each neighbours pairs have two sides. 
    ************************************************************************/
    // solution 2: 
    public int islandPerimeter2(int[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        } 
    	
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;      // count islands
                    
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {    // count down neighbours
                    	neighbours++; 
                    }
                    
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {  // count right neighbours
                    	neighbours++; 
                    }
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /********************************** main function *************************************/
    
    public static void main(String[] args) {
    	Le_463_Island_Perimeter t = new Le_463_Island_Perimeter();
    	int[][] grid = {
    			{0,1,0,0},
    			{1,1,1,0},
    			{0,1,0,0},
    			{1,1,0,0}
    	};
    	
    	System.out.println(t.islandPerimeter(grid));
    }
}
