import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Q077_Combinations {
	/*************************************************************/
	// by Jackie
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || n < k){
            return ans;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        backtrack(ans, list, n, 1, k);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> list, int n, int start, int k){
        if(list.size() == k){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start; i <= n; i++){
            list.add(i);
            backtrack(ans, list, n, i + 1, k);
            list.remove(list.size() - 1);
        }
    }
    
    
    public static void main(String[] args){
    	Q077_Combinations t = new Q077_Combinations();
    	List<List<Integer>> res = t.combine(4, 2);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
