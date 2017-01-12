import java.util.Arrays;


public class Q443_Two_Sum_II {
	public int twoSum2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int res = 0;
        
        while(left < right){
            if(nums[left] + nums[right] > target){
                res += right - left;
                right--;
            } else{
                left++;
            }
        }
        
        return res;
    }
}
