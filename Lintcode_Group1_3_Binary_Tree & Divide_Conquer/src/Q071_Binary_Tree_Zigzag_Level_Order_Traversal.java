import java.util.ArrayList;
import java.util.Stack;


public class Q071_Binary_Tree_Zigzag_Level_Order_Traversal {
	// by Jackie
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    list.add(node.val);
                    if(node.left != null){
                        s2.push(node.left);
                    }
                    if(node.right != null){
                        s2.push(node.right);
                    }
                }
                res.add(new ArrayList<Integer>(list));
                list.clear();
            }
            else{
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    list.add(node.val);
                    if(node.right != null){
                        s1.push(node.right);
                    }
                    if(node.left != null){
                        s1.push(node.left);
                    }
                }
                res.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return res;
    }
}
