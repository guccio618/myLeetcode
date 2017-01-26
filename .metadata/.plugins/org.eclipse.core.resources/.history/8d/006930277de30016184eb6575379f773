
public class Le_069_Sqrt_x {
	/************************************************
	 * 二分法，查找一个mid,使得mid * mid 大于或等于x
	 * 
	 ************************************************/
	// by Jackie
	public int sqrt(int x) {
        if(x == 0){
            return 0;
        }
        long left = 1, right = x;
        
       while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(right * right <= x){
            return (int) right;
        } 
        else{
            return (int) left;
        }
    }
	
	public int mySqrt2(int x) {
        if(x <= 0){
            return 0;
        }
        
        long left = 1, right = x;
        
        while(left + 1 < right){
            long mid = left + (right - left) / 2;
            long result = mid * mid;
            
            if(result < x){
                left = mid;
            } else if(result > x){
                right = mid;
            } else {
                return (int) mid;
            }
        }
        
        if((long) (left * left) <= x){
            return (int) left;
        } else {
            return (int) right;
        }
    }
	
	
	public static void main(String[] args){
		Le_069_Sqrt_x t = new Le_069_Sqrt_x();
		System.out.println(t.mySqrt2(2147395599));
	}
}
