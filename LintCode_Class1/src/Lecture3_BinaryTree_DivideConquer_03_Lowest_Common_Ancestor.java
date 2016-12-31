
public class Lecture3_BinaryTree_DivideConquer_03_Lowest_Common_Ancestor {
	/********************************************
	 * Divide and Conquer
	 *		在root为根的二叉树中找A,B的LCA
	 *			(1). 如果找到了就返回这个LCA
     *			(2). 如果只碰到A，就返回A
     *          (3). 如果只碰到B，就返回B
     *          (4). 如果都没有，就返回null
	 * 
	 ********************************************/
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        
        // Conquer
        if (left != null && right != null) {   // 左右都找到了，返回root即为公共祖先
            return root;
        } 
        if (left != null) {                    // 只找到左边，此时返回left
            return left;
        }
        if (right != null) {                   // 只找到右边，此时返回right
            return right;
        }
        return null;
    }
}
