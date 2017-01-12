import java.util.Stack;

public class Q448_Inorder_Successor_in_Binary_Search_Tree {
	// by Jackie
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null || p == null){
            return p;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        boolean flag = false;
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(flag == true){
                return root;
            }
            if(root == p){
                flag = true;
            }
            root = root.right;
        }
        return null;
    }
	
	
	public static void main(String[] args){
		Q448_Inorder_Successor_in_Binary_Search_Tree t = new Q448_Inorder_Successor_in_Binary_Search_Tree();
		
	}
}
