/********
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * 
 * */

public class Le_006_ZigZag_Conversion {
	// solution 1: using stringbuffer
	public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 1 || numRows > s.length()){
            return s;
        }
        
        StringBuffer[] builders = new StringBuffer[numRows];
        int n = s.length();
        int pos = 0;
        
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuffer();
        }
        
        while(pos < n){
            for(int index = 0; index < numRows && pos < n; ++index){
                builders[index].append(s.charAt(pos));
                pos++;
            }
            for(int index = numRows - 2; index > 0 && pos < n; --index){   // 注意从numRows - 2开始 !!!
                builders[index].append(s.charAt(pos));
                pos++;
            }
        }
        
        StringBuffer ans = new StringBuffer();
        
        for(int i = 0; i < numRows; ++i){
            ans.append(builders[i]);
        }
        
        return ans.toString();
    }
	
	
	
	// solution 2:
	public String convert2(String s, int numRows) {  
        if (s.length() <= numRows || numRows == 1) {
        	return s;
        }
        
        int len = s.length();
        char[] chars = new char[len];
        int step = 2 * (numRows - 1);
        int count = 0;
        
	    for (int i = 0; i < numRows; i++){
    		int interval = step - 2 * i;
    		
    		for (int j = i; j < len; j += step){
    		   	chars[count] = s.charAt(j);
    			count++;
    			
    			if (interval < step && interval > 0 && j + interval < len && count <  len){
    				chars[count] = s.charAt(j + interval);
    				count++;
    			}
    		}
    	}
	    
        return new String(chars);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/****************************** main function ************************************/
	
	public static void main(String[] args){
		Le_006_ZigZag_Conversion z = new Le_006_ZigZag_Conversion();
		String str = "ABCDE";
		System.out.println(z.convert(str, 2));
	}
}
