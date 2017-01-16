/*******
 * 
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
    
 * 
 * */

public class Le_450_Delete_Node_in_a_BST {
	// time is O(logn)
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findParenForDeleteNode(dummy, root, key);
        TreeNode deleteNode = null;
        
        if(parent.left != null && parent.left.val == key) {
            deleteNode = parent.left;
        } else if(parent.right != null && parent.right.val == key) {
            deleteNode = parent.right;
        } else {
            return dummy.left;
        }
        
        deleteNode(parent, deleteNode);
        return dummy.left;
    }
    
	// time is O(logn)
    public TreeNode findParenForDeleteNode(TreeNode parent, TreeNode node, int key) {
        if(node == null || node.val == key) {
            return parent;
        }
        
        if(key < node.val) {
            return findParenForDeleteNode(node, node.left, key);
        } else {
            return findParenForDeleteNode(node, node.right, key);
        }
    }
    
    // time is O(logn)
    public void deleteNode(TreeNode parent, TreeNode node) {
        if(node.right == null) {  
            if(parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if(node.left == null) {
            if(parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else {
            TreeNode father = node;
            TreeNode current = node.right;
            
            while(current.left != null) {
                father = current;
                current = current.left;
            }
            
            if(father.left == current) {
                father.left = current.right;
            } else {
                father.right = current.right;
            }
            
            if(parent.left == node) {
                parent.left = current;
            } else {
                parent.right = current;
            }
            
            current.left = node.left;
            current.right = node.right;
        }
    }
}
