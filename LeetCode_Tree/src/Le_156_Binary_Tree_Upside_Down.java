/*************************************************************
 * (1). 颠倒左子树的顺序
 * (2). 左子树的左孩子为右子树， 左子树的右孩子为其parent
 * 
 *************************************************************/

public class Le_156_Binary_Tree_Upside_Down {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return newRoot;
    }
}
