/******
 * 
	Reverse digits of an integer.
	Example1: x = 123, return 321
	Example2: x = -123, return -321
 * 
 * */


public class Le_007_Reverse_Integer {
	// test case: -2147483648	
	
	public int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        x = Math.abs(x);
        long sum = 0;
        
        while(x > 0){
            int digit = x % 10;
            x /= 10;
            sum = sum * 10 + digit;
        }
        
        sum *= flag;
        
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int) sum;
        }
    }
	

	
	
	
	
	
	
	
	/********************************* main function *************************************/
	
	public static void main(String[] args){
		Le_007_Reverse_Integer test = new Le_007_Reverse_Integer();
		System.out.println(test.reverse(-2147483648));
	}
}
