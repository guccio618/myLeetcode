
public class Q191_Maximum_Product_Subarray {
	/****************************************************/
	// by ninechapter using DP, O(n), space O(n)
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] max = new int[len];
		int[] min = new int[len];
		int result = nums[0];
		max[0] = min[0] = nums[0];

		for (int i = 1; i < len; ++i) {
			min[i] = max[i] = nums[i];
			if (nums[i] > 0) {
				max[i] = Math.max(max[i], max[i - 1] * nums[i]);
				min[i] = Math.min(min[i], min[i - 1] * nums[i]);
			} else if (nums[i] < 0) {
				max[i] = Math.max(max[i], min[i - 1] * nums[i]);
				min[i] = Math.min(min[i], max[i - 1] * nums[i]);
			}
			// nums[i] == 0 时，max[i] = mim[i] = 0
			result = Math.max(result, max[i]);
		}

		return result;
	}
	 
	
	/****************************************************/
	// by Jackie but Memory Limit Exceed, using DP, O(n^2), space O(n^2)
	public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; ++i){
        	dp[i][i] = nums[i];
        	max = Math.max(max, dp[i][i]);
        }
        
        for(int i = 0; i < len; ++i){
        	for(int j = i + 1; j < len; ++j){
        		dp[i][j] = dp[i][j - 1] * nums[j];
        		if(dp[i][j] == 0){
        			break;
        		}
        		max = Math.max(max, dp[i][j]);
        	}
        }
        
        return max;
    }
	
	
	public void print(int[] array){
		for(int i = 0; i < array.length; ++i){
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		Q191_Maximum_Product_Subarray t = new Q191_Maximum_Product_Subarray();
		int[] nums = {1,0,-1,0,2,3,0,-5,0,-2};
		int[] nums2 = {-4, -3, -2};
		System.out.println(t.maxProduct(nums));
	}
}
