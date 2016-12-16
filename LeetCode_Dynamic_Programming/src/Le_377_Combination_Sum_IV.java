import java.util.*;

import javax.swing.ListModel;

/*******
 * 
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

 * 
 * */


public class Le_377_Combination_Sum_IV {
	public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] ways = new int[target + 1];
        ways[0] = 1;
        
        for(int i = 1; i <= target; i++) {
            for(int num : nums) {
                if(i >= num) {
                    ways[i] += ways[i - num];
                }
            }
        }
        
        return ways[target];
    }
	
	
	
	// follow up, What if negative numbers are allowed in the given array?
	private int count = 0;
	
	public int combinationSum4_follow_up(int[] nums, int target){
		if(nums == null || nums.length == 0) {
            return 0;
        }
		
		int len = nums.length;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[len];
		backtrack(ans, new ArrayList<Integer>(), nums, visited, target);		
		return count;
	}
	
	public void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited, int target) {
		if(target == 0) {
			ans.add(new ArrayList<Integer>(list));
			count++;
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				list.add(nums[i]);
				backtrack(ans, list, nums, visited, target - nums[i]);	
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
	
	
	
	
	/******* main function ********/
	public static void main(String[] args){
		Le_377_Combination_Sum_IV t = new Le_377_Combination_Sum_IV();
		int[] nums = {1, 2, -1};
		
		System.out.println(t.combinationSum4_follow_up(nums, 2));
	}
}
