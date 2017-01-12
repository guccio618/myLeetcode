public class Q476_Stone_Game {
	/*****************************************************************************
	 * 区间型动态规划
	 * 		state: dp[i][j] 表示合并堆中从i到j的代价; sum[i][j]表示nums[i]从i到j的和
	 * 		function: dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j]) + sum[i][j]
	 * 		initial: dp[i][i] = 0, dp[i][i + 1] = sum[i][i + 1]
	 * 		answer: dp[0][len - 1]
	 *****************************************************************************/
	// by Jackie using DP
	
	public int stoneGame(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        int[][] sum = new int[len][len];
        
        for(int i = 0; i < len; ++i){
            sum[i][i] = nums[i];
        }
        
        for(int i = 0; i < len; ++i){
            for(int j = i + 1; j < len; ++j){
                sum[i][j] = sum[i][j - 1] + nums[j];
            }
        }
        
        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len; ++j){
                if(i != j){
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int length = 1; length < len; ++length){
        	for(int start = 0; start + length < len; ++start){
        		for(int k = start; k < start + length; ++k){
        			dp[start][start + length] = Math.min(dp[start][start + length], dp[start][k] + dp[k + 1][start + length] + sum[start][start + length]);
        		}
        	}
        }

        return dp[0][len - 1];
    }
	
	
	
	
	public static void main(String[] args){
		Q476_Stone_Game t = new Q476_Stone_Game();
		int[] nums = {1,1,1,1};
		System.out.println(t.stoneGame(nums));
	}
}
