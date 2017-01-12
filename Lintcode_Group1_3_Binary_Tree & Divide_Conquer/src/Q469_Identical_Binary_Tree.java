
public class Q469_Identical_Binary_Tree {
	// by Jackie
	public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null){
            return true;
        }
        if((a == null && b != null) || (a != null && b == null) || (a.val != b.val)){
            return false;
        }
        return (isIdentical(a.left, b.left) && isIdentical(a.right, b.right));
    }
}
