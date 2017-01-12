
public class Q111_Climbing_Stairs {
	// by Jackie
	public int climbStairs(int n) {
        if(n < 0){
            return 0;
        }
        if(n <= 1){
            return 1;
        }
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
	
	
	public static void main(String[] args){
		Q111_Climbing_Stairs t = new Q111_Climbing_Stairs();
		System.out.println(t.climbStairs(5));
	}
}
