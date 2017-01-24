import java.util.*;


public class Q039_Combination_Sum {
	/****************************************************/
	// by Jackie
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        
        if(candidates == null || candidates.length == 0) {
            return ans;
        }
        
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<Integer>(), target, candidates, 0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> solution, int target, int[] candidates, int start) {
        if(target == 0) {
            ans.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            if(target < candidates[i]) {
                return ;
            }
            
            solution.add(candidates[i]);
            backtrack(ans, solution, target - candidates[i], candidates, i);
            solution.remove(solution.size() - 1);
        }
    }
	
	
	public static void main(String[] args){
		Q039_Combination_Sum t = new Q039_Combination_Sum();
		int[] nums = {2,3,6,7};
		List<List<Integer>> res = t.combinationSum(nums, 7);
		for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
	}
}
