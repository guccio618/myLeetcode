public class Le_003_Longest_Substring_Without_Repeating_Characters {
	/*******************************************************/
	// faster, time complexity O(n), space O(1)
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int[] hash = new int[256];
		int faster = 0;
		int ans = 1;
		char[] letters = s.toCharArray();

		for (int slower = 0; slower < n; ++slower) {
			while (faster < n && hash[letters[faster]] == 0) {
				hash[letters[faster]] = 1;
				ans = Math.max(ans, faster - slower + 1);
				faster++;
			}
			hash[letters[slower]] = 0;
		}

		return ans;
	}

	/*******************************************************/
	// time complexity O(n), space O(1)
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int[] hash = new int[256];
		int faster = 0;
		int ans = 1;

		for (int slower = 0; slower < n; ++slower) {
			while (faster < n && isValid(hash)) {
				hash[s.charAt(faster)]++;
				faster++;
			}
			if (!isValid(hash)) {
				ans = Math.max(ans, faster - slower - 1);
			} else {
				ans = Math.max(ans, faster - slower);
			}
			hash[s.charAt(slower)]--;
		}

		return ans;
	}

	public boolean isValid(int[] hash) {
		for (int i = 0; i < 256; ++i) {
			if (hash[i] > 1) {
				return false;
			}
		}
		return true;
	}
}
