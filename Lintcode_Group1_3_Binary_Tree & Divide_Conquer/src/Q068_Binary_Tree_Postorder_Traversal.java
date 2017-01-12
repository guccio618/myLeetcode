import java.util.ArrayList;
import java.util.Stack;


public class Q068_Binary_Tree_Postorder_Traversal {
	// by Jackie
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }
        
        while(!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }
}
