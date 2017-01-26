import java.util.Stack;
/*********
 * 
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Note: If the given node has no in-order successor in the tree, return null.

 * 
 * */

public class Q285_Inorder_Successor_in_BST {
	// solution 1: using recursive
	public TreeNode successor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		if (root.val <= p.val) {
			return successor(root.right, p);
		} else {
			TreeNode left = successor(root.left, p);
			return (left != null) ? left : root;
		}
	}

	// Predecessor, using recursive
	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		if (root.val >= p.val) {
			return predecessor(root.left, p);
		} else {
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right : root;
		}
	}

	
	
	// solution 2: using iterator
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
