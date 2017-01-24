import java.util.*;
/*******
 * 
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

 * 
 * */
public class Q407_Trapping_Rain_Water_II {
	public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        Queue<Pair> minHeap = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.height - p2.height;
            }
        });
        
        int row = heightMap.length, col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            minHeap.offer(new Pair(i, 0, heightMap[i][0]));
            minHeap.offer(new Pair(i, col - 1, heightMap[i][col - 1]));
            visited[i][0] = visited[i][col - 1] = true;
        }
        
        for (int i = 0; i < col; i++) {
            minHeap.offer(new Pair(0, i, heightMap[0][i]));
            minHeap.offer(new Pair(row - 1, i, heightMap[row - 1][i]));
            visited[0][i] = visited[row - 1][i] = true;
        }
        
        while (!minHeap.isEmpty()) {
            Pair currentNode = minHeap.poll();
            
            for (int i = 0; i < 4; i++) {
                int newX = currentNode.x + dx[i];
                int newY = currentNode.y + dy[i];
                
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && visited[newX][newY] == false) {
                    visited[newX][newY] = true;
                    minHeap.offer(new Pair(newX, newY, Math.max(currentNode.height, heightMap[newX][newY])));
                    count += Math.max(0, currentNode.height - heightMap[newX][newY]);
                }
            }
        }
        
        return count;
    }
    
    class Pair {
        int x;
        int y;
        int height;
        
        public Pair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
