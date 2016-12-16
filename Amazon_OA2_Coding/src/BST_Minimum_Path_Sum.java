public class BST_Minimum_Path_Sum {
	public int Solution(TreeNode root) {
		if (root == null){
			return 0;
		} else if (root.left != null && root.right == null){
			return Solution(root.left) + root.value;
		} else if (root.left == null && root.right != null){
			return Solution(root.right) + root.value;
		}
		
		return Math.min(Solution(root.left), Solution(root.right)) + root.value;
	}
}
