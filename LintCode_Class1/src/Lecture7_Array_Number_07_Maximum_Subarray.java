
public class Lecture7_Array_Number_07_Maximum_Subarray {
	/************************************************************************
	 * Greedy
	 * 	subarray之类的问题注意使用 sum[i to j] = sum[j] - sum[i-1]
	 * 
	 ************************************************************************/
	
	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);   
        }

        return max;
    }
	
		
	
	/************************************************************************
	 * 坐标型动态规划
	 * 		state:     f[i]表示以第i个点结束的subarray，最大和是多少
	 * 		function:  f[i] = preSum(i) = min{prefixSum(0,1,...i-1)}
	 * 				   max(f[i]);
	 * 
	 ************************************************************************/
	
	public int maxSubArray2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);  //类似股票买卖问题高买低卖
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
