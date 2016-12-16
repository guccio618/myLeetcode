import java.util.*;

public class Q442_Find_All_Duplicates_in_an_Array {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
		
		if(nums == null || nums.length == 0){
			return ans;
		}
		
		int len = nums.length;
		
		for(int i = 0; i < len; i++){
			while(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		
		for(int i = 0; i < len; i++){
			if(nums[i] != i + 1){
				ans.add(nums[i]);
			}
		}
		
		return ans;
    }
}
