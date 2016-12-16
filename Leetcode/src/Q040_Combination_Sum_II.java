/******************************************************************************
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 ******************************************************************************/
import java.util.*;


public class Q040_Combination_Sum_II {
	/*******************************************************/
	// by other, faster
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            backtrack(ans, solution, target - candidates[i], candidates, i + 1);
            solution.remove(solution.size() - 1);
            
            // eliminate the duplicate
            while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
	
	
	/*******************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
    public LinkedList<LinkedList<Integer>> combinationSum2_2(int[] candidates, int target) {
        if(candidates == null || target <= 0) return res;
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<Integer>();
        for(int i = 0, len = candidates.length; i < len; ++i){
        	if(i > 0 && candidates[i-1] == candidates[i]) continue;
        	backtrack(candidates, i, target, path);
        }
        return res;
    }
    
    public void backtrack(int[] candidates, int pos, int sum, LinkedList<Integer> path){
        if(sum < 0) return;
        
        path.add(candidates[pos]);
        sum -= candidates[pos];
        if(sum == 0) {
            res.add(new LinkedList<Integer>(path));
        } else{
            for(int i = pos+1, len = candidates.length; i < len; ++i){
            	if(candidates[pos] > sum) break;
                backtrack(candidates, i, sum, path);
                while(i+1 < len && candidates[i+1] == candidates[i]) i++;  // 去除candidates里重复的num
            }
        }
        path.remove(path.size()-1);
    }
    
    public void print(int[] array){
    	for(int i = 0; i < array.length; ++i)
    		System.out.print(array[i] + ", ");
    	System.out.println();
    }
    
    public static void main(String[] args){
    	Q040_Combination_Sum_II t = new Q040_Combination_Sum_II();
    	int[] candidates = {-1,10,1,2,7,6,1,5};
//    	LinkedList<LinkedList<Integer>> res = t.combinationSum2(candidates, 8);
    	int[] candidates2 = {2,2,2};
    	List<List<Integer>> res = t.combinationSum2(candidates, 4);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
