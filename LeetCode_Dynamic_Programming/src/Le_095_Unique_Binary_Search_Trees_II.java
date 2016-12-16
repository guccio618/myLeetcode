import java.util.ArrayList;
import java.util.List;
/*******
 * 
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 * 
 * */

public class Le_095_Unique_Binary_Search_Trees_II {
	/**********************************************************
	 * BST
	 * 树的组合取决于： 左子树的组合 * 右子树的组合
	 * 	(1). 由子树递推出当前树的组合个数，考虑用DP。
	 * 	(2). 从 1 trave 到 n, 列举出分别以其作为root结点的情况。
	 * 	(3). 用Divide & Conquer (递归) 先计算左右子树的组合，
	 * 		 从而得到当前需要求的组合。 
	 *  (4). 引入记忆化搜索，去除重复计算。  
	 *      
	 **********************************************************/
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList();
        
        if(n <= 0) {
            return ans;
        }
        
        // becase the label is from 1 to n, so the lenght should be n + 1 !!!
        List<TreeNode>[][] memo = new List[n+1][n+1];  
        return search(memo, 1, n);
    }
    
    public List<TreeNode> search(List<TreeNode>[][] memo, int start, int end) {
        if(start > end) {
            List<TreeNode> list = new ArrayList();
            list.add(null);                 // this step is important !!!
            return list;
        } else if(memo[start][end] != null) {
            return memo[start][end];
        }
        
        memo[start][end] = new ArrayList();
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = search(memo, start, i-1);
            List<TreeNode> rightList = search(memo, i+1, end);
            
            for(TreeNode left : leftList) {
                for(TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    memo[start][end].add(root);
                }
            }
        }
        
        return memo[start][end];
    }
    
    
    
    /*** main function ***/
    public static void main(String[] args){
    	Le_095_Unique_Binary_Search_Trees_II t = new Le_095_Unique_Binary_Search_Trees_II();
    	t.generateTrees(3);
    }
}
