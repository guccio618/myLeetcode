import java.util.ArrayList;
import java.util.List;


public class Le_046_Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        helper(nums, list, ans);
        return ans;
    }
    
    public void helper(int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(nums, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
