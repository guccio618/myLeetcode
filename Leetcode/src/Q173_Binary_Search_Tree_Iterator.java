import java.util.Stack; 


public class Q173_Binary_Search_Tree_Iterator {
	private Stack<TreeNode> s;
    private TreeNode root;
    
    public Q173_Binary_Search_Tree_Iterator(TreeNode root) {
        s = new Stack<TreeNode>();
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ( (root != null) || (s.size() != 0) );
    }

    /** @return the next smallest number */
    public int next() {
        while(root != null){
            s.push(root);
            root = root.left;
        }
        root = s.pop();
        int val = root.val;
        root = root.right;
        return val;
    }
}
