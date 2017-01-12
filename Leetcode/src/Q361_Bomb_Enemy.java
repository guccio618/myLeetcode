/*******
 * 
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)

 * 
 * */

public class Q361_Bomb_Enemy {
	public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length, col = grid[0].length;
        int rowCount = 0;
        int[] colsCount = new int[col];
        int maxCount = 0;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 'W') {
                    continue;
                }
                
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = getEnemy(grid, i, j, true);
                }
                
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colsCount[j] = getEnemy(grid, i, j, false);
                }
                
                if(grid[i][j] == '0') {
                    maxCount = Math.max(maxCount, rowCount + colsCount[j]);
                }
            }
        }
        
        return maxCount;
    }
    
    public int getEnemy(char[][] grid, int x, int y, boolean byRow) {
        int count = 0;
        
        if(byRow) {
            for(int i = y; i < grid[0].length && grid[x][i] != 'W'; i++) {
                if(grid[x][i] == 'E') {
                    count++;
                }
            }
        } else {
            for(int i = x; i < grid.length && grid[i][y] != 'W'; i++) {
                if(grid[i][y] == 'E') {
                    count++;
                }
            }
        }
        
        return count;
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /****************************** main function *************************************/
	// by Jackie using DP
	public int maxKilledEnemies2(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo_up = new int[row][col];
        int[][] memo_down = new int[row][col];
        int[][] memo_left = new int[row][col];
        int[][] memo_right = new int[row][col];
        int ans = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 'W'){
                    memo_up[i][j] = memo_left[i][j] = 0;
                } else if(grid[i][j] == 'E') {
                	if(i > 0){
                		memo_up[i][j] = memo_up[i - 1][j] + 1;
                	} else {
                		memo_up[i][j] = 1;
                	}
                	if(j > 0){
                		memo_left[i][j] = memo_left[i][j - 1] + 1;
                	} else {
                		memo_left[i][j] = 1;
                	}                    
                } else {
                	if(i > 0){
                		memo_up[i][j] = memo_up[i - 1][j];
                	} else {
                		memo_up[i][j] = 0;
                	}
                	if(j > 0){
                		memo_left[i][j] = memo_left[i][j - 1];
                	} else {
                		memo_left[i][j] = 0;
                	}   
                }
            }
        }
        
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(grid[i][j] == 'W'){
                    memo_down[i][j] = memo_right[i][j] = 0;
                } else if(grid[i][j] == 'E') {
                	if(i == row - 1){
                		memo_down[i][j] = 1;
                	} else {
                		memo_down[i][j] = memo_down[i + 1][j] + 1;
                	}
                	if(j == col - 1){
                		memo_right[i][j] = 1;
                	} else {
                		memo_right[i][j] = memo_right[i][j + 1] + 1;
                	}                  
                } else {
                	if(i == row - 1){
                		memo_down[i][j] = 0;
                	} else {
                		memo_down[i][j] = memo_down[i + 1][j];
                	}
                	if(j == col - 1){
                		memo_right[i][j] = 0;
                	} else {
                		memo_right[i][j] = memo_right[i][j + 1];
                	}
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '0'){
                    ans = Math.max(ans, memo_up[i][j] + memo_down[i][j] + memo_left[i][j] + memo_right[i][j]);
                }       
            }
        }
        
        return ans;
    }
	
	
	
	public static void main(String[] args){
		Q361_Bomb_Enemy t = new Q361_Bomb_Enemy();
		char[][] grid = {
//				{'0','E','0','0'},
//				{'E','0','W','E'},
//				{'0','E','0','0'},
				{'0', 'E'}
		};
		
		System.out.println(t.maxKilledEnemies(grid));
		
	}
}
