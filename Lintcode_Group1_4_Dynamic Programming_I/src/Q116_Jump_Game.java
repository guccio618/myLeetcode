
public class Q116_Jump_Game {
	// by Jackie using DP
	public boolean canJump(int[] A) {
		if(A == null || A.length == 0){
		    return true;
		}
		boolean[] dp = new boolean[A.length];
		dp[0] = true;
		
		for(int i = 1; i < A.length; ++i){
		    for(int j = 0; j < i; ++j){
		        if(dp[j] == true && A[j] + j >= i){
		            dp[i] = true;
		            break;
		        }
		    }
		}
		return dp[A.length-1];
	}
	
	// by ninechapter using greedy
	public boolean canJump2(int[] A) {
		if(A == null || A.length == 0){
		    return true;
		}
		int fastest = A[0];
		
		for(int i = 0, len = A.length; i < len; ++i){
		    if(i <= fastest && i + A[i] > fastest){
		        fastest = i + A[i];
		    }
		    if(fastest >= len - 1){
		        return true;
		    }
		}
		return (fastest >= A.length - 1);
	}
}
