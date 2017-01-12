import java.util.HashMap;
import java.util.Map;


public class Q073_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	// by Jackie
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || preorder.length ==0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < preorder.length; ++i){
            inMap.put(inorder[i], i);
        }
        return treeBulidHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    
    public TreeNode treeBulidHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numLeft = inRoot - inStart;
        
        root.left = treeBulidHelper(preorder, preStart+1, preStart+numLeft, inorder, inStart, inRoot-1, inMap);
        root.right = treeBulidHelper(preorder, preStart+numLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        return root;
    }
}
