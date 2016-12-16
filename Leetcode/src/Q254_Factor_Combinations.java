import java.util.ArrayList;
import java.util.List;


public class Q254_Factor_Combinations {
	// by Jackie using backtracking
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
	    
	    if(n <= 1){
	        return ans;
	    }
	    
	    List<Integer> list = new ArrayList<Integer>();
	    
	    backtrack(ans, list, 2, n, n);
	    return ans;
    }
    
	public void backtrack(List<List<Integer>> ans, List<Integer> list, int start, int leftValue, int n){
	    if(leftValue == 1){
	        ans.add(new ArrayList<Integer>(list));
	        return ;
	    }
	    
	    for(int i = start; i <= n / 2 && i <= leftValue; i++){  // 注意这里 i <= n / 2 && i <= leftValue !!!
	        if(leftValue % i == 0){
	            list.add(i);
	            backtrack(ans, list, i, leftValue / i, n);
	            list.remove(list.size() - 1);
	        } 
	    }
	}
    
    // 第二部分backtrack可以优化为以下部分
    public void backtrack(List<List<Integer>> ans, List<Integer> list, int start, int leftValue){
        if(leftValue == 1){
            if(list.size() > 1){
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for(int i = start; i <= leftValue; i++){
            if(leftValue % i == 0){
                list.add(i);
                backtrack(ans, list, i, leftValue/i);
                list.remove(list.size() - 1);
            }
        }
    }
}
