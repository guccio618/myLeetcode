
public class Lecture4_DP_I_03_Climbing_Stairs {
	/***************************************************************************************
	 * 序列型动态规划
	 * 		state:     f[i] 表示跳到i时的方案数;
	 * 		function:  f[i] = f[i-1] + f[i-2];
	 * 		initial:   f[0] = 1 & f[1] = 1;
	 * 		answer:    f[n-1];
	 * 
	 ***************************************************************************************/
	
	public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if(n == 0){
            return 1;
        }
        
        int[] f = new int[n+1];
        f[0] = f[1] = 1;
        
        for(int i = 2; i <= n; ++i){
        	f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
    }
	
	
	
	// 类似斐波纳西数列解法，time complexity is O(n) and space O(1)
	public int climbStairs2(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}
