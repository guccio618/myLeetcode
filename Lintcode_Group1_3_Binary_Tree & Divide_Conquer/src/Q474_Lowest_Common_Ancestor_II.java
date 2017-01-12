public class Q474_Lowest_Common_Ancestor_II {
	// by Jackie
	public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode A, TreeNode B) {
		// Write your code here
		if (root == null || A == root || B == root) {
			return root;
		}

		TreeNode left = lowestCommonAncestorII(root.left, A, B);
		TreeNode right = lowestCommonAncestorII(root.right, A, B);

		if (left != null && right != null) {
			return root;
		} else if (left != null && right == null) {
			return left;
		} else if (left == null && right != null) {
			return right;
		}
		return null;
	}
}
