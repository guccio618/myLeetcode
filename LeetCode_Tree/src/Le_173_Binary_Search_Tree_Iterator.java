import java.util.Stack;


public class Le_173_Binary_Search_Tree_Iterator {
	/*****************************************************
	 * 此题可以看作为前序遍历的拆分版： next()每次返回当前最小的值，
	 * 							 即最左边的叶子结点
	 *      
	 *****************************************************/
	
	private Stack<TreeNode> stack;
	private TreeNode root;

	public Le_173_Binary_Search_Tree_Iterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		this.root = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return (root != null || !stack.isEmpty());
	}

	/** @return the next smallest number */
	public int next() {
		if (hasNext() == false) {
			return -1;
		}
		
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		root = stack.pop();
		int ans = root.val;
		root = root.right;
		return ans;
	}
}
