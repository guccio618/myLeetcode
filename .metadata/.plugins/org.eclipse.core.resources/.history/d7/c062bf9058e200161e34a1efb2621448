
public class Q033_Search_in_Rotated_Sorted_Array {
	/*******************************************************/
	// by Jackie using binary search
	// 分类讨论
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0){
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] > nums[left] || nums[mid] > nums[right]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid;
                } else {
                    left = mid;
                }
            } else if(nums[mid] < nums[left] || nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                right--;
            }
        }
        
        if(nums[left] == target){
            return left;
        } else if(nums[right] == target){
            return right;
        } else {
            return -1;
        }
    }
}
