import java.util.Arrays;


public class Li_443_Two_Sum_II_Input_array_is_sorted {
	public int twoSum2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        
        while(left < right){
            if(nums[left] + nums[right] > target){
                count += (right - left);
                right--;
            } else {
                left++;
            }
        }
        
        return count;
    }
}
