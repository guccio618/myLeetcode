import java.util.*;
/****
 * 
101. Symmetric Tree   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 143204
Total Submissions: 391666
Difficulty: Easy
Contributors: Admin
Given a binary tree, check whether it is a mirror of itself 
(ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

 * 
 * */


public class Q101_Symmetric_Tree {
	// test case:
    // 		root == null
    
	// solution 1: using recursion
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if(n1 == null || n2 == null) {
            if(n1 == null && n2 == null) {
                return true;
            } else {
                return false;
            }
        } else if(n1.val != n2.val) {
            return false;
        }
        
        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
	
    
    
	// using iterator
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(queue.size() > 1) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            
            if(node1 == null && node2 == null) {
                continue;
            } else if(node1 == null || node2 == null) {
                return false;
            } else if(node1.val != node2.val) {
                return false;
            }
            
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        
        return true;
    }
    
  
    
    
    // follow up 1: get a mirror of a tree, recursive
    public TreeNode getMirror(TreeNode root) {
    	if(root == null) {
    		return root;
    	}
    	
    	TreeNode left = getMirror(root.left);
    	TreeNode right = getMirror(root.right);
    	root.left = right;
    	root.right = left;
    	return root;
    }
    
    
    
    // follow up 2: get a mirror of a tree, recursive
    public TreeNode getMirror2(TreeNode root) {
    	if(root == null) {
    		return root;
    	}
    	
    	Queue<TreeNode> queue1 = new LinkedList<>();
    	Queue<TreeNode> queue2 = new LinkedList<>();
    	TreeNode copyRoot = new TreeNode(root.val);
    	queue1.offer(root);
    	queue2.offer(copyRoot);
    	
    	while(!queue1.isEmpty() && !queue2.isEmpty()) {
    		TreeNode node1 = queue1.poll();
    		TreeNode node2 = queue2.poll();
    		
    		if(node1.left != null) {
    			TreeNode newRight = new TreeNode(node1.left.val);
    			node2.right = newRight;
    			queue1.offer(node1.left);
    			queue2.offer(node2.right);
    		}
    		
    		if(node1.right != null) {
    			TreeNode newLeft = new TreeNode(node1.right.val);
    			node2.left = newLeft;
    			queue1.offer(node1.right);
    			queue2.offer(node2.left);
    		}
    	}
    	
    	return copyRoot;
    }
    
    
    
    
    /********************************************************/
    public void DFS(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	while(!stack.isEmpty() || root != null) {
    		while(root != null) {
    			System.out.print(root.val + " ");
    			stack.push(root);
    			root = root.left;
    		}
    		
    		root = stack.pop();
    		root = root.right;
    	}
    	
    	System.out.println();
    }
    
    public void BFS(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int size = 1;
    	
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		System.out.print(node.val + " ");
    		
    		if(node.left != null) {
    			queue.offer(node.left);
    		}
    		
    		if(node.right != null) {
    			queue.offer(node.right);
    		}
    		
    		if(--size == 0) {
    			size = queue.size();
    			System.out.println();
    		}
    	}
    }
    
    
    public static void main(String[] args) {
    	Q101_Symmetric_Tree t = new Q101_Symmetric_Tree();
    	
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(3);
    	root.left.left = new TreeNode(2);
    	root.left.right = new TreeNode(4);
    	
    	root.right = new TreeNode(7);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(8);
    	
//    	t.BFS(root);
//    	root = t.getMirror(root);
//    	t.BFS(root);
    	
//    	System.out.println();
    	
//    	t.BFS(root);
    	root = t.getMirror2(root);
    	t.BFS(root);
    }
    

}
