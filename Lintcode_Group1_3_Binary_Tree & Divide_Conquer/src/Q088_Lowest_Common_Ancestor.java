
public class Q088_Lowest_Common_Ancestor {
	// by other
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) 
            return root;

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) 
            return root;   
        if (left != null && right == null) 
            return left;
        if (right != null && left == null) 
            return right;
        
        return null; 
    }
}
