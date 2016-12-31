/*******
 * 
Given a positive integer n, find the least number of perfect square numbers 
(for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; 
given n = 13, return 2 because 13 = 4 + 9.

 * 
 * */

public class Q279_Perfect_Squares {
	// using DP
	public int numSquares(int n) {
		if(n <= 0){
            return 0;
        }
        
        int[] ways = new int[n + 1];
        
        for(int i = 1; i <= n; ++i){
            ways[i] = i;
            
            // 优化：for 上加入： “&& i >= j * j”
            for(int j = 1; j * j <= i; ++j){
                ways[i] = Math.min(ways[i], ways[i - j * j] + 1);            
            }
        }
        
        return ways[n];
    }
	
	
	
	
	
	
	/************************** main function ***************************/
	public static void main(String[] args){
		Q279_Perfect_Squares t = new Q279_Perfect_Squares();
		System.out.println(t.numSquares(7));
	}
}
