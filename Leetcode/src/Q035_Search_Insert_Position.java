
public class Q035_Search_Insert_Position {
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
