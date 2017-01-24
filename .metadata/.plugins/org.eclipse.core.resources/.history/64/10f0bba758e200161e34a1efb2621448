
public class Le_033_Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > nums[left] || nums[mid] > nums[right]){
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
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }
}
