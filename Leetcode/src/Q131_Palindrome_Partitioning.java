import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/********
 * 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 * 
 * */



public class Q131_Palindrome_Partitioning {
	/********************************************************/
	// by Jackie using backtrack + memoSearch
	public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return ans;
        }
        
        boolean[][] canSplit = getMemo(s);
        List<String> list = new ArrayList<String>();
        
        backtrack(ans, list, s, 0, canSplit);
        return ans;
    }
    
    public void backtrack(List<List<String>> ans, List<String> list, String s, int start, boolean[][] canSplit){
        if(start == s.length()){
            ans.add(new ArrayList<String>(list));
            return;
        }
        
        int n = s.length();
        
        for(int i = start; i < n; i++){
            if(canSplit[start][i] == true){
                String newStr = s.substring(start, i + 1);
                list.add(newStr);
                backtrack(ans, list, s, i + 1, canSplit);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean[][] getMemo(String s){
        int n = s.length();
        boolean[][] canSplit = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            canSplit[i][i] = true;
        }
        
        for(int i = 0; i < n - 1; i++){
            canSplit[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        for(int length = 2; length < n; length++){
            for(int start = 0; start + length < n; start++){
                canSplit[start][start + length] = canSplit[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start+ length);
            }
        }
        
        return canSplit;
    }
	
	
    
	/********************************************************/
	// by Jackie using backtrack
	private LinkedList<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
	private Queue<Double> maxHeap = new PriorityQueue<Double>();
    
    public LinkedList<LinkedList<String>> partition2(String s) {
        if(s == null) return res;
        LinkedList<String> path = new LinkedList<String>();
        for(int i = 1, len = s.length(); i <= len; ++i)
        	backtrack(s, 0, i, path);
        return res;
    }
    
    public void backtrack(String s, int start, int end, LinkedList<String> path){
    	if(isPalindrome(s.substring(start, end)) == false) return;
        path.add(s.substring(start, end));
        if(end == s.length())
        	res.add(new LinkedList<String>(path));
        else{
            for(int i = end+1, len = s.length(); i <= len; ++i)
            	backtrack(s, end, i, path);
        }
        path.remove(path.size()-1);
    }
    
    public boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        int front = 0;
        int back = s.length()-1;
        while(front <= back){
            if(s.charAt(front++) != s.charAt(back--))
                return false;
        }
        return true;
    }
    
    public boolean isPalindrome3(String s){     // by other, but a little slow
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString().equals(s);
    }
	
	
	
	public static void main(String[] args){
		Q131_Palindrome_Partitioning t = new Q131_Palindrome_Partitioning();
		String s = "aab";
		List<List<String>> res = t.partition(s);
		
		for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}		
	}
}
