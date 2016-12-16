
public class Q014_Longest_Common_Prefix {
	/*******************************************************/
	// by Jackie
	public String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0){
	        return new String();
	    }
	    
	    return helper(strs, 0, strs.length - 1);   
	} 

	public String helper(String[] strs, int start, int end){
	    if(start > end){
	        return new String();
	    } else if(start == end){
	        return strs[start];
	    }
	    
	    int mid = start + (end - start)/2;
	    String left = helper(strs, start, mid);
	    String right = helper(strs, mid + 1, end);
	    
	    if(left.equals("") || right.equals("")){
	        return new String();
	    }
	    
	    int len = Math.min(left.length(), right.length());
	    int index = 0;
	    
	    while(index < len){
	        if(left.charAt(index) != right.charAt(index)){
	            break;
	        }
	        
	        index++;
	    }
	    
	    return left.substring(0, index);
	}
	
	
	
	/*******************************************************/
	// by Jackie using Divide and Conquer
	public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0){
            return new String();
        } else if(strs.length == 1){
            return strs[0];
        }
        
        return helper2(strs, 0, strs.length - 1);
    }
    
    public String helper2(String[] strs, int start, int end){
        if(start > end){
            return null;
        } else if(start == end){
            return strs[start];
        }
        
        int mid = start + (end - start) / 2;
        String left = helper(strs, start, mid);
        String right = helper(strs, mid + 1, end);
        
        if(left == null){
            return right;
        } else if(right == null){
            return left;
        } else {
            int len = Math.min(left.length(), right.length());
            int index = 0;
            
            while(index < len){
                if(left.charAt(index) != right.charAt(index)){
                    break;
                }
                index++;
            }
            
            return left.substring(0, index);
        }
    }
	
    
    
    /*******************************************************/
    // by other
	public String longestCommonPrefix3(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String temp_str = strs[0], res = "";
        int count = 0;
        
        for(int i = 1; i < strs.length; i++){
            count = (temp_str.length() < strs[i].length()) ? temp_str.length() : strs[i].length();
            if(count == 0) return "";
            int j = 0;
            for(; j < count; j++){
                if(temp_str.charAt(j) != strs[i].charAt(j))
                    break;
            }
            res = temp_str.substring(0, j);
            temp_str = res;
        }
        return res;
    }
    
    public static void main(String[] args){
    	Q014_Longest_Common_Prefix l = new Q014_Longest_Common_Prefix();
    	String[] array = {"a"};
    	System.out.println(l.longestCommonPrefix(array));
    }
}
