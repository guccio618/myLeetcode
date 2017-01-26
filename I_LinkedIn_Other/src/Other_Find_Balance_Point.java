
public class Other_Find_Balance_Point {
	// test case:
	// nums is empty
	// nums contains only one element;
	// do not have a balance point
	// contains duplicate
	
	// time complexity is O(n), space is O(n)
	public int findBalancePoint(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		int[] left = new int[len];
		int[] right = new int[len];
		left[0] = nums[0];
		right[len - 1] = nums[len - 1];
		
		for(int i = 1; i < len; i++) {
			left[i] = left[i - 1] + nums[i];
		}
		
		for(int i = len - 2; i >= 0; i--) {
			right[i] = right[i + 1] + right[i];
		}
		
		for(int i = 0; i < len; i++) {
			if(left[i] == right[i]) {
				return i;
			}
		}
		
		return -1;
	}
	
	// time complexity is O(n), space is O(1)
	public int findBalancePoint2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		int totalSum = 0;
		int curSum = 0;
		
		for(int i = 0; i < len; i++) {
			totalSum += nums[i];
		}
		
		for(int i = 0; i < len; i++) {
			curSum += nums[i];
			
			if(curSum * 2 == totalSum) {
				return i;
			}
		}
		
		return -1;
	}
}
