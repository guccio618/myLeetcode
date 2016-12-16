import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Le_140_Word_Break_II {
	/********************************************************/
	// by other using memorizing space O(n);
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> result = new LinkedList<String>();
		if (s == null || s.length() == 0 || wordDict.size() == 0){
			return result;
		}
		return getBreaks(s, wordDict, 0, new List[s.length()]);   //  new List[i]表示从i位置开始的str组合 
	}

	public List<String> getBreaks(String s, Set<String> wordDict, int start, List<String>[] memo) {
		List<String> result = new LinkedList<String>();
		if (start == s.length()) {            // 必需加入“”  ！！！
			result.add("");
			return result;
		}
		for (int index = start, len = s.length(); index < len; ++index) {
			String curStr = s.substring(start, index + 1);
			if (wordDict.contains(curStr)) {
				if (memo[index] == null) {
					memo[index] = getBreaks(s, wordDict, index + 1, memo);   // 需要注意的是index + 1 !!!
				}
				for (String str : memo[index]) {
					if (!str.equals(""))
						result.add(curStr + " " + str);        // 此处用的是从s的最后面开始动态规划的 ！！！
					else
						result.add(curStr);
				}
			}
		}
		return result;
	}

	/********************************************************/
	// by other using DP+DFS
	private List<String> result;

	public List<String> wordBreak2(String s, Set<String> wordDict) {
		result = new ArrayList<String>();
		int n = s.length();
		List<Integer>[] pointer = new List[n];
		for (int i = 0; i < n; i++)
			pointer[i] = new ArrayList<Integer>();
		// DP to record break point
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (wordDict.contains(s.substring(j, i + 1))
						&& (j == 0 || pointer[j - 1].size() > 0))
					pointer[i].add(j);
			}
		}
		helper(pointer, s, n - 1, "");
		return result;
	}

	// DFS to retrieve results
	public void helper(List<Integer>[] pointer, String s, int i, String pattern) {
		if (i < 0) {
			result.add(pattern);
			return;
		}
		for (Integer item : pointer[i]) {
			String nextPattern = pattern.length() == 0 ? s.substring(item,
					i + 1) : s.substring(item, i + 1) + " " + pattern;
			helper(pointer, s, item - 1, nextPattern);
		}
	}
	
	
	
	/*******************************************************************/
	// by Jackie, but exceed time limit
	public List<String> wordBreak3(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict.size() == 0){
			return new LinkedList<String>();
		}
		
		int maxLen = getLen(wordDict);
		int n = s.length();
		List<String>[] memo = new List[s.length()]; 
		
		for(int i = 0; i < n; ++i){
			memo[i] = new ArrayList<String>();
			for(int lastWordLen = 0; lastWordLen < maxLen && i - lastWordLen >= 0; ++lastWordLen){
				String newStr = s.substring(i - lastWordLen, i + 1);
				if(wordDict.contains(newStr)){
					int last = i - lastWordLen - 1;
					if(i - lastWordLen == 0){
						memo[i].add(newStr);
					} else if(memo[last] != null){
						for(String str : memo[last]){
							memo[i].add(str + " " + newStr);
						}
					}
				}
				
	        }
	    }

		return memo[n - 1];
	}
	
	public int getLen(Set<String> wordDict){
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
		List<String> res = t.wordBreak(s, wordDict);
		for (int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");

	}
}
