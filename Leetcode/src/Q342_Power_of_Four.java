
public class Q342_Power_of_Four {
	public boolean isPowerOfFour(int num) {
        if(num <= 0){
            return false;
        }
        
        int diff = 0;
        
        while(num > 1 && diff == 0){
            diff = num % 4;
            num /= 4;
        }
        
        return diff == 0;
    }
}
