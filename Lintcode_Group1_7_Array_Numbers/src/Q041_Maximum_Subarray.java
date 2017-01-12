
public class Q041_Maximum_Subarray {
	/*********************************************/
	// by ninechapter using Greedy， O(n)
	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);   // 如果前面的和为0，则从此处开始
        }

        return max;
    }
	
	
	/*********************************************/
	// by ninechapter using dp， O(n)
	public int maxSubArray2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
	
	
	/*********************************************/
	// by Jackie， O(n^2)
	public int maxSubArray3(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int start = 0, len = nums.length; start < len; ++start){
            int sum = 0;
            for(int end = start; end < len; ++end){
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
