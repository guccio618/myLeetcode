/******
 * 
Implement strStr().

Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

 * 
 * */




public class Le_028_Implement_strStr {
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        } else if (haystack.length() <= needle.length()) {
            if (haystack.equals(needle)) {
                return 0;
            } else {
                return -1;
            }
        } else if (needle.length() == 0) {
            return 0;
        }
        
        int len1 = haystack.length();
        int len2 = needle.length();
        
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int index = 0;
                
                while (index < len2) {
                    if (haystack.charAt(i + index) == needle.charAt(index)) {
                        index++;
                    } else {
                        break;
                    }
                }
                
                if (index == len2) {
                    return i;
                }
            }
        }
        
        return -1;
    }
	
	
	
	
	
	
	public static void main(String[] args){
		Le_028_Implement_strStr is = new Le_028_Implement_strStr();
		String str1 = "mississippi", str2 = "issi";
		System.out.println(is.strStr(str1, str2));	
	}
}
