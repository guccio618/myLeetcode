import java.util.Arrays;


public class Q192_Wildcard_Matching {
	// by other using DP
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] matrix = new boolean[m + 1][n + 1]; // 表示s中的0~i可以匹配p中的0~j

		// s="" p="" is true
		matrix[0][0] = true;

		// Handle cases like s="" p="****"
		for (int i = 1; i <= n; i++) {
			if (p.charAt(i - 1) == '*'){
				matrix[0][i] = true;
			}
			else{
				break;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c = p.charAt(j - 1);
				if (c != '*'){
					matrix[i][j] = matrix[i - 1][j - 1] && (s.charAt(i - 1) == c || c == '?');
				}
				else {
					// matrix[i][j-1] => * is empty
					// matrix[i-1][j] => match sequence of characters
					matrix[i][j] = matrix[i][j - 1] || matrix[i - 1][j];
				}
			}
		}
		return matrix[m][n];
	}
	
	// by other using DP
	public boolean isMatch2(String s, String p) {
        boolean[] prev = new boolean[s.length()+1];
        boolean[] curr = new boolean[s.length()+1];
        // base case: empty pattern matches empty string
        prev[0] = true;
        for(int i=1; i <= p.length(); i++){
            // base case: pattern with single character does not match an empty string
            if(p.charAt(i-1) == '*')
                curr[0] = prev[0];
            else
                curr[0] = false;
            for(int j=1; j <= s.length(); j++){
                // match zero, one or more times
                if(p.charAt(i-1) == '*'){
                    curr[j] = prev[j-1] || prev[j] || curr[j-1];
                }
                //current character matches 
                else if(p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                //current character does not match
                else{
                    curr[j] = false;
                }
            }
            prev= Arrays.copyOf(curr,curr.length);
        }
        return prev[s.length()];
     }
}
