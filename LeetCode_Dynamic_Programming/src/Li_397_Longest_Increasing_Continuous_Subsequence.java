
public class Li_397_Longest_Increasing_Continuous_Subsequence {
	/************************************************************************
	 *  此题含从左往右，以及从右往左的可能性
	 *  
	 ************************************************************************/
	
	// time complexity O(n), space O(1)
	public int longestIncreasingContinuousSubsequence(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int n = nums.length;
		int leftLen = 1, rightLen = 1;
		int ans = 1;
		
		for(int i = 0; i < n - 1; i++){
		    if(nums[i] > nums[i + 1]){
		        leftLen++;
		        rightLen = 1;
		    } else if(nums[i] < nums[i + 1]){
		        rightLen++;
		        leftLen = 1;
		    } else {
		        leftLen = rightLen = 1;
		    }
		    
		    ans = Math.max(ans, Math.max(leftLen, rightLen));
		}
		
		return ans;
    }
}
