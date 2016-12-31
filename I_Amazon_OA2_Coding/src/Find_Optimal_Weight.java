import java.util.Arrays;

public class Find_Optimal_Weight {
	/*******
	 * two sum close
	 * 
	 * */
	
	public static int findOptimalWeight(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		int diff = Integer.MAX_VALUE;
		int ans = -1;
		
		while(left < right) {
			int sum = nums[left] + nums[right];
			
			if(sum > target) {
				right--;
			} else if(sum < target) {
				left++;
				
				if(Math.abs(sum - target) < diff) {
					diff = Math.abs(sum - target);
					ans = sum;
				}
			} else {
				return sum;
			}
		}
		
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {9,2,5,3,6,2,4,6};
		int target = 11;
		System.out.println(findOptimalWeight(nums, target));
	}
}
