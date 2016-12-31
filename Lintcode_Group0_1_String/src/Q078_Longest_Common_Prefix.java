
public class Q078_Longest_Common_Prefix {
	// by Jackie
	public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return new String();
        } else if(strs.length == 1){
            return strs[0];
        }

        int len = strs.length;
        String str = strs[0];
        
        for(int i = 1; i < len; ++i){
            str = helper(str, strs[i]);
            if(str.length() == 0){
                break;
            }
        }
        
        return str;
    }
    
    public String helper(String str1, String str2){
        StringBuffer tempStr = new StringBuffer();
        int len = Math.min(str1.length(), str2.length());
        
        for(int i = 0; i < len; ++i){
            if(str1.charAt(i) == str2.charAt(i)){
                tempStr.append(str1.charAt(i));
            } else{
                break;
            }
        }
        
        return tempStr.toString();
    }
}
