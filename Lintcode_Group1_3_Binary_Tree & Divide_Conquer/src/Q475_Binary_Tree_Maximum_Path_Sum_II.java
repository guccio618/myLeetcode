
public class Q475_Binary_Tree_Maximum_Path_Sum_II {
	// by Jackie
	public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }
        return sumHelper(root);
    }
    
    public int sumHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        int maxSum = sumHelper(node.left);
        maxSum = Math.max(maxSum, sumHelper(node.right));
        return (maxSum + node.val);
    }
}
