import java.util.Stack;


public class Lecture3_BinaryTree_DivideConquer_07_Inorder_Successor_in_Binary_Search_Tree {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
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
}
