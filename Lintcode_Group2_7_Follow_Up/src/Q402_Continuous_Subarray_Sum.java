import java.util.ArrayList;


public class Q402_Continuous_Subarray_Sum {
	// by Jackie
	public ArrayList<Integer> continuousSubarraySum(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        } else if(nums.length == 1){
            ans.add(0);
            ans.add(0);
            return ans;
        }
        
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int localStart = 0, localEnd = 0;
        int globalStart = 0, globalEnd = 0;
        
        for(int i = 0; i < n; ++i){
            sum += nums[i];
            
            if(max < sum){
                max = sum;
                localEnd = i;
                globalStart = localStart;
                globalEnd = localEnd;
            }
            
            if(sum <= 0 && i < n - 1){
                sum = 0;
                localStart = i + 1;
            }
        }
        
        if(max < sum){
            max = sum;
            globalStart = localStart;
            globalEnd = n - 1;
        }
        
        ans.add(globalStart);
        ans.add(globalEnd);
        return ans;
    }
}
