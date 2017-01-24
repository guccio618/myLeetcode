import java.util.*;
/********
 * 
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * 
 * */

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
