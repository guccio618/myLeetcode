import java.util.HashMap;
import java.util.Map;


public class Q072_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	// by Jackie
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; ++i){
            inMap.put(inorder[i], i);
        }
        return treeBuildHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inMap);
    }
    
    public TreeNode treeBuildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int numLeft = inRoot - inStart;
        
        root.left = treeBuildHelper(inorder, inStart, inRoot-1, postorder, postStart, postStart+numLeft-1, inMap);
        root.right = treeBuildHelper(inorder, inRoot+1, inEnd, postorder, postStart+numLeft, postEnd-1, inMap);
        return root;
    }
}
