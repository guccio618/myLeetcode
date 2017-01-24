
public class Q006_ZigZag_Conversion {
	/****************************************************************************/	
	//by jackie using stringbuffer
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
	
	
	
	/****************************************************************************/
	//by NineChapter
	public String convert2(String s, int numRows) {  
        int length = s.length();
        if (length <= numRows || numRows == 1) {
        	return s;
        }
        
        char[] chars = new char[length];
        int step = 2 * (numRows - 1);
        int count = 0;
        
	    for (int i = 0; i < numRows; i++){
    		int interval = step - 2 * i;
    		for (int j = i; j < length; j += step){
    		   	chars[count] = s.charAt(j);
    			count++;
    			if (interval < step && interval > 0 && j + interval < length && count <  length){
    				chars[count] = s.charAt(j + interval);
    				count++;
    			}
    		}
    	}
	    
        return new String(chars);
    }
	
	
	
	/****************************************************************************/	
	//by jackie
	public String convert3(String s, int numRows) {  
        if(s.length() == 0 || numRows == 0 || numRows == 1){
        	return s;
        }
		if(numRows >= s.length()) {
			return s;
		}
		
        String[] array = new String[numRows];
		String res = "";
		int direct = 0, k = 0;
		
		for(int i = 0; i < numRows; i++) {
			array[i] = "";		
		}
		
		for(int i = 0; i < s.length(); i++){
			if(k < 0) {
				direct = 1; 
				k += 2;
			} else if(k == numRows) {
				direct = -1; 
				k -= 2;
			}
			
			if(direct == 1) {
				array[k++] += s.charAt(i);
			} else {
				array[k--] += s.charAt(i);
			}
		}	
		
		for(int i = 0; i < numRows; i++) {
			res += array[i];
		}
		
		return res;
    }
	
	public static void main(String[] args){
		Q006_ZigZag_Conversion z = new Q006_ZigZag_Conversion();
		String str = "ABCDE";
		System.out.println(z.convert(str, 2));
	}
}
