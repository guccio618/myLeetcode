/******
 * 
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.

For example, 
	given the array [2,3,1,2,4,3] and s = 7,
	the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * */


public class Le_209_Minimum_Size_Subarray_Sum {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int front = 0, len = nums.length;
        int minLen = Integer.MAX_VALUE;
        
        for(int back = 0; back < len; back++) {
            while(front < len && sum < s) {
                sum += nums[front++];
            }    
            
            if(sum >= s) {
                minLen = Math.min(minLen, front - back);
            }
            
            sum -= nums[back];
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
