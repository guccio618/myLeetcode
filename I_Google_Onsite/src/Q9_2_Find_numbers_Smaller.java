import java.util.Arrays;

public class Q9_2_Find_numbers_Smaller {
	public int findNumberSmaller(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		} else if(nums.length == 1) {
			return nums[0] <= target ? 1 : 0;
		}
		
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		int count = 0;
		
		while(left < right) {
			int diff = target - nums[left];
			int index = binarySearch(nums, diff);
			count += Math.max(0, index - left);
			left++;
		}
		
		return count;
	}
	
	public int binarySearch(int[] nums, int elem) {
		int left = 0, right = nums.length - 1;
		
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] > elem) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		if(nums[right] <= elem) {
			return right;
		} else {
			return left;
		}
	}
	
	
	
	
	
	
	
	
	/******************************* main function ************************************/
	
	public static void main(String[] args) {
		Q9_2_Find_numbers_Smaller t = new Q9_2_Find_numbers_Smaller();
		int[] nums = {1,2,3,4,5,6};
		int target = 5;
		System.out.println(t.findNumberSmaller(nums, target));
	}
}
