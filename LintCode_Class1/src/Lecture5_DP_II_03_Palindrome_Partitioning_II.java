
public class Lecture5_DP_II_03_Palindrome_Partitioning_II {
	/******************************************************************************************
	 * 此题含两个动态规划，一个是序列型动态规划f[i]，另一个是区间型动态规划dp[i][j];
	 * 		区间型动态规划通常先求出小区间，继而用小区间来求出大的区间
	 * 
	 * 		(1). 区间型动态规划 dp[i][j]
	 * 			state:     boolean f[i][j] 表示从i到j是否是回文数;
	 * 			function:  f[i][j] = f[i+1][j-1] && str.charAt(i) == str.charAt(j);
	 * 			initial:   f[i][i] = true && f[i][i+1] = (str.charAt(i) == str.charAt(i+1)); 
	 * 
	 * 		(2). 序列型动态规划 f[i]
	 * 			state:     f[i] 表示从起点到i最少的回文切割次数;
	 * 			function:  f[i] = Math.max(f[i], f[j]+1)， 其中 j < i 且 dp[j+1][i]是回文数;
	 * 			initial:   f[0] = -1 && f[1] = 0;
	 * 			answer:    f[str.length];
	 * 
	 ******************************************************************************************/
	
	public static int minCut(String s){
	    if(s == null || s.length() == 0){
	        return 0;
	    }
	    
	    boolean[][] dp = isPalindrome(s);
	    int len = s.length();
	    int[] f = new int[len+1];
	    
	 // 初始化，表示每个字符串都可以被视为一个回文切割
	    for(int i = 0; i <= len; ++i){
	        f[i] = i-1;
	    }
	    
	    for(int i = 1; i <= len; ++i){
	        for(int j = 0; j < i; ++j){
	            if(dp[j][i-1] == true){
	                f[i] = Math.min(f[i], f[j] + 1);
	            }
	        }
	    }
	    return f[len];
    }
	
	public static boolean[][] isPalindrome(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        
        for(int i = 0; i < len-1; ++i){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }
        
        // 区间类型动态规划，从小区间开始，算大区间; 因此用length做循环参数；相当于按长度从小到大的顺序分别进行计算，之后用长度为2的推长度为3的 
        // 不能用i从0开始，因为f[i][j] = f[i+1][j-1],因为f[i+1]还未被计算出来
        // 另一种写法为： for(int i = n-3； i >= 0; ++i)
        //                 for(int j = n-1; j > i+1; --j)
        //                     dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
        for(int length = 2; length < len; ++length){
            for(int start = 0; start + length < len; ++start ){
                dp[start][start+length] = dp[start+1][start+length-1] && (s.charAt(start) == s.charAt(start+length));
            }
        }
        
        return dp;
    }
}
