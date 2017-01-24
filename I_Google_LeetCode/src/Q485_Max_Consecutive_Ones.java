/*****
 * 
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 * 
 * */

public class Q485_Max_Consecutive_Ones {
	// test case: 
    //      nums = null, nums = []
    //      nums = [1], nums = [0]
    //      nums = [0,0], nums = [1,0]
    //      nums = [1,0,1,1,0,1]
    
    // using tow pointers, time is O(n)
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        } 
        
        int len = nums.length, maxLen = 0;
        int[] hash = new int[2];
        
        for(int faster = 0, slower = 0; faster < len; faster++) {
            hash[nums[faster]]++;
            
            while(slower < faster && hash[0] > 0) {
                hash[nums[slower++]]--;
            }
            
            if(hash[0] == 0) {
                maxLen = Math.max(maxLen, faster - slower + 1);
            }
        }
        
        return maxLen;
    }
}
