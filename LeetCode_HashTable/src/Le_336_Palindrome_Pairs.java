import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/******
 * 
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
	Given words = ["bat", "tab", "cat"]
	Return [[0, 1], [1, 0]]
	The palindromes are ["battab", "tabbat"]
	
Example 2:
	Given words = ["abcd", "dcba", "lls", "s", "sssll"]
	Return [[0, 1], [1, 0], [3, 2], [2, 4]]
	The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 * 
 * */

public class Le_336_Palindrome_Pairs {
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(words == null || words.length == 0){
            return ans;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = words.length;
        
        for(int i = 0; i < len; i++){
            map.put(words[i], i);
        }
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= words[i].length(); j++){   // 有等于号 ！！！
                String part1 = words[i].substring(0, j);
                String part2 = words[i].substring(j);
                
                if(isPalindrome(part1)){
                    String part2_reverse = new StringBuffer(part2).reverse().toString();
                    
                    if(map.containsKey(part2_reverse) && map.get(part2_reverse) != i){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(part2_reverse));
                        list.add(i);
                        ans.add(list);
                    }
                }
                
                if(isPalindrome(part2) && part2.length() != 0){  // 必须有 str2.length() != 0, 防止test case ["abcd","dcba"]被重复计算2次 ！！！
                    String part1_reverse = new StringBuffer(part1).reverse().toString();
                    
                    if(map.containsKey(part1_reverse) && map.get(part1_reverse) != i){  
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(part1_reverse));
                        ans.add(list);
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean isPalindrome(String str){
        if(str == null || str.length() <= 1){
            return true;
        }
        
        int left = 0, right = str.length() - 1;
        
        while(left < right){
            char c1 = str.charAt(left);
            char c2 = str.charAt(right);
            
            if(c1 != c2){
                return false;
            } else {
            	left++;
                right--;
            }
        }
        
        return true;
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	/******************************************/
	// by other
	public List<List<Integer>> palindromePairs2(String[] words) {
		List<List<Integer>> ans = new LinkedList<>();
	    if (words == null) {
	    	return ans;
	    }
	    
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    
	    for (int i = 0; i < words.length; ++ i) {
	    	map.put(words[i], i);
	    }
	    
	    for (int i = 0; i < words.length; ++ i) {
	        int left = 0, right = 0;
	        while (left <= right) {
	            String s = words[i].substring(left, right);
	            Integer j = map.get(new StringBuilder(s).reverse().toString());	            
	            
	            if (j != null && i != j){
	                String str = (left == 0) ? words[i].substring(right, words[i].length()) : words[i].substring(0, left);
	                if(isPalindrome2(str) == 1){
	                    ans.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
	                }
	            }
	            
	            if (right < words[i].length()){
	            	++right;
	            } else {
	            	++left;
	            }
	        }
	    }
	    
	    return ans;
	}
	
	public int isPalindrome2(String str){
        int n = str.length();
        int left = 0, right = n - 1;
        
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            } else {
                return 0;
            }
        }
        
        return 1;
    }
		
	
	
	/******************************************/
	// by Jackie but exceed time limited
	public List<List<Integer>> palindromePairs3(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0){
            return ans;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = words.length;
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
            	if(i == j){
            		continue;
            	}
            	
                String newStr = words[i] + words[j];
                int validFlag = 0;
                
                if(map.containsKey(newStr)){
                	validFlag = map.get(newStr);
                } else {
                	validFlag = isPalindrome2(newStr);
                    map.put(newStr, validFlag);                   
                }
                
                if(validFlag == 1){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
    
    
    
    public static void main(String[] args){
    	Le_336_Palindrome_Pairs t = new Le_336_Palindrome_Pairs();
    	String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
    	List<List<Integer>> ans = t.palindromePairs2(words);
    	
    	for(int i = 0; i < ans.size(); ++i){
    		for(int j = 0; j < ans.get(i).size(); ++j){
    			System.out.print(ans.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    	
//    	System.out.println(t.isPalindrome("abbca"));
    }
}
