
public class Le_236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	/**********************************************************
	 * BT
	 * 	寻找公共祖先，找到时满足的条件应为：左子树也找到，右子树也找到，
	 * 	取决于左右子树的情况，因此考虑用Divide & Conquer
	 * 	分三种情况：
	 * 	(1). 在左，右子树上均找到，返回root，表示都找到，寻找结束。
	 * 	(2). 只在左子树中找到，返回找到的结点，回到上一层结点继续判断。
	 * 	(3). 只在右子树中找到，返回找到的结点，回到上一层结点继续判断。 
	 *      
	 **********************************************************/	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){     // 找到与p或q相等的结点，或者都没找到
            return root;
        }
        
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q); 
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
         
        if(leftTree != null && rightTree != null){         // 在左，右子树上均找到，返回root，表示都找到，寻找结束 
            return root;
        } else if(leftTree == null && rightTree != null){  // 只在左子树中找到，返回找到的结点，回到上一层结点继续判断
            return rightTree;
        } else if(leftTree != null && rightTree == null){  // 只在右子树中找到，返回找到的结点，回到上一层结点继续判断
            return leftTree;
        }
        
        return null;
    }
}
