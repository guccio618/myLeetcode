/******
 * 
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts 
have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 * 
 * */

public class Q276_Paint_Fence {
	/*****************************************************************************************************************
	 *  分成两种状态考虑，一种是相邻的paint相同颜色，一种是不同颜色
	 *  State:    sameColor[i]相邻颜色相同的种类，diffColor相邻颜色不同的种类
	 * 	Function: sameColor[i] = diffColor[i - 1], diffColor[i] = (sameColor[i - 1] + diffColor[i - 1]) * (k - 1)
	 * 	Initial:  dp[0][j] = matrix[0][j] - '0',  dp[i][0] = matrix[i][0] - '0';
	 * 	Answer:   max(dp[i][j]) ^ 2;
	 * 
	 ****************************************************************************************************************/
	// solution 1: using DP, space O(n)
	public int numWays(int n, int k) {
        if(n == 0){
            return 0;
        } else if(n == 1){
            return k;
        }
        
        int[] sameColor = new int[n];
        int[] diffColor = new int[n];
        sameColor[0] = diffColor[0] = k;
        sameColor[1] = k;
        diffColor[1] = k * (k - 1);
        
        for(int i = 2; i < n; ++i){
            sameColor[i] = diffColor[i - 1];
            diffColor[i] = (diffColor[i - 1] + sameColor[i - 1]) * (k - 1);
        }
        
        return sameColor[n - 1] + diffColor[n - 1];
    }
	
	
	
	
	
	// follow up: 空间优化过， space O(1)
	public int numWays2(int n, int k) {
        if(n == 0){
            return 0;
        } else if(n == 1){
            return k;
        }
        
        int sameColor = k;
        int diffColor = k * (k - 1);
        
        for(int i = 2; i < n; ++i){
            int temp = diffColor;
            diffColor = (sameColor + diffColor) * (k - 1);
            sameColor = temp;
        }
        
        return sameColor + diffColor;
    }
}
