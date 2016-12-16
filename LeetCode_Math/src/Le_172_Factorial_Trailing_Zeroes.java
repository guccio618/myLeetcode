
public class Le_172_Factorial_Trailing_Zeroes {
	public int trailingZeroes(int n) {
        int ans = 0;
        
        while(n > 0){
            n /= 5;
            ans += n;
        }
        
        return ans;
    }
}
