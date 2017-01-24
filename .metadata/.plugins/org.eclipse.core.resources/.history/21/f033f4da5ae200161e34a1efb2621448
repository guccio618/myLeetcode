import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Le_039_Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return ans;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(ans, list, candidates, 0, target);
        return ans;        
    }
    
    public void helper(List<List<Integer>> ans, ArrayList<Integer> list, int[] candidates, int pos, int target){
        if(target == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        } 
        
        for(int i = pos; i < candidates.length; i++){
            if(candidates[i] > target){
                return;    // 因为已经数组sorted了，当前元素如果不符合，往下走的元素必然也不符合
            }
            list.add(candidates[i]);
            helper(ans, list, candidates, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
