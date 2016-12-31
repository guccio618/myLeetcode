
public class Lecture5_DP_II_06_Edit_Distance {
	/******************************************************************************************************************************************
	 * 双序列动态规划
	 * 		state:     f[i][j] 表示str1的前i个字符至少要经过几次编辑可以变成str2的前j个字符;
	 * 		function:  f[i][j] = MAX(f[i-1][j]＋1, f[i][j-1]+1, f[i-1][j-1])        // a[i] == b[j]时;
	 * 				        或 =  MAX(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1)      // a[i] != b[j]时;
	 * 				   分析：根据要求只能修改str1, 使之成为str2 
	 * 						当str1[i] != str2[j]时，方案有:
	 * 							(1). str1[i]可以replace为str2[j], 此时str1[i]＝＝str2[j]因此不考虑，只考虑str1[i-1]和str2[j-1]的情况，即f[i-1][j-1]+1;
	 * 							(2). 在str1后insert str2[j], 此时str1[i+1]＝＝str2[j]因此不考虑，只考虑str1[i]和str2[j-1]的情况,即f[i][j-1]+1;
	 * 							(3). 直接删除str1[i], 此时只考虑str1[i-1]和str2[j]的情况,即f[i-1][j]+1;
	 * 						当str1[i] == str2[j]时， 方案有：
	 * 							(1). 从str1删除str1[i]，str1[i]不列入考虑，即f[i-1][j]+1;
	 * 							(2). 往str1里插入str2[j]，此时str1[i+1] == str2[j]不考虑，只考虑str1[i]和str2[j-1]的情况,即f[i][j-1]+1;
	 * 							(3). str1[i]和str2[j]都保留，因为他们相等，所以只考虑str1[i-1]和str2[j-1]的情况，即f[i-1][j-1];
	 * 		initial:   f[0][j] = j && f[i][0] = i;
	 *   	answer:    f[str1.length][str2.length];
	 *   
	 ******************************************************************************************************************************************/
	
	public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i = 0; i <= len1; ++i){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; ++j){
            dp[0][j] = j;
        }
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                	 dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }
}
