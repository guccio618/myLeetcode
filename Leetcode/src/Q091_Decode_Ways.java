/*****
 * 
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

 * 
 ***/


public class Q091_Decode_Ways {
	/**********************************************
	 * 1. decode way取决于当前digit和前一个digit的值
	 * 2. 当前digit分三种情况： 0, 1~6, 7~9
	 * 
	 **********************************************/
	
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int[] ways = new int[len+1];
        ways[0] = 1;
        ways[1] = (s.charAt(0) == '0') ? 0 : 1;
        
        for(int i = 2; i <= len; i++) {
            int prevNum = s.charAt(i-2) - '0';
            int num = s.charAt(i-1) - '0';
            
            if(num == 0) {
                if(prevNum == 1 || prevNum == 2) {
                    ways[i] = ways[i-2];
                } else {
                    return 0;
                }
            } else if(num > 0 && num <= 6) {
                if(prevNum == 1 || prevNum == 2) {
                    ways[i] = ways[i-1] + ways[i-2];
                } else {
                    ways[i] = ways[i-1];
                }
            } else {
                if(prevNum == 1) {
                    ways[i] = ways[i-1] + ways[i-2];
                } else {
                    ways[i] = ways[i-1];
                }
            }
        }
        
        return ways[len];  
    }
	
	
	
	
	
	
	
	
	
	
	/*******************************************************/
	public int numDecodings2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;                 // 额外加一位，用于结果输出 ！！！
        memo[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; --i){
            if(s.charAt(i) == '0'){  // 注意当其为0时，memo[i] = 0;
                continue;
            }
            memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
        }
        
        return memo[0];
    }
	
	
	
	
	public static void main(String[] args){
		Q091_Decode_Ways t = new Q091_Decode_Ways();
		System.out.println(t.numDecodings("199"));
	}
}
