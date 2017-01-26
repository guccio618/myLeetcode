/******
 * 
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
	Input: nums is [1, 1, 1, 1, 1], S is 3. 
	Output: 5

	Explanation: 
		-1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
	There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:
	The length of the given array is positive and will not exceed 20.
	The sum of elements in the given array will not exceed 1000.
	Your output answer is guaranteed to be fitted in a 32-bit integer.
	
 * 
 * */


public class Q494_Target_Sum {
	// test case: [1] 1,  [1,0], 1,  
	
	// solution 1: using backtrack
	private int count = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return count;
        }
        
        backtrack(nums, 0, 0, target);
        return count;
    }
    
    public void backtrack(int[] nums, int start, int solution, int target) {
        if(start == nums.length) {
            if(solution == target) {
                count++;
            }
            
            return;
        }
        
        backtrack(nums, start + 1, solution + nums[start], target);
        backtrack(nums, start + 1, solution - nums[start], target);
    }
	
	
	
	// solution 2: using DP, time is O(n * 2*1000) -> O(n)
    // 处理[-sum, sum]方法： 变为[0, 2*sum]
	public int findTargetSumWays2(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
            return 0;
        } 
        
        int positiveSum = 0;
        
        for(int num : nums) {
        	positiveSum += num;
        }
        
        if(target > positiveSum || target < -positiveSum) {
        	return 0;
        }
        
        int[] dp = new int[positiveSum * 2 + 1];
        dp[0 + positiveSum] = 1;
        
        for(int num : nums) {
        	int[] nextDp = new int[positiveSum * 2 + 1];
        	
        	for(int k = 0; k < dp.length; k++) {
        	    if(k + num < dp.length) {
        	        nextDp[k + num] += dp[k];
        	    }
        		
        		if(k - num >= 0) {
        		    nextDp[k - num] += dp[k];
        		}
        	}
        	
        	dp = nextDp;
        }
        
        return dp[positiveSum + target];
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/****************************** main function ***********************************/
	
	public static void main(String[] args) {
		Q494_Target_Sum t = new Q494_Target_Sum();
		int[] nums = {1,0};
		int target = 1;
		System.out.println(t.findTargetSumWays(nums, target));
	}
}
