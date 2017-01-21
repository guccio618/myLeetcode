/******
 * 
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
	Input: [1,0,1,1,0]
	Output: 4
	Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    			 After flipping, the maximum number of consecutive 1s is 4.
Note:
	The input array will only contain 0 and 1.
	The length of input array is a positive integer and will not exceed 10,000

Follow up:
	What if the input numbers come in one by one as an infinite stream? 
	In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. 
	Could you solve it efficiently?
	
 * 
 * 
 * */

public class Le_487_Max_Consecutive_Ones_II {
	// test case: nums = 
    //  null,  [],
    //  [0, 0]
    //  [1, 0, 1, 1, 0]
    
	// using two pointers, time is O(n)
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int maxLen = 0;
        int[] hash = new int[2];
        
        for(int faster = 0, slower = 0; faster < len; faster++) {
            hash[nums[faster]]++;
            
            while(slower < faster && hash[0] > 1) {
                hash[nums[slower++]]--;
            }
            
            if(hash[0] <= 1) {
                maxLen = Math.max(maxLen, faster - slower + 1);
            }
        }
        
        return maxLen;
    }
}
