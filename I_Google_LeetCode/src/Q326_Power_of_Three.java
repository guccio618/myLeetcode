/******
 * 
Given an integer, write a function to determine if it is a power of three.

Follow up:
	Could you do it without using any loop / recursion?
	
 * 
 * */

public class Q326_Power_of_Three {
	// solution 1: using looop
	public boolean isPowerOfThree(int n) {
        while(n > 1){
            if(n % 3 != 0){
                return false;
            } else {
                n /= 3;
            }
        }
        
        return n == 1;
    }
	
	// follow up, solution 2: using bit manipulation
	public boolean isPowerOfThree2(int n) {
		if(n <= 0) return false;
        return  (1162261467 / n == 1162261467 / (double)n); 
    }
	
	
	
	
	
	
	
	
	
	/*********************** main function ******************************/
	
	public static void main(String[] args){
		Q326_Power_of_Three t = new Q326_Power_of_Three();
		System.out.println(t.isPowerOfThree(27));
	}
}
