
public class Lecture5_DP_II_02_Longest_Increasing_Subsequence {
	/*************************************************************************************
	 * 坐标型动态规划
	 * 		state:     f[i] 表示跳到i位置时，最长的LIS的长度;
	 * 		function:  f[i] = Math.max(f[i], (f[j]+1 && (j < i && nums[j] < nums[i])));
	 * 		initial:   f[i] = 1, 其中i < nums.length, 即所有点都有可能是起点;
	 * 		answer:    Math.max(f[i]), 其中 i < nums.length;
	 * 		错误：      不可以用f[i]表示前i个位置，能得到的lis的长度是什么;
	 * 
	 *************************************************************************************/

	public int longestIncreasingSubsequence(int[] nums) {
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
}
