/*******
 * 
Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * */

public class Le_014_Longest_Common_Prefix {
	// test case:
    // strs is empty
    // strs contains only one element
    
	// solution 1: time is O(n * len), len is the length of word
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        } else if(strs.length == 1) {
            return strs[0];
        }
        
        String str1 = strs[0];
        
        for(int i = 1; i < strs.length && str1.length() > 0; i++) {
            int len = Math.min(str1.length(), strs[i].length());
            int j = 0;
            
            while(j < len) {
                if(str1.charAt(j) != strs[i].charAt(j)) {
                    break;
                } else {
                    j++;
                }
            }
            
            str1 = str1.substring(0, j);
        }
        
        return str1;
    }
	
	
	
	// solution 2: using Divide and Conquer
	public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0){
            return new String();
        } else if(strs.length == 1){
            return strs[0];
        }
        
        return helper(strs, 0, strs.length - 1);
    }
    
    public String helper(String[] strs, int start, int end){
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
	
    
    
    
    
    
    
    
    
    
    
    
    
    /************************* main function ******************************/
    
    public static void main(String[] args){
    	Le_014_Longest_Common_Prefix l = new Le_014_Longest_Common_Prefix();
    	String[] array = {"a"};
    	System.out.println(l.longestCommonPrefix(array));
    }
}
