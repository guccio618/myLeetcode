
public class Q100_Remove_Duplicates_from_Sorted_Array {
	// by Jackie
	public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        } else if(nums.length <= 1){
            return nums.length;
        }
        
        int pos = 0;
        int len = nums.length;
        
        for(int i = 0; i < len; ++i){
            nums[pos++] = nums[i];
            while(i + 1 < len && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return pos;
    }
}
