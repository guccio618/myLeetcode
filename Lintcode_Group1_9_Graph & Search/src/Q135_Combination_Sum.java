import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q135_Combination_Sum {
	// by Jackie
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res, list, candidates, 0, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int start, int sum){
        if(sum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
           
        for(int i = start; i < candidates.length; ++i){
            if(sum - candidates[i] < 0){
                return;
            }
            list.add(candidates[i]);
            helper(res, list, candidates, i, sum - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
