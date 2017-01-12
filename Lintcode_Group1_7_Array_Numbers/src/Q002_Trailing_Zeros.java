
public class Q002_Trailing_Zeros {
	// by other
	public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
        	System.out.println("sum = " + sum);
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
	
	
	/******************************************************/
	// by other, faster
    public long trailingZeroes2(long n) {
    	if(n < 5) return 0;
    	return n / 5 + trailingZeroes2(n / 5);
    }
	
	
	public static void main(String[] args){
		Q002_Trailing_Zeros t = new Q002_Trailing_Zeros();
		System.out.println(t.trailingZeros(10));
	}
}
