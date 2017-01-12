
public class Q076_Longest_Increasing_Subsequence {
	/**********************************************
	 * f[i]表示跳到i位置时，最长的LIS的长度
	 * f[i] = f[j]+1 || j < i && nums[j] < nums[i]
	 * 初始化: f[i] = 1, 所有点都有可能是起点;
	 * answer: 
	 * 错误： 不可以用f[i]表示前i个位置，能得到的lis的长度是什么
	 **********************************************/
	// by ninechapter
	public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int max = -1;
        int[] res = new int[len];
        res[0] = 0;
        
        for(int i = 0; i < len; ++i){
        	res[i] = 1;
        }
        
        for(int i = 1; i < len; ++i){
            for(int j = i-1; j >= 0; --j){
                if(nums[j] <= nums[i]){
                    res[i] = Math.max(res[i], res[j] + 1);
                    max = Math.max(max, res[i]);
                }
            }
        }
        return (max == -1) ? 1 : max + 1;
    }
	
	
	public static void main(String[] args){
		Q076_Longest_Increasing_Subsequence t = new Q076_Longest_Increasing_Subsequence();
		int[] nums = {10,1,11,2,12,3,11};
		System.out.println(t.longestIncreasingSubsequence(nums));
	}
}
