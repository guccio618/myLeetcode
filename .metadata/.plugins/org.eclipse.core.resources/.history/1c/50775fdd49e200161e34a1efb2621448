
public class Q005_Longest_Palindromic_Substring {
	/******************************************************************
	Given a string S, find the longest palindromic substring in S. 
	You may assume that the maximum length of S is 1000, 
	and there exists one unique longest palindromic substring.
	
	******************************************************************/
	
	//by other using string operation, faster !!!
	private int maxLen = 0;
	private int startIndex = 0;

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		int len = s.length();

		for (int i = 0; i < len - 1; i++) {
			getPalindromic(s, i, i);
			getPalindromic(s, i, i + 1);
		}

		return s.substring(startIndex, startIndex + maxLen);
	}

	public void getPalindromic(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}

		if (maxLen < end - start - 1) {
			maxLen = end - start - 1;
			startIndex = start + 1;
		}
	}
	
	
	
	//by Jackie using DP
	public String longestPalindrome2(String s) {
		if(s == null || s.length() <= 1){
            return s;
        }
        
        char[] array = s.toCharArray();
        int maxLen = 1;
        int pos = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        
        for(int i = 1; i < len; ++i){
            dp[i - 1][i] = (array[i - 1] == array[i]);
            if(dp[i - 1][i] == true){
                maxLen = 2;
                pos = i - 1;
            }
        }
        
        for(int length = 2; length < len; ++length){
            for(int start = 0; start + length < len; ++start){
                dp[start][start + length] = dp[start + 1][start + length - 1] && ( array[start] == array[start + length] );
                if(dp[start][start + length] == true && maxLen <= length + 1){
                    maxLen = length + 1;
                    pos = start;
                }
            }
        }
        
        return s.substring(pos, pos + maxLen);
    }
	
	
	
	
	public static void main(String[] args){
		Q005_Longest_Palindromic_Substring test = new Q005_Longest_Palindromic_Substring();
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(test.longestPalindrome(s));
	}
}
