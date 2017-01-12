import java.util.ArrayList;


public class Q044_Minimum_Subarray {
	// by Jackie using DP
	public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int len = nums.size();
        int[] f = new int[len];
        f[0] = nums.get(0);
        int min = f[0];
        
        for(int i = 1; i < len; ++i){
            int num = nums.get(i);
            f[i] = (f[i-1] > 0) ? num : f[i-1] + num;
            min = Math.min(min, f[i]);
        }
        return min;
    }
}
