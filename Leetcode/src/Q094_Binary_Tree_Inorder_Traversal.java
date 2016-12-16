import java.util.ArrayList;
import java.util.Stack;


public class Q094_Binary_Tree_Inorder_Traversal {
	//stack
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
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
	
	//recursive
	public ArrayList<Integer> inorderTraversal_recursive(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();   //必须要使用一个temp来接受传递出来的值
        
        if(root != null){          
            temp = inorderTraversal_recursive(root.left);
            for(int i = 0; i < temp.size(); i++)
                res.add(temp.get(i));
            temp.clear();
            res.add(root.val);
            temp = inorderTraversal_recursive(root.right);
            for(int i = 0; i < temp.size(); i++)
                res.add(temp.get(i));
            temp.clear();
        }
        return res;
    }
}
