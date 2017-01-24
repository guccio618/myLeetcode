/********
 * 
Determine whether an integer is a palindrome. 
Do this without extra space.
 * 
 * */

public class Q009_Palindrome_Number {
	public static boolean isPalindrome(int x) {
		if(x < 0 || x >= Integer.MAX_VALUE){
            return false;
        }
        
        int sum = 0, tempNum = x;
        
        while(tempNum != 0){  // 123
            sum = sum * 10 + tempNum % 10;
            tempNum /= 10;
        }
        
        return sum == x;
	}
	
	
	
	
	
	
	
	
	
	/****************************** main function **********************************/
	
	public static void main(String[] args){
		Q009_Palindrome_Number t = new Q009_Palindrome_Number();
		System.out.println(t.isPalindrome(12345));
	}
}
