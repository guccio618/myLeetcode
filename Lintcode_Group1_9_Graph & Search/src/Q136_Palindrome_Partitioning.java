import java.util.ArrayList;
import java.util.List;


public class Q136_Palindrome_Partitioning {
	// by Jackie
	public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return res;
        }
        
        List<String> list = new ArrayList<String>();
        helper(res, list, 0, s);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> list, int pos, String s){
        if(pos == s.length()){
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i = pos + 1; i <= s.length(); ++i){
            String subStr = s.substring(pos, i);
            if(isPalindrome(subStr)){
                list.add(subStr);
                helper(res, list, i, s);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    
    
    public static void main(String[] args){
    	Q136_Palindrome_Partitioning t = new Q136_Palindrome_Partitioning();
    	String s = "ab";
    	List<List<String>> res = t.partition(s);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    	}
    }
}
