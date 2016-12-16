import java.util.*;
/*****
 * 
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 * 
 * */

public class Q114_Flatten_Binary_Tree_to_Linked_List {
	// solution 1: using recursive	
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
	
	
	
	// solution 2: using iterator
	public void flatten2(TreeNode root) {   
		if(root == null) {
        	return;
        }
		
        Stack<TreeNode> s = new Stack<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
    
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                q.add(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        
        root = q.poll();
        
        while(!q.isEmpty()){
            root.left = null;
            root.right = q.poll();
            root = root.right;
        }
    }
}
