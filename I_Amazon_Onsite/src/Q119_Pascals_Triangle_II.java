import java.util.ArrayList;
import java.util.List;

/******
 * 
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

 * 
 * */

public class Q119_Pascals_Triangle_II {
	// solution 1: time is O(n^2), space is O(k)
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList<Integer>();
        if(rowIndex < 0){
            return ans;
        }
        
        int[][] dp = new int[2][rowIndex + 1];
        
        for(int i = 0; i <= rowIndex; ++i){
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i){
                    dp[i % 2][j] = 1;
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[(i - 1) % 2][j - 1];
                }
                
                if(i == rowIndex){
                    ans.add(dp[i % 2][j]);
                }
            }
        }
        
        return ans;
    }
	
	
	
	
	
	
	
	
	/*************************** main function ******************************/
	public static void main(String[] args){
		Q119_Pascals_Triangle_II t = new Q119_Pascals_Triangle_II();
		List<Integer> res = new ArrayList<Integer>();
		res = t.getRow(1);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
