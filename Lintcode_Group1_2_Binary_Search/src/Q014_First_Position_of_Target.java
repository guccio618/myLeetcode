
public class Q014_First_Position_of_Target {
	// by Jackie
	public int binarySearch(int[] nums, int target) {
		if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                left = mid;
            }
            else {    // 因为寻找的是第一个target出现的位置，因此right往左移；如果求的是target的最后一个位置，则left往右移
                right = mid;
            }
        }
        
        if(nums[left] == target){
            return left;
        } else if(nums[right] == target){
            return right;
        }
        return -1;
    }
}
