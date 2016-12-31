
public class Lecture3_BinaryTree_DivideConquer_01_Maximum_Depth_of_Binary_Tree {
	public int maxDepth(TreeNode root) {
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
