
public class Q085_Insert_Node_in_a_Binary_Search_Tree {
	// by Jackie
	public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            return node;
        }
        if(node == null){
            return root;
        }
        
        TreeNode tempRoot = root;
        while(tempRoot != null){
            if(tempRoot.val < node.val){
                if(tempRoot.right != null){
                    tempRoot = tempRoot.right;
                }
                else{
                    tempRoot.right = node;
                    break;
                }
            } 
            else if(tempRoot.val > node.val){
                if(tempRoot.left != null){
                    tempRoot = tempRoot.left;
                }
                else{
                    tempRoot.left = node;
                    break;
                }
            }
        }
        return root;
    }
}
