
public class Li_191_Maximum_Product_Subarray {
	/************************************************************************
	 * (1). 此题为求数组中的某一段最大乘积的子数组，运用DP，dp[i]为当前最大／最小值。
	 * (2). 因为nums[i]可正可负，因此需要分两种情况，应用两个dp数组，max[i]和min[i]
	 * 		存放当前最大／最小值，根据nums[i]正负值来确定应该乘哪个数组。
	 * (3). 由于求的是某一段子数组，不确定结束位置，而dp数组记录的是到当前位置的最小／最大值，
	 * 		因此此题是局部最优和全局最优的题目，用ans记录最终答案。
	 * (4). 此题可使用空间优化。
	 *  
	 ************************************************************************/
	// 未使用空间优化, space O(n)
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
    
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        int ans = nums[0];
        
        for(int i = 1; i < n; ++i){
            if(nums[i] > 0){
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            ans = Math.max(ans, max[i]);
        }
        
        return ans;
    }
	
	
	// 使用空间优化， space O(1)
	public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
    
        int n = nums.length;
        int preMax = nums[0];
        int curMax = nums[0];
        int preMin = nums[0];
        int curMin = nums[0];
        int ans = nums[0];
        
        for(int i = 1; i < n; ++i){
            if(nums[i] > 0){
                curMax = Math.max(nums[i], preMax * nums[i]);
                curMin = Math.min(nums[i], preMin * nums[i]);
            } else {
                curMax = Math.max(nums[i], preMin * nums[i]);
                curMin = Math.min(nums[i], preMax * nums[i]);
            }
            preMax = curMax;
            preMin = curMin;
            ans = Math.max(ans, curMax);
        }
        
        return ans;
    }
}
