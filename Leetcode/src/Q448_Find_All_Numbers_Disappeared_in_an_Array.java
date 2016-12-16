import java.util.*;

public class Q448_Find_All_Numbers_Disappeared_in_an_Array {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
            while(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        
        return ans;
    }
}
