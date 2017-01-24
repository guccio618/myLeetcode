import java.util.*;

/****
 * 
	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 *  test case: sum = nums[i] + nums[left] + nums[right] > Integer.MAX_VALUE 
 * */


public class Le_016_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) {
            return 0;
        }
        
        int len = nums.length;
        long closetSum = 0;
        long diff = Long.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            
            while(left < right) {
                long sum = nums[i] + nums[left] + nums[right];
                
                if(diff > Math.abs(sum - (long) target)) {
                    diff = Math.abs(sum - (long) target);
                    closetSum = sum;
                }
                
                if(sum == (long) target) {
                    break;
                } else if (sum > (long) target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return (int) closetSum;
    }
}
