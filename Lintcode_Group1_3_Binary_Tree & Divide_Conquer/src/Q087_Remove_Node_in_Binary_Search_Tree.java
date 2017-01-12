public class Q087_Remove_Node_in_Binary_Search_Tree {
	/**********
	 * Star
	 **********/
	// by ninechapter
	public TreeNode removeNode(TreeNode root, int value) {
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;

		TreeNode parent = findNode(dummy, root, value);
		TreeNode node;
		if (parent.left != null && parent.left.val == value) {         // node为parent的左子树时
			node = parent.left;
		} 
		else if (parent.right != null && parent.right.val == value) {  // node为parent的右子树时
			node = parent.right;
		} 
		else {
			return dummy.left;   // 找不到时
		}

		deleteNode(parent, node);

		return dummy.left;
	}

	private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
		if (node == null) {
			return parent;
		}

		if (node.val == value) {
			return parent;
		}
		if (value < node.val) {
			return findNode(node, node.left, value);
		} else {
			return findNode(node, node.right, value);
		}
	}
	
	// 从node的右子树中找一个最小的，替代node，然后删除node
	private void deleteNode(TreeNode parent, TreeNode node) {
		if (node.right == null) {
			if (parent.left == node) {
				parent.left = node.left;
			} else {
				parent.right = node.left;
			}
		} else {
			TreeNode temp = node.right;  
			TreeNode father = node;

			while (temp.left != null) {   // 找到右子树最下面的一个temp结点
				father = temp;
				temp = temp.left;
			}
										  // 防止此树为一条只有右子树的链表的情况时，需要进行判断temp是father的左右子树
			if (father.left == temp) {    // temp的左子树为null，因此不用考虑； 
				father.left = temp.right;
			} else {
				father.right = temp.right;
			}

			if (parent.left == node) {
				parent.left = temp;
			} else {
				parent.right = temp;
			}

			temp.left = node.left;
			temp.right = node.right;
		}
	}
}
