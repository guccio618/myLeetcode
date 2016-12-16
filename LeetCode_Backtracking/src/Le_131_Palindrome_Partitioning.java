import java.util.ArrayList;
import java.util.List;


public class Le_131_Palindrome_Partitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return ans;
        }
        
        List<String> list = new ArrayList<String>();
        backtrack(ans, list, s, 0);
        
        System.out.println("1");
        return ans;
    }
    
    public void backtrack(List<List<String>> ans, List<String> list, String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<String>(list));
            return;
        } 
        
        for(int i = start + 1; i <= s.length(); i++){
        	String newStr = s.substring(start, i);
        	if(!isPalindrome(newStr)){
        		continue;
        	}
        	list.add(newStr);
            backtrack(ans, list, s, i);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPalindrome(String str){
        if(str.length() == 1){
            return true;
        }
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
    
    
    
    
    
//    public List<List<String>> partition(String s) {
//    	List<List<String>> result = new ArrayList<List<String>>();
//        if (s == null) {
//            return result;
//        }
//
//        ArrayList<String> path = new ArrayList<String>();
//        helper(s, path, 0, result);
//
//        return result;
//    }
//
//    private boolean isPalindrome(String s) {
//        int beg = 0;
//        int end = s.length() - 1;
//        while (beg < end) {
//            if (s.charAt(beg) != s.charAt(end)) {
//                return false;
//            }
//
//            beg++;
//            end--;
//        }
//
//        return true;
//    }
//
//    private void helper(String s, ArrayList<String> path, int pos, List<List<String>> result) {
//        if (pos == s.length()) {
//            result.add(new ArrayList<String>(path));
//            return;
//        }
//
//        for (int i = pos + 1; i <= s.length(); i++) {
//            String prefix = s.substring(pos, i);
//            if (!isPalindrome(prefix)) {
//                continue;
//            }
//
//            path.add(prefix);
//            helper(s, path, i, result);
//            path.remove(path.size() - 1);
//        }
//    }
    
    
    public static void main(String[] args){
    	Le_131_Palindrome_Partitioning t = new Le_131_Palindrome_Partitioning();
    	String s = "bb";
    	List<List<String>> res = t.partition(s);
    	
    	for(int i = 0; i < res.size(); i++){
    		for(int j = 0; j < res.get(i).size(); j++){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
