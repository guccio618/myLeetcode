
public class Q231_Power_of_Two {
	//by other
	public boolean isPowerOfTwo(int n) {
		if(n <= 0){
            return false;
        } else {
            return (n & (n - 1)) == 0;
        }
    }
	
	
	
	// by Jackie
	public boolean isPowerOfTwo2(int n) {
		if(n < 1){
            return false;
        } else if(n == 1){
            return true;
        }
        
        int count = 0;
        for(int i = 0; i < 32; i++){
        	count += (n >> i) & 1;
        }
        
        return count == 1;
    }
	
	public static void main(String[] args){
		Q231_Power_of_Two test = new Q231_Power_of_Two();
		System.out.println(test.isPowerOfTwo(1));
	}
}
