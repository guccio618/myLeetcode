import java.util.Stack;


public class Le_285_Inorder_Successor_in_BST {
	// by other, faster, for Successor
		public TreeNode successor(TreeNode root, TreeNode p) {
			if (root == null)
				return null;

			if (root.val <= p.val) {
				return successor(root.right, p);
			} else {
				TreeNode left = successor(root.left, p);
				return (left != null) ? left : root;
			}
		}

		// Predecessor
		public TreeNode predecessor(TreeNode root, TreeNode p) {
			if (root == null)
				return null;

			if (root.val >= p.val) {
				return predecessor(root.left, p);
			} else {
				TreeNode right = predecessor(root.right, p);
				return (right != null) ? right : root;
			}
		}

		// by Jackie
		public TreeNode successor2(TreeNode root, TreeNode p) {
			if (root == null || p == null) {
				return p;
			}

			boolean isFound = false;
			Stack<TreeNode> stack = new Stack<TreeNode>();

			while (!stack.isEmpty() || root != null) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();

				if (isFound == true) {
					return root;
				}
				if (p == root) {
					isFound = true;
				}

				root = root.right;
			}

			return null;
		}
}
