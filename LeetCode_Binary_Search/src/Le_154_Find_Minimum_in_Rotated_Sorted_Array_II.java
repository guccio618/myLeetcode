
public class Le_154_Find_Minimum_in_Rotated_Sorted_Array_II {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = Integer.MAX_VALUE;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            ans = Math.min(ans, nums[left]);
            ans = Math.min(ans, nums[right]);
            ans = Math.min(ans, nums[mid]);
            
            if(nums[mid] > nums[left] || nums[mid] > nums[right]){
                left = mid;
            } else if(nums[mid] < nums[left] || nums[mid] < nums[right]){
                right = mid;
            } else {
                right--;
            }
        }
        
        return Math.min(ans, Math.min(nums[left], nums[right]));
    }
}
