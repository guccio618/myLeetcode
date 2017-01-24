/********
 * 
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * 
 * */

public class Le_034_Search_for_a_Range {
	// test case:
    // 		nums is empty
    // 		nums contains only one element
    // 		nums do not contain target element
	
	// using binary search
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        
        int[] ans = new int[2];
        ans[0] = searchForLeftBound(nums, target);
        
        if(ans[0] == -1) {
            return new int[]{-1, -1};
        } else {
            ans[1] = searchForRightBound(nums, target, ans[0]);
            return ans;
        }
    }
    
    public int searchForLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(nums[left] == target) {
            return left;
        } else if(nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    
    public int searchForRightBound(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if(nums[right] == target) {
            return right;
        } else if(nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
    
    
    
    
    
    
    
    
    
    
    /********************************** main function **************************************/
    
    public static void main(String[] args){
    	Le_034_Search_for_a_Range test = new Le_034_Search_for_a_Range();
    	int target = 4;
    	int[] array = {1, 5};
    	int[] res = test.searchRange(array, target);
    	for(int i = 0; i < 2; ++i)
    		System.out.println(res[i]);
    }
}
