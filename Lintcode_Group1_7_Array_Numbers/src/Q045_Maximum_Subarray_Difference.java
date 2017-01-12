
public class Q045_Maximum_Subarray_Difference {
	// by Jackie using DP
	public int maxDiffSubArrays(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] leftMin = new int[len];
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];
        int[] rightMax = new int[len];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sumMax = 0, sumMin = 0;
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++){
            sumMax += nums[i];
            max = Math.max(max, sumMax);
            sumMax = Math.max(sumMax, 0);    
            leftMax[i] = max;
            
            sumMin += nums[i];
            min = Math.min(min, sumMin);
            sumMin = Math.min(sumMin, 0);
            leftMin[i] = min;
        }
        
        sumMax = sumMin = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i = len - 1; i >= 0; i--){
            sumMax += nums[i];
            max = Math.max(max, sumMax);
            sumMax = Math.max(sumMax, 0);
            rightMax[i] = max;
            
            sumMin += nums[i];
            min = Math.min(min, sumMin);
            sumMin = Math.min(sumMin, 0);
            rightMin[i] = min;
        } 
        
        for(int i = 0; i < len - 1; i++){
            res = Math.max(res, Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1])));
        }
        return res;
    }
}
