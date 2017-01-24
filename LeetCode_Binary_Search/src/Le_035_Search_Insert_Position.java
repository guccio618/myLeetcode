/******
 * 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 * 
 * */

public class Le_035_Search_Insert_Position {
	// test case:
    // nums is empty
    
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            } 
        }

        if(nums[left] >= target) {
            return left;
        } else if(nums[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }
}
