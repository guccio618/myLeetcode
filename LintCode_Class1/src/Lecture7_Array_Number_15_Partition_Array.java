
public class Lecture7_Array_Number_15_Partition_Array {
	public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    int left = 0, right = nums.length - 1;
	    while(left < right){
	        while(left < nums.length && nums[left] < k){
	            left++;
	        }
	        while(right >= 0 && nums[right] >= k){
	            right--;
	        }
	        if(left < right){
	            int temp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = temp;
	        }
	    }
	    return left;
    }
}
