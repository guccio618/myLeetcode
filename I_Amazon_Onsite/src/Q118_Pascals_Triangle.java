import java.util.ArrayList;
import java.util.List;

/******
 * 
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * 
 * */

public class Q118_Pascals_Triangle {
	// solution 1: time is O(n^2), space is O(n)
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(numRows <= 0) {
            return ans;
        }
        
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    int num = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                    list.add(num);
                }
            }
            
            ans.add(list);
        }
        
        return ans;
    }
	
	
	
	
	
	
	// solution 2: using DP, time is O(n^2), space is O(n)
	public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(numRows <= 0){
            return ans;
        }
        
        int[][] dp = new int[2][numRows];
        
        for(int i = 0; i < numRows; ++i){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){
                    dp[i % 2][j] = 1;
                } else {
                    dp[i % 2][j] = dp[1 - i % 2][j] + dp[1 - i % 2][j - 1];
                }
                
                list.add(dp[i % 2][j]);
            }
            ans.add(list);
        }
        
        return ans;
    }
}
