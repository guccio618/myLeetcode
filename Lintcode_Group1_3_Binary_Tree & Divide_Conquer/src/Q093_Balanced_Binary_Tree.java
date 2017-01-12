
public class Q093_Balanced_Binary_Tree {
	// by Jackie
	public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        return (helper(root) != -1);
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);
        if(leftDepth == -1 || rightDepth == -1){
            return -1;
        }
        if(Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }
        int depth = Math.max(leftDepth, rightDepth);
        return depth + 1;
    }
}
