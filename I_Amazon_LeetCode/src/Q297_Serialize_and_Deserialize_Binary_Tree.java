import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/******
 *
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 **/

public class Q297_Serialize_and_Deserialize_Binary_Tree {
	/********************************************************************
	 * serialize:   运用层序遍历进行纪录； 并同时纪录lastPos, 纪录最后一个有效字符。
	 * deserialize： 运用ArrayList, 按顺序纪录每个结点；index纪录访问到的root结点
	 * 				 的id。
	 *      
	 ********************************************************************/
	
    public String serialize(TreeNode root) {
    	if(root == null){
            return "";
        }
    	
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        StringBuffer serial = new StringBuffer();
        int lastPos = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            if(node != null){
                serial.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
                lastPos = serial.length() - 2;
            } else {
                serial.append("#,");
            }
        }
        
        return serial.substring(0, lastPos + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.equals("")){
            return null;
        }
        
        String[] array = data.split(",");
        int n = array.length;
        
        if(array[0].equals("#")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int index = 0;
        
        for(int i = 1; i < n; ++i){
            if(!array[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(array[i]));
                
                if(i % 2 == 1){
                    list.get(index).left = node;
                } else{
                    list.get(index).right = node;
                }
                
                list.add(node);   
            }
            
            if(i % 2 == 0){
                index++;
            }
        }
        
        return root;
    }
}
