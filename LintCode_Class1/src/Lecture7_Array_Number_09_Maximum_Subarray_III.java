
public class Lecture7_Array_Number_09_Maximum_Subarray_III {
	public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
		
        int len = nums.length;
        int[][] f = new int[k+1][len];
        for (int i = 1; i < k+1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            f[i][i-1] = sum;
        }
        for (int i = 1; i < len; i++) {
        	f[1][i] = Math.max(f[1][i-1] + nums[i], nums[i]);
        }
        
        for (int i = 2; i < k+1; i++) {
            for (int n = i;  n< len; n++) {
                int curMax = f[i][n-1] + nums[n];
                for (int j = i-2; j < n; j++) {
                    if ((f[i-1][j] + nums[n]) > curMax) {
                        curMax = f[i-1][j] + nums[n];
                    }
                }
                f[i][n] = curMax;
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = k-1; i < len; i++){
            if (f[k][i] > res) {
                res = f[k][i];
            }
        }
        return res;
    }
}
