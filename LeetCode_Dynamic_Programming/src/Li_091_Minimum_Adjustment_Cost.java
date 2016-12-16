import java.util.ArrayList;
/*****
 * 
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

 Notice

You can assume each number in the array is a positive integer and not greater than 100.

Example
	Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

	Return 2.

 * 
 * */

public class Li_091_Minimum_Adjustment_Cost {
	/************************************************************************
	 * Statement:  cost[i][j]: 前i个数修改为值是j时花费的代价
	 * Function:   cost[i][j] = cost[i - 1][k] + abs(j - nums[i])
	 *  
	 ************************************************************************/
	
	public static int MinAdjustmentCost(ArrayList<Integer> nums, int target) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int n = nums.size();
        int[][] cost = new int[n][101];
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; ++i){
            for(int j = 1; j <= 100; ++j){
                cost[i][j] = Integer.MAX_VALUE;
                if(i == 0){
                    cost[i][j] = Math.abs(nums.get(i) - j);
                } else {
                    for(int k = 1; k <= 100; ++k){
                        if(Math.abs(j - k) <= target){  // 当前的j值由前一个k值推得
                            int diff = cost[i - 1][k] + Math.abs(nums.get(i) - j);
                            cost[i][j] = Math.min(cost[i][j], diff);
                        }    
                    }
                }
            }
        }
        
        for(int i = 1; i <= 100; ++i){
            ans = Math.min(ans, cost[n - 1][i]);
        }
        
        return ans;
    }
}
