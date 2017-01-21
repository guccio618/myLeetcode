import java.util.*;
/******
 * 
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally 
or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

 * 
 * */

public class Le_200_Number_of_Islands {
	/*******************************************************************
	 * 矩阵搜索题通常考虑2种辅助做法，(1). visited  (2). memoSearch
	 * 矩阵找上下左右相邻的状态，通常考虑用dfs，可以用visited辅助
	 * 此题也可以用union find, 但效率比较低
	 *  
	 *******************************************************************/

	// solution 1: using DFS, no need to change the grid[][], time complexity O(n^m), space O(n^m)
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
    
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '1' && visited[i][j] != true){
                    helper(grid, visited, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void helper(char[][] grid, boolean[][] visited, int x, int y){
        if(visited[x][y] == true){
            return;
        }
        
        visited[x][y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int row = grid.length;
        int col = grid[0].length; 
        
        for(int i = 0; i < 4; ++i){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1'){
                helper(grid, visited, newX, newY);
            }
        }
    }
    
    
    
    // solution 2: need to change the grid[][], time complexity O(n^m), space O(1)
 	public int numIslands2(char[][] grid) {
         if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
             return 0;
         }
         
         int row = grid.length;
         int col = grid[0].length;
         int count = 0;
         
         for(int i = 0; i < row; ++i){
             for(int j = 0; j < col; ++j){
                 if(grid[i][j] == '1'){
                     removeHelper(grid, i, j);
                     count++;
                 }
             }
         }
         
         return count;
     }
     
     public void removeHelper(char[][] grid, int x, int y){
         int[] dx = {1, -1, 0, 0};
         int[] dy = {0, 0, 1, -1};
         int row = grid.length;
         int col = grid[0].length;
         grid[x][y] = '0';
         
         for(int i = 0; i < 4; ++i){
             int newX = x + dx[i];
             int newY = y + dy[i];
             if(newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1'){
                 removeHelper(grid, newX, newY);
             }
         }
     }
    
    
   
     
    // solution 3: using Union_Find
     public int numIslands3(char[][] grid) {
         if(grid == null || grid.length == 0 || grid[0].length == 0) {
             return 0;
         }
         
         int row = grid.length, col = grid[0].length;
         int count = 0;
         UnionFind uf = new UnionFind(row, col);
         int[] dx = {0, -1};
         int[] dy = {-1, 0};
         
         for(int x = 0; x < row; x++) {
             for(int y = 0; y < col; y++) {
                 if(grid[x][y] == '1') {
                     count++;
                     int curId = x * col + y;
                     
                     for(int k = 0; k < 2; k++) {
                         int newX = x + dx[k];
                         int newY = y + dy[k];
                         
                         if(newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == '1') {
                             int newId = newX * col + newY;
                             int curFa = uf.find(curId);
                             int newFa = uf.find(newId);
                             
                             if(curFa != newFa) {
                                 uf.union(curFa, newFa);
                                 count--;
                             }
                         }
                     }
                 }
             }
         }
         
         return count;
     }
     
     class UnionFind {
         private Map<Integer, Integer> father;
         
         public UnionFind(int row, int col) {
             father = new HashMap<>();
             
             for(int x = 0; x < row; x++) {
                 for(int y = 0; y < col; y++) {
                     int id = x * col + y;
                     father.put(id, id);
                 }
             }
         }
         
         public int find(int x) {
             int parent = father.get(x);
             
             while(parent != father.get(parent)) {
                 parent = father.get(parent);
             }
             
             int temp = -1;
             int fa = x;
             
             while(fa != father.get(fa)) {
                 temp = father.get(fa);
                 father.put(fa, parent);
                 fa = temp;
             }
             
             return parent;
         }
         
         public void union(int x, int y) {
             int fa_x = find(x);
             int fa_y = find(y);
             
             if(fa_x != fa_y) {
                 father.put(fa_x, fa_y);
             }
         }
     }
}	
