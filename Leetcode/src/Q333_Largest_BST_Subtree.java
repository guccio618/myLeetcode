/**********************************************************************************
 * BST递归遍历判断子树是否是合格的BST, 需要设置当前最大和最小值的范围，如果超过，则非法，否则合法
 * 
 **********************************************************************************/

public class Q333_Largest_BST_Subtree {
	// esay unstand
		public int largestBSTSubtree(TreeNode root) {
	        if(root == null){
	            return 0;
	        } 
	        
	        if(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == true){
	            return getNum(root);                                                           // 这里用的是getNum !!!
	        } else {
	            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));  // 注意这里用的是largestBSTSubtree !!!
	        }
	    }
	    
	    public boolean isValid(TreeNode node, int min, int max){
	        if(node == null){
	            return true;
	        }
	        if(node.val > max || node.val < min){
	            return false;
	        }
	        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
	    }
	    
	    public int getNum(TreeNode node){
	        if(node == null){
	            return 0;
	        } 
	        return getNum(node.left) + getNum(node.right) + 1;
	    }
	    
	    
	      
	    /***********************************************************/
	    // a little bit faster
	    public int largestBSTSubtree2(TreeNode root) {
	        if(root == null){
	            return 0;
	        } 
	        
	        int num = isValid2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	        
	        if(num >= 0){
	            return num;
	        } else {
	            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
	        }
	    }
	    
	    public int isValid2(TreeNode node, int min, int max){
	        if(node == null){
	            return 0;
	        }
	        if(node.val > max || node.val < min){
	            return -1;
	        }
	        
	        int leftNum = isValid2(node.left, min, node.val);
	        int rightNum = isValid2(node.right, node.val, max);
	        
	        if(leftNum < 0 || rightNum < 0){
	            return -1;
	        } else {
	            return leftNum + rightNum + 1;
	        }
	    }
}
