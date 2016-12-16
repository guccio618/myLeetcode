
public class Le_096_Unique_Binary_Search_Trees {
	/**********************************************************
	 * BST
	 * 树的组合个数取决于： 左子树的组合 * 右子树的组合
	 * 	(1). 由子树递推出当前树的组合个数，考虑用DP。
	 * 	(2). 从 1 trave 到 n, 列举出分别以其作为root结点的情况。
	 * 	(3). 用Divide & Conquer (递归) 先计算左右子树的组合个数，
	 * 		 从而得到当前需要求的组合个数。 
	 * 	(4). 引入记忆化搜索，去除重复计算。 
	 *      
	 **********************************************************/

	// by Jackie using memory search
	public int numTrees(int n) {
        if(n <= 0){
            return 0; 
        } else if(n <= 1){
            return 1;
        }
        
        int[] memo = new int[n + 1];
        memo[0] = memo[1] = 1;
        
        return helper(1, n, memo);    // 从第1个点到第n个点
    }
	
    
    public int helper(int start, int end, int[] memo){
        if(start > end){
            return 0;
        } else if(memo[end - start + 1] > 0){
            return memo[end - start + 1];
        }
        
        int count = 0;
        
        // 从 1 trave 到 n, 表示以i为root的BST，[start, i - 1]表示左子树， [i + 1, right]表示右子树
        // 因为是BST时，[start, i - 1]均小于i,因此表示左子树；[i + 1, right]表示右子树
        for(int i = start; i <= end; ++i){       
            int left = helper(start, i - 1, memo);
            int right = helper(i + 1, end, memo);
            
            if(left == 0 || right == 0){   // 其中有子树为空的时候
                count += (left + right);
            } else {
                count += (left * right);
            } 
        }
        
        memo[end - start + 1] = count;
        return count;
    }
    
    
    
    /*******************************************************/
	// by other using DP
	public int numTrees2(int n) {
        if(n <= 0){
            return 0;
        } else if(n <= 1){
            return 1;
        }
        
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < i; ++j){                     // j 表示左子树的个数
                count[i] += count[j] * count[i - 1 - j];    // i - j - 1，表示排除了1个root结点后，右子树的个数
            }
        }
        
        return count[n];
    }
	
	
	
	/************************** main function *****************************/
	public static void main(String[] args){
		Le_096_Unique_Binary_Search_Trees t = new Le_096_Unique_Binary_Search_Trees();
		System.out.println(t.numTrees(3));
	}
}
