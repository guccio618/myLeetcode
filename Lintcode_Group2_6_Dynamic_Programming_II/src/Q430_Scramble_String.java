
public class Q430_Scramble_String {
	public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null){
            if(s1 == null && s2 == null){
                return true;
            } else {
                return false;
            }
        } else if(s1.length() != s2.length()){
            return false;
        }
        int n = s1.length();
        
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j)); 
            }
        }
        
        for(int length = 2; length <= n; ++length){
            for(int x = 0; x + length - 1 < n; ++x){
                for(int y = 0; y + length - 1 < n; ++y){
                    for(int i = 1; i < length; ++i){
                        dp[x][y][length] |= (dp[x][y][i] && dp[x + i][y + i][length - i]) || (dp[x][y + length - i][i] && dp[x + i][y][length - i]);
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }
}
