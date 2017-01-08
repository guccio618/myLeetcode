/******
 * 
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

Example:
	n = 10, I pick 6.
	Return 6.

 * 
 * */

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


