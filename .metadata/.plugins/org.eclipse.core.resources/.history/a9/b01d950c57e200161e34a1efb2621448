/******************************************************
 * 利用移位操作
 * 
 ******************************************************/

public class Le_029_Divide_Two_Integers {
	public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
        
        long divd = Math.abs((long) dividend);
		long divs = Math.abs((long) divisor);
        int result = 0;
        
        while(divd >= divs){
            int count = 0; 
            while(divd >= (divs << count)){
                count++;
            }
            count--;
            result += 1 << count;
            divd -= divs << count;
        }
        
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            return result;
        } else {
            return -result;
        }
    }
}
