import java.util.*;


public class Other_Find_Max_Distance_Between_x_and_y {
	// test case:
	// nums is empty
	// nums conains duplicate
	
	public int[] findMaxDistance(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}
		
		int len = nums.length;
		int arrayLen = 0;
		int maxLen = Integer.MIN_VALUE;
		int[] ans = new int[2];
		int[] arrays = new int[len];
		int[] indexs = new int[len];
		
		for(int i = 0; i < len; i++) {
			if(arrayLen == 0 || arrays[arrayLen - 1] < nums[i]) {
				arrays[arrayLen] = nums[i];
				indexs[arrayLen] = i;
				arrayLen++;
			} else {
				int pos = Arrays.binarySearch(arrays, 0, arrayLen, nums[i]);
				pos = (pos < 0) ? -(pos + 1) : pos;
				arrays[pos] = nums[i];
				indexs[pos] = i;
			}
			
			if(maxLen < nums[i] - arrays[0]) {
				maxLen = nums[i] - arrays[0];
				ans[0] = indexs[0];
				ans[1] = i;
			}
		}
		
		return ans;
	}
	
	public int[] findMaxDistance2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}
		
		int len = nums.length;
		int maxLen = Integer.MIN_VALUE;
		int[] ans = new int[2];
		
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				if(nums[j] > nums[i]) {
					if(maxLen < nums[j] - nums[i]) {
						maxLen = nums[j] - nums[i];
						ans[0] = i;
						ans[1] = j;
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Other_Find_Max_Distance_Between_x_and_y t = new Other_Find_Max_Distance_Between_x_and_y();
		int[] nums = {4,545,234,7,4,2,8,9,34,32,15,78};
		
		int[] ans1 = t.findMaxDistance(nums);
		int[] ans2 = t.findMaxDistance2(nums);
		
		System.out.println(ans1[0] + " -> " + ans2[0]);
		System.out.println(ans1[1] + " -> " + ans2[1]);
	}
}
