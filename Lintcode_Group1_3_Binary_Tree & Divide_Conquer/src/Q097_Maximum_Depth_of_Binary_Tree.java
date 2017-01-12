
public class Q097_Maximum_Depth_of_Binary_Tree {
	// by Jackie using Divide & Conquer
	public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        return helper(root);
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int max = helper(node.left);
        max = Math.max(max, helper(node.right));
        return (max + 1);
    }
}
