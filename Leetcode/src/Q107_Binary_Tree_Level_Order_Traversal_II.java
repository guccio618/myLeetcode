import java.util.*;

/*******
 * 
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 * 
 * */

public class Q107_Binary_Tree_Level_Order_Traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) { 
		List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            
            if(node.left != null) {
                queue.offer(node.left);
            } 
            
            if(node.right != null) {
                queue.offer(node.right);
            }
            
            if(--size == 0) {
                size = queue.size();
                ans.add(0, new ArrayList<Integer>(list));
                list.clear();
            }
        }
        
        return ans;
    }
}
