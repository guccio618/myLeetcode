
public class Q094_Binary_Tree_Maximum_Path_Sum {
	// by ninechapter && Jackie
	private int maxPath = Integer.MIN_VALUE; 
    
    public int maxPathSum(TreeNode root) {
        // write your code here
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
        int leftPath = maxPathHelper(node.left);
        int rightPath = maxPathHelper(node.right);
        maxPath = Math.max(maxPath, leftPath + node.val + rightPath);  // 求出当前的最大值
        return Math.max(0, Math.max(leftPath, rightPath) + node.val);  // 路径为负数，则表示为0，丢弃不取，然后把值返回给parent
    }
    
    
    /*************************************************************************/
    // by ninechapter
    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath; 
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val; // 用于给parent用
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum2(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
    
    public static void main(String[] args){
    	Q094_Binary_Tree_Maximum_Path_Sum t = new Q094_Binary_Tree_Maximum_Path_Sum();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(-5);
    	root.right = new TreeNode(-6);
    	System.out.println(t.maxPathSum(root));
    }
}
