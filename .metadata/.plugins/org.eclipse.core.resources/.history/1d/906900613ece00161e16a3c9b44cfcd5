/*******
 * 
 Given an integer, write a function to determine if it is a power of two.
 
 * 
 * */

public class Q231_Power_of_Two {
	// solution 1 
	public boolean isPowerOfTwo2(int n) {
		if (n < 1) {
            return false;
        }
        
        int count = 0;
        
        for (int i = 0; i < 32; i++) {
            count += ((n >> i) & 1);
        }
        
        return count == 1;
    }
	
	
	
		
	// solution 2
	public boolean isPowerOfTwo(int n) {
		if(n <= 0){
	    	return false;
	    } else {
	    	return (n & (n - 1)) == 0;
	    }
	}
	
	
	
	
	
	
	
	
	
	/**************************** main function *******************************/
	
	public static void main(String[] args){
		Q231_Power_of_Two test = new Q231_Power_of_Two();
		System.out.println(test.isPowerOfTwo(1));
	}
}
