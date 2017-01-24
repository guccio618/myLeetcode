/******
 * 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
	Given array A = [2,3,1,1,4]
	The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
	You can assume that you can always reach the last index. 
	
 * 
 * */

public class Le_045_Jump_Game_II {
	// solution 1: using Greedy, time complexity O(n)
	public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        
        int curFast = nums[0];
        int nextFast = nums[0];
        int n = nums.length;
        int index = 0;
        int step = 1;              // step = 1 !!!
        
        while(curFast < n - 1){    // 只需要到达n - 1, 一旦curFast == n - 1, 表示到达目的地，则停止，否则如果是curFast == n，step就会多加一次 !!!
            step++;
            
            while(index <= curFast){    // 注意有等号 !!!
                nextFast = Math.max(nextFast, index + nums[index]);
                index++;
            }
            
            curFast = nextFast;
        }
        
        return step;
    }
	
	
	
	// solution 2: using DP
	public int jump3(int[] nums) {
        int[] steps = new int[nums.length];
        
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[nums.length - 1];
    }
}
