
public class Q101_Remove_Duplicates_from_Sorted_Array_II {
	// by Jackie
	public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        } else if(nums.length <= 2){
            return nums.length;
        }
        
        int pos = 0;
        
        for(int i = 0; i < nums.length; ++i){
            nums[pos++] = nums[i];
            if(i + 1 < nums.length && nums[i] == nums[i + 1]){
                nums[pos++] = nums[i + 1];
                i++;
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
        
        return pos;
    }
}
