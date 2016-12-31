import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/******
 * 
A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

 * 
 * 
 * */


public class Le_305_Number_of_Islands_II {
	// using Union Find time complexity is O(n^2 + k), space O(n^2)
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new LinkedList<>();
        
        if (m <=0 || n <= 0) {
            return ans;
        }
        
        UnionFind uf = new UnionFind(m, n);
        int count = 0;
        int[][] island = new int[m][n];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int len = positions.length;
        
        for (int i = 0; i < len; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            
            if (island[x][y] == 0) {
                count++;
                island[x][y] = 1;
                int currentId = convertToId(x, y, n);
                
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && island[newX][newY] == 1) {
                        int newId = convertToId(newX, newY, n);
                        int currentParent = uf.Find(currentId);
                        int newParent = uf.Find(newId);
                        
                        if (currentParent != newParent) {
                            count--;
                            uf.Union(currentParent, newParent);
                        }
                    }
                }
            }
            
            ans.add(count); 
        }
        
        return ans;
    }
    
    public int convertToId(int x, int y, int col) {
        return x * col + y;
    }
    
    class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();
        
        public UnionFind(int row, int col) {
            for (int i = 0; i < row * col; i++) {
                father.put(i, i);
            }
        }
        
        public int Find(int x) {
            int parent = father.get(x);
            
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            
            int tempParent = -1;
            int fa = x;
            
            while (fa != father.get(fa)) {
                tempParent = father.get(fa);
                father.put(fa, parent);
                fa = tempParent;
            }
            
            return parent;
        }
        
        public void Union(int x, int y) { 
            int parentX = father.get(x);
            int parentY = father.get(y);
            
            if (parentX != parentY) {
                father.put(parentX, parentY);
            }
        }
    }
}
