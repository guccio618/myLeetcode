import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lecture9_Graph_Search_08_Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(res, list, num, 0, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] num, int pos, int sum){
        if(sum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < num.length; ++i){
            if(sum < num[i]){
                return;
            }
            list.add(num[i]);
            helper(res, list, num, i + 1, sum - num[i]);
            list.remove(list.size() - 1);
            while(i + 1 < num.length && num[i] == num[i + 1]){
            	i++;
            }
        }
    }
    
    
    public static void main(String[] args){
    	Lecture9_Graph_Search_08_Combination_Sum_II t = new Lecture9_Graph_Search_08_Combination_Sum_II();
    	int[] num = {7,1,2,5,1,6,10};
    	List<List<Integer>> res = t.combinationSum2(num, 8);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
