/*********
 * 
Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

 * 
 * */


public class Q397_Integer_Replacement {
	// solution 1: using recursion
	public int integerReplacement(int n) {
        if(n <= 0){
			return 0;
		} else if(n == Integer.MAX_VALUE){
			return 32;
		}
		
		int count = 0;
		
		while(n > 1 && (n & 1) == 0){
			n >>>= 1;
			count++;
		}
			
		if(n > 1){
			count++;
			int num1 = integerReplacement(n + 1);
			int num2 = integerReplacement(n - 1);
			count += Math.min(num1, num2);		
		}
		
		return count;
    }
	
	
	
	/*********************************************************************************************************************************
	 * When n is odd it can be written into the form n = 2k+1 (k is a non-negative integer.). 
	 * That is, n+1 = 2k+2 and n-1 = 2k. Then, (n+1)/2 = k+1 and (n-1)/2 = k. So one of (n+1)/2 and (n-1)/2 is even, the other is odd.
	 * so we can conclude that one of (n+1) and (n-1) can be divided by 2 and the other can be divided by 4.
	 * And the "best" case of this problem is to divide as much as possible. 
	 * Because of that, always pick n+1 or n-1 based on if it can be divided by 4. 
	 * The only special case of that is when n=3 you would like to pick n-1 rather than n+1.
	 * 
	 *********************************************************************************************************************************/
	
	// solution 2: using manipulation
	public int integerReplacement2(int n) {
        if(n <= 0) {
            return 0;
        } else if(n == Integer.MAX_VALUE) {
            return 32;
        }
        
        int count = 0;
        
        while(n > 1) {
            count++;
            
            if(n % 2 == 0) {
                n >>>= 1;
            } else {
                if((n + 1) % 4 == 0 && n != 3) {
                    n += 1;
                } else {
                    n -= 1;
                }
            }
        }
        
        return count;
    }
}
