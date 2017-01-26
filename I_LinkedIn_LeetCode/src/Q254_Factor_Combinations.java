import java.util.ArrayList;
import java.util.List;
/********
 * 
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
	You may assume that n is always positive.
	Factors should be greater than 1 and less than n.

Examples: 
	input: 1
	output: []
	
	input: 37
	output: []
	
	input: 12
	output:
	[
  		[2, 6],
  		[2, 2, 3],
  		[3, 4]
	]
	
	input: 32
	output:
	[
  		[2, 16],
  		[2, 2, 8],
  		[2, 2, 2, 4],
  		[2, 2, 2, 2, 2],
  		[2, 4, 4],
  		[4, 8]
	]
	
 * 
 * */

public class Q254_Factor_Combinations {
	// solution 1: using backtracking
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
