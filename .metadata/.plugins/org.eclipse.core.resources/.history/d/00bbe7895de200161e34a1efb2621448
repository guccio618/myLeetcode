import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*****************************************
 * visited[]数组的使用，46题亦可用
 * 
 *****************************************/
public class Le_047_Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(ans, list, nums, visited);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(ans, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
            
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
    }
}
