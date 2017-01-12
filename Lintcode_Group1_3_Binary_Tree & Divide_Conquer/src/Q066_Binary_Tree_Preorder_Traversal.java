import java.util.ArrayList;
import java.util.Stack;


public class Q066_Binary_Tree_Preorder_Traversal {
	// by Jackie
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        return res;
    }
}
