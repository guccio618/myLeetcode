import java.util.LinkedList;
import java.util.Queue;
/******
 * 
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along 
the longest path from the root node down to the farthest leaf node.

 * 
 * */

public class Q104_Maximum_Depth_of_Binary_Tree {
	// solution 1: using recursive
	public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
	

	
	// solution 2: using iterator method
	public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int size = 1;
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if(node.left != null) {
                queue.offer(node.left);
            }
            
            if(node.right != null) {
                queue.offer(node.right);
            }
            
            if(--size == 0) {
                size = queue.size();
                level++;
            }
        }
        
        return level;
    }
}
