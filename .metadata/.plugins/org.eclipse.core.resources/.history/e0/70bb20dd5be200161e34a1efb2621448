/*******************************************************
 * 通过交换使得A[i] = i + 1；
 * 寻找第一个正数，使得A[i] != i + 1
 * 
 *******************************************************/


public class Le_041_First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				int tmp = nums[nums[i] - 1]; // 3,4,-1,1
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return n + 1;
    }
}
