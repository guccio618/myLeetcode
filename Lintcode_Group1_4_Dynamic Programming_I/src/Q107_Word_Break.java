import java.util.Set;

public class Q107_Word_Break {
	/*************************************************************
	 * state:     f[i]表示前i个字符是否可以分割
	 * function:  f[i] = f[j] && str.substring(j+1,i) is at dict
	 * initial:   f[0] = true
	 * answer:    f[n]
	 *************************************************************/
	// by ninechapter
	private int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int maxLength = getMaxLength(dict);
		boolean[] canSegment = new boolean[s.length() + 1];

		canSegment[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			canSegment[i] = false;
			for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
				if (!canSegment[i - lastWordLength]) {
					continue;
				}
				String word = s.substring(i - lastWordLength, i);
				if (dict.contains(word)) {    // O(L), L为单词长度
					canSegment[i] = true;
					break;
				}
			}
		}

		return canSegment[s.length()];
	}
}
