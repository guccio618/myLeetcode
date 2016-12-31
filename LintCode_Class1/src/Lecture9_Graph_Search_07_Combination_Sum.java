import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lecture9_Graph_Search_07_Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res, list, candidates, 0, target);
        return res;
	}
	
	public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int pos, int sum){
		if(sum == 0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = pos; i < candidates.length; ++i){
			if(candidates[i] > sum){
				return;
			}
			list.add(candidates[i]);
			helper(res, list, candidates, i, sum - candidates[i]);
			list.remove(list.size() - 1);
		}
	}
	
	
	
	public static void main(String[] args){
		Lecture9_Graph_Search_07_Combination_Sum t = new Lecture9_Graph_Search_07_Combination_Sum();
		int[] candidates = {2,3,6,7};
		List<List<Integer>> res = t.combinationSum(candidates, 7);
		for(int i = 0; i < res.size(); ++i){
			for(int j = 0; j < res.get(i).size(); ++j){
				System.out.print(res.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
}
