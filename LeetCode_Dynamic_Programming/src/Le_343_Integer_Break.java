/******
 * 
Given a positive integer n, break it into the sum of at least two positive integers 
and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

 * 
 * */

public class Le_343_Integer_Break {
	// 2和3必须单独处理, 因为只有2，3时，其分割后相乘值会小于它本身，而当2，3用作其他数的拆分因子时，又要用作因子2，3相乘
	// 如： memo[2] = 2, memo[3] = 3, 实际2, 3拆分后最大乘积为 1, 2 !!!
	public int integerBreak(int n) {
        if(n == 2 || n == 3) {  
            return n - 1;       
        }
        
        int[] memo = new int[n + 1];
		memo[2] = 2;
		memo[3] = 3;
		
		for(int i = 4; i <= n; i++){
			for(int j = 1; j <= i/2; j++){
				memo[i] = Math.max(memo[i], memo[j] * memo[i - j]);
			}			
		}
		
		return memo[n];
    }
	
	
	
	
	
	
	
	
	
	
	
	/**************************************/
	//by other use dp
	public int integerBreak2(int n) {
        if (n == 2 || n == 3){
        	return n - 1;
        }

        int[] prod = new int[n+1];
        prod[2] = 2;
        prod[3] = 3;
        for (int i = 4; i <= n; ++i) {
            prod[i] = Math.max(prod[i/2] * prod[i - i/2], Math.max(prod[i-2] * prod[2], prod[i-3] * prod[3]));
        }
        return prod[n];
    }    
    
	
	
	/******************** main ******************/
    public static void main(String[] args){
    	Le_343_Integer_Break t = new Le_343_Integer_Break();
    	System.out.println(t.integerBreak(8));
//    	System.out.println(t.integerBreak2(28));
    }
}
