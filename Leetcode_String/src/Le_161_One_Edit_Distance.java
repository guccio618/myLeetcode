/********
 * 
 Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * */

public class Le_161_One_Edit_Distance {
	// solution 1:
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null){
            if(s == null && t != null && t.length() == 1){
                return true;
            } else if(t == null && s != null && s.length() == 1){
                return true;
            } else {
                return false;
            }
        } else if(t.equals(s) == true){
            return false;
        } else if(Math.abs(t.length() - s.length()) > 1){
            return false;
        }
        
        int sLen = s.length(), tLen = t.length();
        int len = Math.min(sLen, tLen);
        int index = 0;
        
        while(index < len){
            if(s.charAt(index) != t.charAt(index)){
                break;
            } else {
                index++;
            }
        }

        if(sLen == tLen){
            return s.substring(index + 1).equals(t.substring(index + 1));
        } else if(sLen > tLen){
            return s.substring(index + 1).equals(t.substring(index));
        } else {
            return s.substring(index).equals(t.substring(index + 1));
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	/*************************** main function ****************************/
	// by Jackie
	public boolean isOneEditDistance2(String s, String t) {
        if(s == null || t == null){
            if(s == null && t == null){
                return false;
            } else if(s == null && t.length() == 1){
                return true;
            } else if(t == null && s.length() == 1){
                return true;
            } else {
                return false;
            }
        } else if(s.equals(t)){
            return false; 
        } else if(Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        
        return strCompare(s, t);
    }
    
    public boolean strCompare(String s, String t){
        int len = Math.min(s.length(), t.length());
        String str1 = "";
        String str2 = "";
        
        for(int i = 0; i < len; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    str1 = s.substring(i + 1);
                    str2 = t.substring(i + 1);
                } else if(s.length() > t.length()){
                    str1 = s.substring(i + 1);
                    str2 = t.substring(i);
                } else {
                    str1 = s.substring(i);
                    str2 = t.substring(i + 1);
                }

                return str1.equals(str2);
            }
        }
        
        return true;
    }
	
	
	
    /*******************************************************/
    // by other
	public boolean isOneEditDistance3(String s, String t) {
        if(s == null){
            if(t == null || t.length() == 1){
                return true;
            } else {
                return false;
            }
        }
        if(t == null){
            if(s == null || s.length() == 1){
                return true;
            } else {
                return false;
            }
        }
        if(Math.abs(s.length() - t.length()) > 1){
            return false;
        }
        
        int len1 = s.length(), len2 = t.length();
        if(len1 == len2){
            return oneModify(s, t);
        } else if(len1 > len2){
            return oneDel(s, t);
        } else {
            return oneDel(t, s);
        }
    }
    
    public boolean oneModify(String s, String t){
        int n = s.length();
        int diff = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
    
    public boolean oneDel(String s, String t){
        for(int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++){
            if(s.charAt(i) != t.charAt(j)){
                return s.substring(i + 1).equals(t.substring(j));
            }
        }
        return true;
    }
}
