
public class Q043_Maximum_Subarray_III {
	public int maxSubArray(int[] nums, int k) {
        if (nums.length < k){
			return 0;
		}
		int len = nums.length;

		// d[i][j]: select j subarrays from the first i elements, the max sum we can get.
		int[][] d = new int[len + 1][k + 1];
		for (int i = 0; i <= len; i++){
			d[i][0] = 0;
		}

		for (int j = 1; j <= k; j++){
			for (int i = j; i <= len; i++) {
			    // Initial value of endMax and max should be taken care very very carefully.
				d[i][j] = Integer.MIN_VALUE;
				int sum = 0;
				int max = Integer.MIN_VALUE;
				for (int p = i - 1; p >= j - 1; p--) {  // 从i = 0, j = 0开始，即左到右；区间划分：0 ~ p-1, p ~ i
				    sum += nums[p];
				    max = Math.max(max, sum);
				    sum = Math.max(sum, 0);
					if(d[i][j] < d[p][j - 1] + max){
						d[i][j] = d[p][j - 1] + max;
					}
				}
			}
		}

		return d[len][k];
    }

	
	
	/*************************************************************/
	// by ninechapter
	public int maxSubArray2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int[][] f = new int[k + 1][len];
		for (int i = 1; i < k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += nums[j];
			}
			f[i][i - 1] = sum;
		}

		for (int i = 1; i < len; i++) {
			f[1][i] = Math.max(f[1][i - 1] + nums[i], nums[i]);
		}

		for (int i = 2; i < k + 1; i++) {
			for (int n = i; n < len; n++) {
				int curMax = f[i][n - 1] + nums[n];
				for (int j = i - 2; j < n; j++) {
					if ((f[i - 1][j] + nums[n]) > curMax) {
						curMax = f[i - 1][j] + nums[n];
					}
				}
				f[i][n] = curMax;
			}
		}

		int res = Integer.MIN_VALUE;
		for (int i = k - 1; i < len; i++) {
			if (f[k][i] > res) {
				res = f[k][i];
			}
		}
		return res;
	}
}
