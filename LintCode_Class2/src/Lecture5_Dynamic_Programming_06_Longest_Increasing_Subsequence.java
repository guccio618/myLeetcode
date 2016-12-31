
public class Lecture5_Dynamic_Programming_06_Longest_Increasing_Subsequence {
	public int longestIncreasingContinuousSubsequence(int[] nums) {
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
