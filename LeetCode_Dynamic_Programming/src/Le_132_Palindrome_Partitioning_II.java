/********
 * 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

 * 
 * */


public class Le_132_Palindrome_Partitioning_II {
	/**************************************************************************************************************************************************
	 * 双序列动态规划 - (String类)
	 * 		(1). 运用memo[i][j]记录从i到j是否可以划分，减少重复计算；
	 * 		(2). 运用dp[i]记录前i字符的最少切割次数
	 * 
	 **************************************************************************************************************************************************/
	public int minCut(String s) {
        if(s == null || s.length() == 0){
	    	return 0;
	    }
	    
	    int n = s.length();
	    boolean[][] memo = getMemo(s);
	    int[] cut = new int[n];
	    
	    for(int i = 0; i < n; ++i){
	        cut[i] = i;
	    }
	    
	    for(int i = 0; i < n; ++i){
	        for(int j = 0; j <= i; ++j){  // 注意这里必需有等号 ！！！
	            if(memo[j][i] == true){   // 注意此处j 和 i的顺序
	                if(j == 0){
	                    cut[i] = 0;  // 注意切割代表的意思，这里代表当前i个字符可以构成一个Palindrome时，此时的切割次数为0
	                } else {
	                    cut[i] = Math.min(cut[i], cut[j - 1] + 1);    
	                }
	            }
	        }
	    }
	    
	    return cut[n - 1];
    }
    
    public boolean[][] getMemo(String s){
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        
        for(int i = 0; i < n; ++i){
            memo[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; ++i){
            memo[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                memo[start][start + length] = memo[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        
        return memo;
    }
    
    
    
    // by Jackie using DP, O(n^3), exceed time limit
    public int minCut2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[][] cut = new int[n][n];
        
        for(int i = 0; i < n - 1; ++i){
            cut[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 0 : 1;
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                String newStr = s.substring(start, start + length + 1);
                
                if(isPalindrome(newStr) == true){
                    cut[start][start + length] = 0;
                } else {
                    cut[start][start + length] = length;
                    
                    for(int k = start; k < start + length; ++k){
                        cut[start][start + length] = Math.min(cut[start][start + length], cut[start][k] + cut[k + 1][start + length] + 1);
                    }
                }
            }
        }
        
        return cut[0][n - 1];
    }
    
    public boolean isPalindrome(String word){
        int n = word.length();
        int left = 0, right = n - 1;
        
        while(left < right){
            if(word.charAt(left) == word.charAt(right)){
                left++;
                right--;
            } else{
                break;
            }
        }
        
        return (left >= right);
    }
    
    
    public static void main(String[] args){
    	Le_132_Palindrome_Partitioning_II t = new Le_132_Palindrome_Partitioning_II();
    	String s = "ewewqewqeqwewqeqe";
    	System.out.println(t.minCut(s));
    	System.out.println(t.minCut2(s));
    }
}
