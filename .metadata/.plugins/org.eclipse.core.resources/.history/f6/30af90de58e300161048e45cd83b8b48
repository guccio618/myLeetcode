/*******
 * 
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: 
	Do not use any built-in library function such as sqrt.

Example 1:
	Input: 16
	Returns: True

Example 2:
	Input: 14
	Returns: False
	
 * 
 * */

public class Q367_Valid_Perfect_Square {
	// test case:
    // 		num < 1
    // 		num == 1
    // 		num == Integer.MAX_VALUE
    
	// using Binary Search
    public boolean isPerfectSquare(int num) {
        if(num < 1) {
            return false;
        } else if(num == 1) {
            return true;
        }
        
        long left = 1, right = num;
        
        while(left + 1 < right) {
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            
            if(product > (long) num) {
                right = mid;
            } else if(product < (long) num) {
                left = mid;
            } else {
                return true;
            }
        }
        
        if(left * left == (long) num || (right * right) == (long) num) {
            return true;
        } else {
            return false;
        }
    }
}
