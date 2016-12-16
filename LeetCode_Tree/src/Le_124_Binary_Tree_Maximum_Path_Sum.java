/*****
 * 
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

 * 
 * */

public class Le_124_Binary_Tree_Maximum_Path_Sum {
	/**************************************************
	 * 测试数据： [2, -1], 答案为2
	 * 
	 **************************************************/
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
        
        int leftPath = maxPathHelper(node.left);
        int rightPath = maxPathHelper(node.right);
        int currentPath = Math.max(0, Math.max(leftPath, rightPath)) + node.val;
        maxPath = Math.max(maxPath, Math.max(currentPath, leftPath + rightPath + node.val));
        return currentPath;
    }
	
	
    
    
    
    
    /***********************************************/
	//by ninechapter
	public int maxPathSum2(TreeNode root) {
        resultTuple res = getResult(root);
        return res.maxPath;
    }
    
    public resultTuple getResult(TreeNode root){
        if(root == null)
            return new resultTuple(0, Integer.MIN_VALUE);
            
        resultTuple left = getResult(root.left);
        resultTuple right = getResult(root.right);
        
        int maxSinglePath = Math.max(left.maxSinglePath, right.maxSinglePath) + root.val;
        maxSinglePath = Math.max(maxSinglePath , 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.maxSinglePath + right.maxSinglePath + root.val);
        return new resultTuple(maxSinglePath, maxPath);        
    }
    
    class resultTuple{
        private int maxPath;
        private int maxSinglePath;
            
        public resultTuple(int s, int p){
            maxSinglePath = s;
            maxPath = p;
        }
    }
    
    
    public static void main(String[] args){
    	Le_124_Binary_Tree_Maximum_Path_Sum t = new Le_124_Binary_Tree_Maximum_Path_Sum();
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(-1);
    	root.right = new TreeNode(-2);
    	System.out.println(t.maxPathSum(root));
    }
}
