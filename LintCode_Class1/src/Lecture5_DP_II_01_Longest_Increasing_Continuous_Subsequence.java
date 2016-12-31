
public class Lecture5_DP_II_01_Longest_Increasing_Continuous_Subsequence {
	/***************************************************************************************
	 * 坐标型动态规划
	 * 		state:     f1[i] 表示跳到i位置时，最长的升序LICS的长度;
	 * 				   f2[i] 表示跳到i位置时，最长的降序LICS的长度;
	 * 		function:  f1[i] = f1[i-1] + 1    // nums[i] > nums[i-1];
	 * 						 = 1              // nums[i] <= nums[i-1];
	 * 				   f2[i] = f2[i-1] + 1    // nums[i] < nums[i-1];
	 * 						 = 1              // nums[i] >= nums[i-1];
	 * 		initial:   f1[0] = 1 && f2[0] = 1;
	 * 		answer:    Math.max(f1[i], f2[i]), 其中 i < nums.length, 即f1[i]和f2[i]中的最大值;
	 * 
	 ***************************************************************************************/
	
	// time complexity is O(n), space is O(n)
	public int longestIncreasingContinuousSubsequence(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int len = nums.length;
		int maxLen = 1;
		int[] f1 = new int[len];
		int[] f2 = new int[len];
		f1[0] = 1;
		f2[0] = 1;
		
		for(int i = 1; i < len; ++i){
			if(nums[i] > nums[i-1]){
				f1[i] = f1[i-1] + 1;
			}
			else{
				f1[i] = 1;
			}

			if(nums[i] < nums[i-1]){
				f2[i] = f2[i-1] + 1;
			}
			else{
				f2[i] = 1;
			}
			maxLen = Math.max(maxLen, Math.max(f1[i], f2[i]));
		}
		return maxLen;
	}
	
	
	
	// time complexity is O(n), space is O(1)
	public int longestIncreasingContinuousSubsequence2(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
			return 0;
		}
		
		int len = nums.length;
		int maxLen = 1;
		int len1 = 1;
		int len2 = 1;
		
		for(int i = 1; i < len; ++i){
			if(nums[i] > nums[i-1]){
				len1 += 1;
			}
			else{
				len1 = 1;
			}

			if(nums[i] < nums[i-1]){
				len2 += 1;
			}
			else{
				len2 = 1;
			}
			maxLen = Math.max(maxLen, Math.max(len1, len2));
		}
		return maxLen;
    }
}
