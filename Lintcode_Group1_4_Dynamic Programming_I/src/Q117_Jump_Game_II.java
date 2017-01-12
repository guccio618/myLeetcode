
public class Q117_Jump_Game_II {
	// by Jackie using DP
	public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int len = A.length;
        int[] dp = new int[len];
        for(int i = 1; i < len; ++i){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){
                if(A[j] + j >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1); 
                }
            }
        }
        return dp[len - 1];
    }
}
