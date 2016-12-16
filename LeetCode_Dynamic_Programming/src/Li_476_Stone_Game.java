
public class Li_476_Stone_Game {
	/************************************************************************
	 * 此题在[i,j]区间求合并花费，取决于[i, k]，[k+1, j]区间内的状态；由于k不固定，因此为
	 * 区间类动态规划。
	 * 
	 * Statement: 
	 * 		sum[i][j]: 表示本次合并i到j所花费的总花费
	 * 		cost[i][j]:  表示把第i到第j个石子合并到一起的最小花费
	 * Function: cost[i][j] = cost[i][k] + cost[k + 1][j] + sum[i][j]
	 * Initial:  cost[i][i] = 0;
	 * Answer:   cost[0][n-1]
	 * 
	 ************************************************************************/
	
	public int stoneGame(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[][] cost = new int[len][len];
        int[][] sum = new int[len][len];  // i到j的石子总和
        
        for(int i = 0; i < len; i++){
    		for(int j = i; j < len; j++){
    			sum[i][j] = (i == j) ? nums[i] : sum[i][j - 1] + nums[j];
    		}
    	}
    	
    	for(int length = 1; length < len; length++){
    		for(int start = 0; start + length < len; start++){
    			int end = start + length;
    			cost[start][end] = Integer.MAX_VALUE;
    			
    			for(int i = start; i < end; i++){
    				cost[start][end] = Math.min(cost[start][end], cost[start][i] + cost[i + 1][end] + sum[start][end]);
    			}
    		}
    	}
    	
    	return cost[0][len - 1];
    }
}
