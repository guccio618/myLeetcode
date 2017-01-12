import java.util.ArrayList;


public class Q091_Minimum_Adjustment_Cost {
	/***************************************************************************
	 *  state: f[i][v] 前i个数,第i个数调整为v, 满足相邻两数<=target,所需要的最小代价
	 *	function: f[i][v] = min(f[i-1][v’] + |A[i]-v|, |v- v’| <= target)
	 *	intialize: f[1][A[1]] = 0, f[1][A[1] +- X] = X answer: f[n][X]
	 *	O(n * A * T)
	 *
	 ***************************************************************************/
	// by other using DP
	public static int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        // D[i][v]: 把index = i的值修改为v，所需要的最小花费
        int[][] dp = new int[A.size()][101];       
        int size = A.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    // The first element.
                    dp[i][j] = Math.abs(j - A.get(i)); // 第i位取j时的cost
                } 
                else {
                    for (int k = 1; k <= 100; k++) {
                        // 不符合条件 
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        
                        int dif = Math.abs(j - A.get(i)) + dp[i - 1][k];  // 前一个位置取j，当前位置取k时的cost
                        dp[i][j] = Math.min(dp[i][j], dif);
                    }
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            result = Math.min(result, dp[size - 1][i]);
        }
        
        return result;
    }
	
	
	
	/***********************************************/
	// by other using recursive + memory
	public static int MinAdjustmentCost2(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        int[][] M = new int[A.size()][100];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < 100; j++) {
                M[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // 首个数字可以取1-100
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            min = Math.min(min, helper(A, target, 0, i, M)); // 第0位选取值从1到100，取其中的最小cost
        }
        
        return min;
    }
    
    /*
     * 将当前值设置为x能求得的最小解 
     * */
    public static int helper(ArrayList<Integer> A, int target, int index, int x, 
           int[][] M) {
        int len = A.size();
        if (index >= len) {
            // The index is out of range.
            return 0;
        }
        
        if (M[index][x - 1] != Integer.MAX_VALUE) {
            return M[index][x - 1];
        }
        
        int bas = Math.abs(x - A.get(index)); // 从当前A.get(index)取值，修改为x时的cost
        int min = Integer.MAX_VALUE;
        
        // 对下一个值尝试取1-100
        for (int i = 1; i <= 100; i++) {
            // 下一个值的取值不可以超过abs
            if (index != len - 1 && Math.abs(i - x) > target) { // 当前位置值x到下一个位置值i之间的diff必须在target范围内
                continue;
            }
            
            // 计算dif 
            int dif = bas + helper(A, target, index + 1, i, M);  // 当前位置值x到下一个位置值i之间的cost
            min = Math.min(min, dif);
        }
        
        // Record the result.
        M[index][x - 1] = min;
        return min;
    }
}
