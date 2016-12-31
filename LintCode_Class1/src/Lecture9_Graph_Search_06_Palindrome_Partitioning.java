import java.util.ArrayList;
import java.util.List;


public class Lecture9_Graph_Search_06_Palindrome_Partitioning {
	/*****************************************************/
	// 求切割的具体方案，使用DFS，而不能用DP；
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return res;
		}
		List<String> list = new ArrayList<String>();
		helper(res, list, s, 0);
		return res;
	}
	
	public void helper(List<List<String>> res, List<String> list, String str, int pos){
		if(pos == str.length()){
			res.add(new ArrayList(list));
			return;
		}
		for(int i = pos; i < str.length(); ++i){
			if(isPalindrome(str.substring(pos, i + 1))){
				list.add(str.substring(pos, i + 1));
				helper(res, list, str, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	
	
	/*****************************************************/
	// 求最小切割，使用DP
	public int minCut(String s){       
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= len; ++i){
        	dp[i] = i;
        }
        
        for(int start = 1; start <= len; ++start){
        	for(int end = start; end <= len; ++end){
        		if(isPalindrome(s.substring(start - 1, end))){
        			dp[end] = Math.min(dp[end], dp[start - 1] + 1);
        		}
        	}
        }
        
        return dp[len];       
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
		Lecture9_Graph_Search_06_Palindrome_Partitioning t = new Lecture9_Graph_Search_06_Palindrome_Partitioning();
		System.out.println(t.minCut("abcdeffedcba"));
		List<List<String>> res_2 = t.partition("aab");
		for(int i = 0; i < res_2.size(); ++i){
			System.out.print(res_2.get(i) + ", ");
		}
		System.out.println();
	}
}
