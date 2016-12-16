import java.util.*;

/********
 * 
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 * 
 * */

public class Q449_Serialize_and_Deserialize_BST {
	// solution 1: this method will also work for BT, time is O(nlogn)
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                builder.append(root.val).append(",");
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            root = root.right;
        }
        
        return builder.substring(0, builder.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        
        if(strs.length == 0 || strs[0].equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        
        for(int i = 1; i < strs.length; i++) {
            insertToBST(root, strs[i]);
        }
        
        return root;
    }
    
    public void insertToBST(TreeNode node, String str) {
        int num = Integer.parseInt(str);
        
        while(node != null) {
            if(node.val > num) {
                if(node.left == null) {
                    node.left = new TreeNode(num);
                    return;
                } 
                node = node.left;
            } else if(node.val < num) {
                if(node.right == null) {
                    node.right = new TreeNode(num);
                    return;
                } 
                node = node.right;
            } else {
                return;
            }
        }
    }
    
    
	
	
	
	// solution 2: this method will also work for BT, time is O(n) + O(n^2)
	// Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int lastPos = 0;
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
                
            if(node != null) {
                builder.append(node.val).append(",");
                lastPos = builder.length() - 1;
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                builder.append("#,");
            }
        }
        
        return builder.substring(0, lastPos);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        
        String[] strs = data.split(",");
        
        if(strs.length == 0 || strs[0].equals("#")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int index = 0;
        
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(strs[i]));
                list.add(node);
                
                if(i % 2 != 0) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
            }
            
            if(i % 2 == 0) {
                index++;
            }
        }
        
        return root;
    }
}
