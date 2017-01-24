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

	
	
	
	
	
	
	
	
	
	
	
	
	/********************************** main function ****************************************/
	
	public static void main(String[] args){
		Le_016_3Sum_Closest t = new Le_016_3Sum_Closest();
		int[] nums = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4
				};
		int target = -275;
		System.out.println(t.threeSumClosest(nums, target));
	}
}
