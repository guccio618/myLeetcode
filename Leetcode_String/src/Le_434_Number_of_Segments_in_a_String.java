/********
 *  
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.

Example:
	Input: "Hello, my name is John"
	Output: 5
 * 
 * */

public class Le_434_Number_of_Segments_in_a_String {
	// test case: [],  [    ],  [a],  [ab ac],  [ ab ]
    
	//solution 1: using function of lib
    public int countSegments(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        s = s.trim();   
        return s.length() == 0 ? 0 : s.split("\\s{1,}").length;
    }
    
    
    
    // solution 2: using string operation
    public int countSegments2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int index = 0, len = s.length();
        
        while(index < len) {
            if(s.charAt(index) != ' ') {
                count++;
                
                while(index < len && s.charAt(index) != ' ') {
                    index++;
                }
            }
            
            while(index < len && s.charAt(index) == ' ') {
                index++;
            }
        }
        
        return count;
    }
    
    
    
    
    
    
    
    
    
    /******************************** main function ***************************************/
    
    public static void main(String[] args) {
    	Le_434_Number_of_Segments_in_a_String t = new Le_434_Number_of_Segments_in_a_String();
    	String s = "Hello, my name is John";
    	String s2 = "    ";
    	System.out.println(t.countSegments(s2));
    }
}
