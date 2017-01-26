
public class Other_Second_Min_Tournament {
	public static int secMin(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
        	return -1;
        }
        
        int left = -1, right = -1;
        
        if(root.left == null) {
        	left = -1;
        } else if(root.left.val == root.val) {
            left = secMin(root.left);
        } else {
            left = root.left.val;
        }
        
        if(root.right == null) {
        	right = -1;
        } else if (root.right.val == root.val) {
            right = secMin(root.right);
        } else {
        	right = root.right.val;
        }
        
        if (left == -1 || right == -1) {
        	return left == -1 ? right : left;
        }
        
        return Math.min(left, right);
	}
}
