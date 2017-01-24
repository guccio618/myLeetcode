/******
 * 
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

 * 
 * */

public class Q066_Plus_One {
	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            int[] ans = new int[1];
            ans[0] = 1;
            return ans;
        }
        
        int len = digits.length;
        digits[len - 1] += 1;
        int flag = digits[len - 1] / 10;
        digits[len - 1] %= 10;
        
        for (int i = digits.length - 2; i >= 0; i--) {
            digits[i] += flag;
            flag = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if (flag == 1) {
            int[] ans = new int[len + 1];
            ans[0] = 1;
            
            for (int i = 0; i < len; i++) {
                ans[i + 1] = digits[i];
            }
            
            return ans;
        } else {
            return digits;
        }
    }
	
	
	
	
	
	
	/****************************** main function ********************************/
	
	public static void main(String[] args){
		Q066_Plus_One t = new Q066_Plus_One();
		int[] digits = {9};
		int[] ans = t.plusOne(digits);
		
		for(int i = 0; i < ans.length; ++i){
			System.out.print(ans[i]);
		}
	}
}
