import java.util.*;

/******
 * 
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

 * 
 * */

public class Le_199_Binary_Tree_Right_Side_View {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
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
                ans.add(node.val);
            }
        }
        
        return ans;
    }
}
