/*******
 * 
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 * 
 * */


/*****************************************************************************************
 * cost[i][j]: minimum number of money to guarantee win for subproblem [i, j].
 * Target: cost[1][n]
 * Corner case: cost[i][i] = 0 (because the only element must be correct)
 * Equation: choose k (i<=k<=j) as our guess, and pay price k. After our guess, 
 * 			 the problem is divided into two subproblems. Notice we do not need to pay 
 * 			 the money for both subproblems. We only need to pay the worst case (because 
 * 			 the system will tell us which side we should go) to guarantee win. 
 * 
 *****************************************************************************************/

public class Le_375_Guess_Number_Higher_or_Lower_II {
	// time O(n^3), space O(n^2)
	public int getMoneyAmount(int n) {
        if(n <= 1){
            return 0;
        }
        
        int[][] cost = new int[n + 1][n + 1];
        
        for(int length = 1; length <= n; length++){   // start=1表示从1开始猜
            for(int start = 1; start + length <= n; start++){
                int end = start + length;
                cost[start][end] = Integer.MAX_VALUE;
                
                for(int guess = start; guess <= end; guess++){
                    int leftPart = guess - 1 >= start ? cost[start][guess - 1] : 0;
                    int rightPart = guess + 1 <= end ? cost[guess + 1][end] : 0;
                    cost[start][end] = Math.min(cost[start][end], guess + Math.max(leftPart, rightPart));
                }
            }
        }
        
        return cost[1][n];
    }
}
