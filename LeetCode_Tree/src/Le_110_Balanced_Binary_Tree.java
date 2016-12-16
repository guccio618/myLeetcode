/*****
 * 
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
of the two subtrees of every node never differ by more than 1.

 * 
 * */

public class Le_110_Balanced_Binary_Tree {
	public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return (pathHelper(root) != -1);
    }
    
    public int pathHelper(TreeNode node){
    	if(node == null){
            return 0;
        }
        
        int left = pathHelper(node.left);
        int right = pathHelper(node.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){  
            return -1;
        } else {
            return Math.max(left, right) + 1; 
        }
    }
}
