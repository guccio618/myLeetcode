import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;


public class Q144_Binary_Tree_Preorder_Traversal {
	//stack
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while(root != null || !s.isEmpty()){
            while(root != null){
                res.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        return res;
    }
	
	//recursive
	public ArrayList<Integer> preorderTraversal_recursive(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();   //必须要使用一个temp来接受传递出来的值
        
        if(root != null){
            res.add(root.val);
            temp = preorderTraversal_recursive(root.left);
            for(int i = 0; i < temp.size(); i++)
                res.add(temp.get(i));
            temp.clear();
            temp = preorderTraversal_recursive(root.right);
            for(int i = 0; i < temp.size(); i++)
                res.add(temp.get(i));
            temp.clear();
        }
        return res;
    }
}


//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}
