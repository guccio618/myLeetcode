/********
 * 
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 * 
 * */

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
	
	// recursive + DP, space O(n)
	public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        
        // memo[i] means how many unique tree dose the len of n will have
        // 因为是从 1 到 n，因此这里需要定义到 n + 1 !!!
        int[] memo = new int[n + 1];     
        memo[0] = 0;             
        memo[1] = 1;
        
        return helper(memo, 1, n);
    }
    
    public int helper(int[] memo, int start, int end){
        if(start > end){
            return 0;
        } else if(memo[end - start + 1] > 0){
            return memo[end - start + 1];
        }
        
        for(int i = start; i <= end; i++){
            int left = helper(memo, start, i - 1);
            int right = helper(memo, i + 1, end);
            
            if(left == 0 || right == 0){
            	memo[end - start + 1] += left + right;
            } else {
            	memo[end - start + 1] += left * right;
            }
        }

        return memo[end - start + 1];
    }
    
	
	
    // solution 2: space O(n^2)
    public int numTrees2(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[][] memo = new int[n+1][n+1];
        return search(memo, 1, n);
    }
    
    public int search(int[][] memo, int start, int end) {
        if(start > end) {
            return 0;
        } else if(start == end) {
            return 1;
        } else if(memo[start][end] > 0) {
            return memo[start][end];
        }
        
        for(int root = start; root <= end; root++) {
            int left = search(memo, start, root-1);
            int right = search(memo, root+1, end);
            
            if(left == 0 || right == 0) {
                memo[start][end] += left + right;
            } else {
                memo[start][end] += left * right;
            }
        }
        
        return memo[start][end];
    }
    
    
    
    
    
    /*******************************************************/
	// by other
	public int numTrees3(int n) {
	    int count[] = new int[n + 1];   //count[i]: Possible amount for i numbers
	    count[0] = 1;                   //Empty tree
	    count[1] = 1;                   //Tree with one node 

	    for (int i = 2; i <= n; i++)    //number amount: i
	        for (int j = 0; j < i; j++) //Possible amount with j as the root
	            count[i] += count[j] * count[i-1-j]; //Divide i numbers into 2 parts with j: 1) 0..j 2) j..i-1. Count[i] is count[left part] * count[right part]        
	    return count[n];
	} 
	
    
    public static void main(String[] args){
    	Le_096_Unique_Binary_Search_Trees t = new Le_096_Unique_Binary_Search_Trees();
    	System.out.println(t.numTrees(5));
    }
}
