/********
 * 
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 * 
 * */

public class Le_400_Nth_Digit {
	public int findNthDigit(int n) {
        if(n <= 9) {
            return n;
        }
        
        int digitCount = 1;
        int startNum = 1;
        long base = 9;
        
        while(n > base * digitCount) {
            n -= base * digitCount;
            base *= 10;
            digitCount++;
            startNum *= 10;
        }
        
        int curNum = startNum + (n - 1) / digitCount;
        int index = (n - 1) % digitCount;
        return Integer.toString(curNum).charAt(index) - '0';
    }
	
	
	
	
	
	
	
	
	
	
	/***************************** main function **************************************/
	
	public static void main(String[] args){
		Le_400_Nth_Digit t = new Le_400_Nth_Digit();
		System.out.println(t.findNthDigit(11));
//		System.out.println(t.findNthDigit(2147483647));
	}
	
	
	// 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23
}
