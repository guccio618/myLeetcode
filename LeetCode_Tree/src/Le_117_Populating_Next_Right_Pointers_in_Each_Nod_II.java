import java.util.LinkedList;
import java.util.Queue;
/*****
 * 
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
 * 
 * */

public class Le_117_Populating_Next_Right_Pointers_in_Each_Nod_II {
	/*********************************************************************
	 * 此题为116题的follow up
	 *  (1). 不同于116的完全二叉树，此题中只有当current.left和current.right不为null时，
	 *       才进行操作   
	 *       
	 *********************************************************************/
		public void connect(TreeLinkNode root) {
	        if(root == null){
	            return;
	        }
	    
	        TreeLinkNode nextHead = null;
	        TreeLinkNode nextElement = null;
	        TreeLinkNode current = root;
	        root.next = null;
	        
	        while(current != null){
	            while(current != null){
	                if(current.left != null){
	                    if(nextElement == null){
	                        nextHead = current.left;
	                    } else {
	                        nextElement.next = current.left;
	                    } 
	                    nextElement = current.left;
	                }
	                
	                if(current.right != null){
	                    if(nextElement == null){
	                        nextHead = current.right;
	                    } else {
	                        nextElement.next = current.right;
	                    } 
	                    nextElement = current.right;
	                }
	                
	                current = current.next;
	            }
	            
	            current = nextHead;
	            nextHead = null;
	            nextElement = null;
	        }
	    }
		
		
		// by Jackie, 使用层序遍历实现，space O(n)
		public void connect2(TreeLinkNode root) {
	        if(root == null){
	            return;
	        }
	        
	        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
	        q.offer(root);
	        int size = 1;
	        
	        while(!q.isEmpty()){
	            TreeLinkNode node = q.poll();
	            if(node.left != null){
	                q.offer(node.left);
	            }
	            if(node.right != null){
	                q.offer(node.right);
	            }
	            if(--size == 0){
	                size = q.size();
	                node.next = null;
	            } else {
	                node.next = q.peek();
	            }
	        }
	    }
}
