import java.util.Stack;


public class Lecture9_Graph_Search_01_Binary_Search_Tree_Iterator {
	private Stack<TreeNode> s;
    private TreeNode root;
    
    public Lecture9_Graph_Search_01_Binary_Search_Tree_Iterator(TreeNode root) {
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
        TreeNode node = root;
        root = root.right;
        return node;
    }
}
