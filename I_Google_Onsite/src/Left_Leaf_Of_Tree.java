import java.util.*;
/*********
 * 
output the left node of each level, time is O(n), space is O(1)
 * 
 * */

public class Left_Leaf_Of_Tree {
	// solution 1: 
	private int maxLevel = 0;
	
	public List<TreeNode> getLeaves(TreeNode root) {
		List<TreeNode> ans = new ArrayList<>();
		
		if(root == null) {
			return ans;
		}
		
		helper(ans, root, 0);
		return ans;
	}
	
	public void helper(List<TreeNode> ans, TreeNode node, int curLevel) {
		if(node == null) {
			return;
		}
		
		if(curLevel == maxLevel) {
			ans.add(node);
			maxLevel++;
		}
		
		helper(ans, node.left, curLevel + 1);
		helper(ans, node.right, curLevel + 1);
	}
	
	
	
	// solution 2:
	public TreeNode[] getLeaves2(TreeNode root) {
		if(root == null) {
			return new TreeNode[0];
		}
		int totalLevel = getHeight(root);
		TreeNode[] ans = new TreeNode[totalLevel];	
		DFS(root, ans, 0, totalLevel);
		return ans;
	}
	
	public void DFS(TreeNode node, TreeNode[] ans, int curLevel, int totalLevel) {
		if(node == null || curLevel > totalLevel) {
			return;
		} 
		ans[curLevel] = (ans[curLevel] == null) ? node : ans[curLevel];		
		DFS(node.left, ans, curLevel + 1, totalLevel);
		DFS(node.right, ans, curLevel + 1, totalLevel);
	}
	
	public int getHeight(TreeNode node) {
		if(node == null) {
			return 0;
		}		
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*********************** main function ********************************/
	
	public static void main(String[] args) {
		Left_Leaf_Of_Tree t = new Left_Leaf_Of_Tree();
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		
//		root.right.left.left = new TreeNode(8);
//		root.right.left.left.right = new TreeNode(10);
//		
//		root.right.right.right = new TreeNode(9);
//		root.right.right.right.right = new TreeNode(11);
//		root.right.right.right.right.left = new TreeNode(12);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		
		List<TreeNode> list = t.getLeaves(root);
		TreeNode[] ans = t.getLeaves2(root);
		
		for(TreeNode elem : list) {
			System.out.print(elem.value + " ");
		}
		
		System.out.println();
		
		for(TreeNode elem : ans) {
			System.out.print(elem.value + " ");
		}
	}
	
	/*****
	 	TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
	
	   1
	  / \
	 2   3
	  \   \
	   4   5
	  /
	 6 
	  
	******/
	
}


class TreeNode {
	int value;
	TreeNode left, right;
	
	public TreeNode(int value) {
		this.value = value;
		left = right = null;
	}
}
