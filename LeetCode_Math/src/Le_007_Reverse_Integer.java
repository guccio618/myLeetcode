
public class Le_007_Reverse_Integer {
	public int reverse(int x) {
        if(x == 0){
            return x;
        }
        
        int flag = (x > 0) ? 1 : -1;
        long num = x;
        num = (num > 0) ? num : -num;
        long sum = 0;
        
        while(num > 0){
            sum  = sum * 10 + num % 10;
            num /= 10;
        }
        
        sum = sum * flag;
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int) sum;
        }
    }
}
