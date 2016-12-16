import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Le_040_Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return ans;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(ans, list, candidates, 0, target);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> list, int[] candidates, int start, int target){
        if(target == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        } 
        
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target){
                return;
            }
            list.add(candidates[i]);
            backtrack(ans, list, candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
            
            while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
                i++;
            }
        }
    }
}
