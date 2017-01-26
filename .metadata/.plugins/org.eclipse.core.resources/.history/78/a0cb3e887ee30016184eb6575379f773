import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Le_090_Subsets_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(ans, list, nums, 0);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, ArrayList<Integer> list, int[] nums, int pos){
        ans.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
            
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
    }
}
