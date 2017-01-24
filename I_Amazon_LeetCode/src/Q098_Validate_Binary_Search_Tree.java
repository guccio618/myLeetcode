import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*****
 * 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

 * 
 * */

public class Q098_Validate_Binary_Search_Tree {
	/*************************************************
	 * test case: [0]
	 * test case: [Integer.MIN_VALUE]
	 *************************************************/

	// solution 1: using recursive
	public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isValid(Long.MAX_VALUE, Long.MIN_VALUE, root);
    }
    
    public boolean isValid(long max, long min, TreeNode node) {
        if(node == null) {
            return true; 
        } else if(node.val >= max || node.val <= min) {
            return false;
        }
        
        return isValid(node.val, min, node.left) && isValid(max, node.val, node.right);
    }
	
    
	
	// solution 2: using stack, in order travel
    public boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack();
        Integer prevValue = null;
        
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(prevValue != null && root.val <= prevValue) {
                return false;
            } 
            
            prevValue = root.val;
            root = root.right;
        }
        
        return true;
    }
	
    
    
    
    
    /************************************************/
	// by other
	public boolean isValidBST_3(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}

	private boolean isValidBSTHelper(TreeNode root, Integer leftBound,
			Integer rightBound) {
		// recursively pass left and right bounds from higher level to lower
		// level
		if (root == null) {
			return true;
		}
		if (leftBound != null && root.val <= leftBound || rightBound != null
				&& root.val >= rightBound) {
			return false;
		}
		return isValidBSTHelper(root.left, leftBound, root.val)
				&& isValidBSTHelper(root.right, root.val, rightBound);
	}
	
	public static void main(String[] args){
		Q098_Validate_Binary_Search_Tree t = new Q098_Validate_Binary_Search_Tree();
		TreeNode root = new TreeNode(-2147483648);
		root.left = null;
		root.right = new TreeNode(-2147483648);
		System.out.println(t.isValidBST(root)); //[-2147483648,-2147483648]
	}
}
