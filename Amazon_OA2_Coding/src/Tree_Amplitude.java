
public class Tree_Amplitude {
//	public int treeAmplitude(TreeNode root) {
//		if(root == null){
//			return 0;
//		}
//		
//		return helper(root, root.value, root.value);
//	}
//	
//	public int helper(TreeNode node, int min, int max){
//		if(node == null){
//			return max - min;
//		}
//		
//		min = Math.min(min, node.value);
//		max = Math.max(max, node.value);
//		
//		return Math.max(helper(node.left, min, max), helper(node.right, min, max));
//	}
	
	
	public static int treeAmplitude(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		int[] ans = new int[] {root.value, root.value};
		helper(root, ans);
		return ans[0] - ans[1];
	}
	
	public static void helper(TreeNode node, int[] ans){
		if(node == null){
			return ;
		}
		
		ans[0] = Math.max(ans[0], node.value);
		ans[1] = Math.min(ans[1], node.value);
		helper(node.left, ans);
		helper(node.right, ans);
	}
	
	
	
	
	
	public static int treeAmplitude_path(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int[] recorder = {0, 0};
		DFS(root, 0, recorder);
		return recorder[0] - recorder[1];
	}
	
	public static void DFS(TreeNode node, int path, int[] recorder) {
		if(node == null) {
			return;
		} else if(node.left == null && node.right == null) {
			path += node.value;
			recorder[0] = Math.max(recorder[0], path);
			recorder[1] = Math.min(recorder[1], path);
			return;
		}
		
		path += node.value;
		DFS(node.left, path, recorder);
		DFS(node.left, path, recorder);
	}
	
	
	
	
	/******************** main function ***********************/
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		System.out.println(treeAmplitude(root));
		System.out.println(treeAmplitude_path(root));
	}
}
