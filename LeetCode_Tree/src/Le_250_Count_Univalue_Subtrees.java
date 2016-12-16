
public class Le_250_Count_Univalue_Subtrees {
	private int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        helper(root);
        return count;
    }
    
    public boolean helper(TreeNode node){
        if(node == null){
            return true;
        } 
        
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        
        if(left == true && right == true){
            if(node.left != null && node.val != node.left.val){
                return false;
            } 
            if(node.right != null && node.val != node.right.val){
                return false;
            } 
            
            count++;
            return true;
        } else {
            return false;
        }
    }
}
