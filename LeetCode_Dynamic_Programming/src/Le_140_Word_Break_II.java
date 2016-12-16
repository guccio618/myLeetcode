import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/******
 * 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 * 
 * */


public class Le_140_Word_Break_II {
	/********************************************************************************************************
	 * 此题目不同于题139, 139是通过遍历当前结点之前的结点状态来获取当前结点的状态，时间复杂度O(n * m)，m为wordDict中最长的单词长度。
	 * 本题从后向前递推，用memo记录已经遍历过的答案，减少重复计算。
	 * memo[i]记录从 i+1 到 s.length()-1 可以分解的可行解。
	 * memo[s.length()] 初始化为: ""。
	 * 自底向上，用memoSearch记录已经求过的答案，减少重复计算
	 * 
	 ********************************************************************************************************/
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0){
            return new LinkedList<String>();
        }
        List<String>[] memo = new List[s.length()];
        return helper(s, 0, wordDict, memo);
    }
    
    public List<String> helper(String s, int start, Set<String> wordDict, List<String>[] memo){
        List<String> ans = new LinkedList<String>();  // 每次递归都开辟新的list
        
        if(start == s.length()){
            ans.add("");        // 这里必须要，因为此解法是从后往前递推的，即从start = s.length()开始，相当于dp[0]的初始化
            return ans;
        }
        
        int n = s.length();
        
        for(int index = start; index < n; ++index){
            String nextWord = s.substring(start, index + 1);
            if(wordDict.contains(nextWord)){
                if(memo[index] == null){     // 这里memo用index，防止index = s.length() 越界
                    memo[index] = helper(s, index + 1, wordDict, memo);  // 从 i+1 开始
                } 
                
                for(String str : memo[index]){
                    if(str == ""){
                        ans.add(nextWord);
                    } else {
                        ans.add(nextWord + " " + str);
                    }
                }
            }
        }
        
        return ans;
    }
    
    
    
    /*******************************************************************/
	// by Jackie, but exceed time limit, O(n * m)
	public List<String> wordBreak3(String s, Set<String> wordDict) {		
		if(s == null || s.length() == 0){
            return new LinkedList<String>();
        }
        
        int maxLen = getMaxLen(wordDict);
        int n = s.length();
        boolean[] canSplit = new boolean[n + 1];
        List<String>[] memo = new List[n + 1];
        memo[0] = new ArrayList<String>();
        memo[0].add("");
        canSplit[0] = true;
        
        for(int i = 1; i <= n; ++i){
        	memo[i] = new ArrayList<String>();
        	
            for(int lastWordLen = 1; lastWordLen <= maxLen && i - lastWordLen >= 0; ++lastWordLen){
                if(canSplit[i - lastWordLen] == true){
                    String lastWord = s.substring(i - lastWordLen, i);
                    
                    if(wordDict.contains(lastWord)){
                        canSplit[i] = true;                       
                        
                        for(String str : memo[i - lastWordLen]){
                        	if(str == ""){
                        		memo[i].add(lastWord);
                        	} else {
                        		memo[i].add(str + " " + lastWord);
                        	}
                        }
                    }
                }
            }
        }
        
        return memo[n];
	}
	
	public int getMaxLen(Set<String> wordDict){
		int maxLen = 0;
		
		for(String str : wordDict){
			maxLen = Math.max(maxLen, str.length());
		}
		
		return maxLen;
	}
	
	
	
	
	
	/*************************** main function *****************************/
	public static void main(String[] args) {
		Le_140_Word_Break_II t = new Le_140_Word_Break_II();
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> res = t.wordBreak3(s, wordDict);
		for (int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");

	}
}
