import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Li_398_Longest_Increasing_Continuous_subsequence_II {
	public int longestIncreasingContinuousSubsequenceII(int[][] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int row = nums.length;
        int col = nums[0].length;
        int[][] dp = new int[row][col];
        int ans = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<Node> minHeap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                return left.val - right.val;
            } 
        });
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                minHeap.offer(new Node(i, j, nums[i][j]));
            }
        }
        
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            dp[node.x][node.y] = 1;
            
            for(int i = 0; i < 4; ++i){
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];
                if(newX >= 0 && newX < row && newY >= 0 && newY < col && dp[newX][newY] > 0 && node.val > nums[newX][newY]){
                	dp[node.x][node.y] = Math.max(dp[node.x][node.y], dp[newX][newY] + 1);
                }
            }
            
            ans = Math.max(ans, dp[node.x][node.y]);
        }
        
        return ans;
    }
    
    class Node{
        int x;
        int y;
        int val;
        
        public Node(int x, int y, int v){
            this.x = x;
            this.y = y;
            val = v;
        }
    }
    
    
    
    /****************************** main function *********************************/
    public static void main(String[] args){
    	Li_398_Longest_Increasing_Continuous_subsequence_II t = new Li_398_Longest_Increasing_Continuous_subsequence_II();
    	int[][] nums = {
    			{1 ,2 ,3 ,4 ,5},
    			{16,17,24,23,6},
    			{15,18,25,22,7},
    			{14,19,20,21,8},
    			{13,12,11,10,9}
    	};
    	
    	System.out.println(t.longestIncreasingContinuousSubsequenceII(nums));
    }
}
