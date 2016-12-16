
public class Le_050_Pow_x_n {
	// 不用单独考虑 x < 0 的情况
	public double myPow(double x, int n) {
        if(n == 0 || x == 1){  // test case: 
            return 1;
        } else if(x == -1){    // test case: 
            return ((long) n % 2 == 1) ? -1 : 1;
        } else if(x == 0 || n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE){
            return 0;
        }
        
        int flag_n = n > 0 ? 1 : -1;
        n = n < 0 ? -n : n;
        double sum = 1;
        
        while(n > 1){
            if(n % 2 == 1){
                sum *= x;
            }
            x = x * x;
            n /= 2;
        }
        
        sum *= x;
        if(flag_n == -1){
            sum = 1.0 / sum;
        }
        
        return sum;
    }
}
