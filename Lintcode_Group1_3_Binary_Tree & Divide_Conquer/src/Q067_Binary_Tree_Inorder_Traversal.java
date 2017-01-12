import java.util.ArrayList;
import java.util.Stack;


public class Q067_Binary_Tree_Inorder_Traversal {
	// by Jackie
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
