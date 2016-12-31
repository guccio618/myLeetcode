import java.util.HashSet;
import java.util.Set;


public class Lecture5_DP_II_04_Word_Break {
	/*********************************************************************************
	 * 序列型动态规划, 时间复杂度为 O(N*L^2)，其中L为word长度;
	 * 		state:     f[i]表示前i个字符是否可以分割;
	 * 		function:  f[i] = f[j] && str.substring(j+1,i) is at dictionary 且 j < i;
	 * 				   lastWordLenght = i - j - 1;
	 * 		initial:   f[0] = true;
	 * 		answer:    f[n];
	 * 
	 *********************************************************************************/

	private static int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int maxLength = getMaxLength(dict);
		boolean[] canSegment = new boolean[s.length() + 1];

		canSegment[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			canSegment[i] = false;
			// lastWordLength表示以i为终点的最后一个单词长度
			for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
				if (!canSegment[i - lastWordLength]) {
					continue;
				}
				String word = s.substring(i - lastWordLength, i);
				if (dict.contains(word)) {      // O(L), L为单词长度
					canSegment[i] = true;
					break;                      // 找到一个，即可退出
				}
			}
		}

		return canSegment[s.length()];
	}
	
	
	
	/************************************* main function ****************************************/
	public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("b");
		System.out.println(Lecture5_DP_II_04_Word_Break.wordBreak("aaab", dict));
	}
}
