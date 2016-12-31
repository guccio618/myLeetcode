
public class Lecture5_DP_II_08_Interleaving_String {
	/******************************************************************************************************************
	 * 双序列动态规划
	 * 		state:      f[i][j] 表示str1的前i个字符和str2中的前j个字符是否能组成str3的前i+j个字符；
	 * 		function:   f[i][j] = (f[i-1][j] && str1[i] == str3[i+j]) || (f[i][j-1] && str2[j] == str3[i+j]);
	 * 		initial:    f[0][j] = (f[0][j-1] && str2[j] == str3[j]),  f[i][0] = (f[i-1][0] && str1[i] == str3[i]);
	 * 		answer:     f[str1.length][str2.length];
	 * 
	 ******************************************************************************************************************/
	
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }
        
        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j])) || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                interleaved[i][j] = true;
            }
        }
        
        return interleaved[s1.length()][s2.length()];
    }
}
