import java.util.ArrayList;
import java.util.Stack;


public class Q011_Search_Range_in_Binary_Search_Tree {
	// by Jackie
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res, k1, k2);
        return res;
    }
    
    public void helper(TreeNode node, ArrayList<Integer> res, int k1, int k2){
        if(node == null){
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(node != null || !s.isEmpty()){
            while(node != null){
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if(node.val >= k1 && node.val <= k2){
                res.add(node.val);
            }
            else if(node.val > k2){
                return;
            }
            node = node.right;
        }
    }
}
