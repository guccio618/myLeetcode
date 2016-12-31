import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Lecture5_Dynamic_Programming_07_Longest_Increasing_continuous_Subsequence_2D {
	public int longestIncreasingContinuousSubsequenceII(int[][] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxLen = 1;
        int row = nums.length;
        int col = nums[0].length;
        int[][] dp = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<node> minHeap = new PriorityQueue<node>(1, new Comparator<node>(){
            public int compare(node left, node right){
                return left.val - right.val;
            }
        });
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                minHeap.add(new node(i, j, nums[i][j]));
                dp[i][j] = 1;
            }
        }
        
        while(!minHeap.isEmpty()){
            node tempNode = minHeap.poll();
            visited[tempNode.x][tempNode.y] = true;
            for(int i = 0; i < 4; ++i){
                int newX = tempNode.x + dx[i];
                int newY = tempNode.y + dy[i];
                if(newX >= 0 && newX < row && newY >= 0 && newY < col && visited[newX][newY] == true){
                    if(tempNode.val > nums[newX][newY]){
                        dp[tempNode.x][tempNode.y] = Math.max(dp[tempNode.x][tempNode.y], dp[newX][newY] + 1);
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[tempNode.x][tempNode.y]);
        } 
        
        return maxLen;
    }
    
    class node{
        int x;
        int y;
        int val;
        
        public node(int x, int y, int v){
            this.x = x;
            this.y = y;
            val = v; 
        }
    }
}
