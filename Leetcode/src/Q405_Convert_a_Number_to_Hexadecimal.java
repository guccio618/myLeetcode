/*******
 * 
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:
	All letters in hexadecimal (a-f) must be in lowercase.
	The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
	The given number is guaranteed to fit within the range of a 32-bit signed integer.
	You must not use any method provided by the library which converts/formats the number to hex directly.

Example 1:
	Input:  26
	Output:	"1a"
	
Example 2:
	Input:	-1
	Output:	"ffffffff"
	
 * 
 * */


public class Q405_Convert_a_Number_to_Hexadecimal {
	// test case: [0],  [-1],  [-2] -> "fffffffe", [1],  [26],  [291]
    
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        } 
            
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder builder = new StringBuilder();
        
        while(num > 0) {
            builder.insert(0, digits[(num & 15)]);
        }
        
        return builder.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*********************************** main function *****************************************/
    
    public static void main(String[] args) {
    	Q405_Convert_a_Number_to_Hexadecimal t = new Q405_Convert_a_Number_to_Hexadecimal();
    	int num = -1;
    	System.out.println(t.toHex(num));
    }
}
