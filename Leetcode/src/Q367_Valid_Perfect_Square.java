
public class Q367_Valid_Perfect_Square {
	// by Jackie using Binary Search
	public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        } else if(num <= 3){
            return false;
        }
        
        long left = 1, right = num;
        
        while(left + 1 < right){
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            
            if(product > num){
                right = mid;
            } else if(product < num){
                left = mid;
            } else {
                return true;
            }
        }
        
        if(left * left == num || right * right == num){
            return true;
        } else {
            return false;
        }
    }
}
