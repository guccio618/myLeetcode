import java.util.*;

/*****
 * 
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.

Example 1:
	Input: [1, 5, 11, 5]
	Output: true

	Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
	Input: [1, 2, 3, 5]
	Output: false

	Explanation: The array cannot be partitioned into equal sum subsets.

 *
 * */
public class Le_416_Partition_Equal_Subset_Sum {
	// solution 1: using backtack
	public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        
        int target = 0;
        
        for(int num : nums) {
            target += num;
        }
        
        if(target % 2 != 0) {
            return false;
        } 
        
        target /= 2;
        Arrays.sort(nums);
        return backtrack(nums, nums.length - 1, target);
    }
	
	public boolean backtrack(int[] nums, int start, int target) {
		if(target == 0) {
			return true;
		} 
		
		for(int i = start; i >= 0; i--) {
		    if(target < nums[i]) {
		        continue;
		    }
		    
		    if(backtrack(nums, i - 1, target - nums[i]) == true) {
			    return true;
			}
		}
		
		return false;
	}
	
	
	
	// solution 2: using DP
	public boolean canPartition2(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        
        long target = 0;
        
        for(int num : nums) {
            target += num;
        }
        
        if(target % 2 != 0) {
            return false;
        } 
        
        target /= 2;      
        int len = nums.length;
        Set<Integer>[] memo = new Set[len];
        memo[0] = new HashSet<>();
        memo[0].add(nums[0]);
        
        for(int i = 1; i < len; i++) {
        	memo[i] = new HashSet<>(memo[i-1]);
        	
        	for(int num : memo[i-1]) {
        		if(num + nums[i] <= target) {
        			memo[i].add(num + nums[i]);
        		}      		
        	}
        }
  
        return memo[len-1].contains((int) target);
	}
	
	
	
	
	
	
	/***** main function *****/
	public static void main(String[] args) {
		Le_416_Partition_Equal_Subset_Sum t = new Le_416_Partition_Equal_Subset_Sum();
		int[] nums = {1,5,11,5};
		int[] nums2 = {1,2,3,5};
		int[] nums3 = {19,33,38,60,81,49,13,61,50,73,60,82,73,29,65,62,53,29,53,86,16,83,52,67,41,53,18,48,32,35,51,72,22,22,76,97,68,88,64,19,76,66,45,29,95,24,95,29,95,76,65,35,24,85,95,87,64,97,75,88,88,65,43,79,6,5,70,51,73,87,76,68,56,57,69,77,22,27,29,12,55,58,18,30,66,53,53,81,94,76,28,41,77,17,60,32,62,62,88,61};
		int[] nums4 = {98,31,19,48,18,47,14,64,94,57,1,73,12,93,85,30,99,57,42,86,62,47,18,18,81,76,40,67,98,60,86,65,71,74,61,91,29,35,70,62,74,31,34,41,95,62,36,47,36,40,13,45,80,50,23,69,1,93,54,13,86,70,61,82,55,51,71,94,84,52,14,44,6,79,52,86,22,4,67,52,49,70,73,32,20,18,63,54,86,58,61,18,31,50,61,15,63,41,76,58};
		int[] target = nums4;
		
		System.out.println(t.canPartition(target));
		System.out.println(t.canPartition2(target));
	}
}
