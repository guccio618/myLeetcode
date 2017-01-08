import java.util.*;
/********
 * 
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
	Input:
	[4,3,2,7,8,2,3,1]
	Output:
	[5,6]

 * 
 * */

public class Q448_Find_All_Numbers_Disappeared_in_an_Array {
	// using hashset, time is O(n), space is O(n)
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
        	set.add(num);
        }
        
        for(int i = 1; i <= nums.length; i++) {
        	if(!set.contains(i)) {
        		ans.add(i);
        	}
        };
        
        return ans;
	}
	
	
	
	// solution 2: time is O(n), space is O(1)
	public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
            while(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        
        return ans;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************** main function *************************************/
	
	public static void main(String[] args) {
		Q448_Find_All_Numbers_Disappeared_in_an_Array t = new Q448_Find_All_Numbers_Disappeared_in_an_Array();
		
	}
}
