import java.util.HashMap;
import java.util.Map;
/*****
 * 
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
	You may assume that duplicates do not exist in the tree.
 * 
 * */

public class Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.length; ++i)
            inMap.put(inorder[i], i);
            
        TreeNode root = buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd || posStart > posEnd || posEnd < 0) {
        	return null;
        }
        // root表示当前子树的根结点
        TreeNode root = new TreeNode(postorder[posEnd]);  // 注意此时用posEnd，不同于105的preStart；中序和后序的区别在于后序的最后一个
        int inRoot = inMap.get(root.val);
        int inNum = inRoot - inStart;
        
        root.left = buildTree(inorder, inStart, inRoot-1, postorder, posStart, posStart+inNum-1, inMap);
        root.right = buildTree(inorder, inRoot+1, inEnd, postorder, posStart+inNum, posEnd-1, inMap);  // 需要注意顺序
        return root;
    }
    
    public static void main(String[] args){
    	Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal t = new Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
    	int[] inorder = {1,2,3,4,5};
    	int[] postorder = {2,3,1,5,4};
    	
    	TreeNode root = t.buildTree(inorder, postorder);   	
    }
}
