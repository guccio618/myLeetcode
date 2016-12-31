
public class Lecture3_BinaryTree_DivideConquer_04_Binary_Tree_Maximum_Path_Sum {
	private int maxPath = Integer.MIN_VALUE; 
    
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxPathHelper(root);
        return maxPath;
    }
    
    public int maxPathHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftPath = maxPathHelper(node.left);     // 左子树到叶节点的最长路径
        int rightPath = maxPathHelper(node.right);   // 右子树到叶节点的最长路径
        maxPath = Math.max(maxPath, leftPath + node.val + rightPath);   // 加上左右子树时的最长路径
        return Math.max(0, Math.max(leftPath, rightPath) + node.val);   // 返回的是当前节点下到叶节点的最长路径
    }
}
