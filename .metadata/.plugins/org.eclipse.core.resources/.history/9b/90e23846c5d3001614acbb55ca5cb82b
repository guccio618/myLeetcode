
public class Q374_Guess_Number_Higher_or_Lower {
	private static int target = 3;
	
	public int guessNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int left = 1, right = n;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);
            
            if(result < 0) {
                right = mid;
            } else if(result > 0) {
                left = mid;
            } else {
                return mid;
            }
        }
        
        if(guess(left) == 0) {
            return left;
        } else {
            return right;
        }
    }
	
	public int guess(int num) {
		if(num == target) {
			return 0;
		} else if(num > target) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		Q374_Guess_Number_Higher_or_Lower t = new Q374_Guess_Number_Higher_or_Lower();
		System.out.println(t.guessNumber(10));
	}
}


