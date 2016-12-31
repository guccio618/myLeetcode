/******
 * 
Given an array of n integers where n > 1, nums, return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)

 * 
 * */ 

public class Q238_Product_of_Array_Except_Self {	
	// using DP, time is O(n), space is O(n)
	public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }      
        
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        
        for(int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        for(int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < len; i++) {
            left[i] *= right[i];
        }
        
        return left;
    }
	
	
	
	
	// follow up: using DP, time is O(n), space is O(1)
		public int[] productExceptSelf2(int[] nums) {
	        if(nums == null || nums.length == 0){
	            return new int[0];
	        }
	        
	        int len = nums.length;
	        int[] ans = new int[len];
	        ans[0] = 1;
	        int right = 1;
	        
	        for(int i = 1; i < len; i++){
	            ans[i] = ans[i - 1] * nums[i - 1];
	        }
	        
	        for(int i = len - 1; i >= 0; i--){
	            ans[i] *= right;
	            right *= nums[i];
	        }
	        
	        return ans;
	    }
}
