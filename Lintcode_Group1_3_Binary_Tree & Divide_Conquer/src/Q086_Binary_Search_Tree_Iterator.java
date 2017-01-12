import java.util.Stack;


public class Q086_Binary_Search_Tree_Iterator {
	// by ninechapter & Jackie
	public class BSTIterator {
	    //@param root: The root of binary tree.
	    private Stack<TreeNode> s;
	    private TreeNode root;
	    
	    public BSTIterator(TreeNode root) {
	        // write your code here
	        s = new Stack<TreeNode>();
	        this.root = root;
	    }

	    //@return: True if there has next node, or false
	    public boolean hasNext() {
	        // write your code here
	        return ((root != null) || (s.size() != 0));
	    }
	    
	    //@return: return next node
	    public TreeNode next() {
	        // write your code here
	        while(root != null){
	            s.push(root);
	            root = root.left;
	        }
	        root = s.pop();
	        TreeNode node = root;  // 注意此处
	        root = root.right;     // 注意此处
	        return node;
	    }
	}
}
