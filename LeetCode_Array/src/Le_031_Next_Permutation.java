	/***************************************************************
	 * 如输入：1 4 6 5 3 2
	 * step1：从右往左找到第一个破坏升序(非严格)的元素，此例中为4.记下标为 i
     * step2: 依然从右往左,找到第一个大于4的元素，此例中5，交换4和5.
     * step3：从i+1到最右端，逆置。6 4 3 2 to 2 3 4 6
	 * 
	 ***************************************************************/

public class Le_031_Next_Permutation {
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int n = nums.length;
        int pos1 = n - 2, pos2 =  n - 1;
        
        while(pos1 >= 0 && nums[pos1] >= nums[pos1 + 1]){       // 破坏升序排列，包含等号 ！！！
            pos1--;
        }
        
        if(pos1 >= 0){
            while(pos2 >= 0 && nums[pos2] <= nums[pos1]){
                pos2--;
            }
            swap(nums, pos1, pos2);
        }
        
        reverse(nums, pos1 + 1, n - 1);
    }
    
    public void swap(int[] nums, int x, int y){
        nums[x] = nums[x] + nums[y];
        nums[y] = nums[x] - nums[y];
        nums[x] = nums[x] - nums[y];
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            left++;
            right--;
        }
    }
}
