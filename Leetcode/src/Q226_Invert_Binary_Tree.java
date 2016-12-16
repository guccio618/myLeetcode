import java.util.LinkedList;
import java.util.Queue;


public class Q226_Invert_Binary_Tree {
	public TreeNode invertTree(TreeNode root) {  //by jackie
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 1;
        TreeNode temp;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(--count == 0) {count = queue.size();}
        }
        return root;
    }
	
	public TreeNode invertTree_recursive(TreeNode root) {  //by jackie using recursive
        if(root == null) return root;
        if(root.left != null) root.left = invertTree_recursive(root.left);
        if(root.right != null) root.right = invertTree_recursive(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
