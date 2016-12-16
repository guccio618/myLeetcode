import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Le_336_Palindrome_Pairs {
	public List<List<Integer>> palindromePairs(String[] words) {
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
	            Integer j = map.get(new StringBuilder(s).reverse().toString());	          // 下面要做是否为null的判断，因此这里的j需要定义为Integer而不是int ！！！ 
	            
	            if (j != null && i != j){
	                String str = (left == 0) ? words[i].substring(right, words[i].length()) : words[i].substring(0, left);
	                if(isPalindrome(str) == 1){
	                    ans.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
	                }
	            }
	            
	            if (right < words[i].length()){                       // right对比的是word[i]的length，而不是len ！！！
	            	++right;
	            } else {
	            	++left;
	            }
	        }
	    }
	    
	    return ans;
	}
	
	public int isPalindrome(String str){
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
}
