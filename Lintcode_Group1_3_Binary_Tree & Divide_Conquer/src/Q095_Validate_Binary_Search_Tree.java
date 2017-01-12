import java.util.Stack;


public class Q095_Validate_Binary_Search_Tree {
	// by Jackie
	public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        int preVal = root.val;
        boolean start = true;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(root.val <= preVal && start == false){
                return false;
            }
            start = false;
            preVal = root.val;
            root = root.right;
        }
        return true;
    }
}
