
public class Q470_Tweaked_Identical_Binary_Tree {
	// by Jackie
	public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null){
            return true;
        }
        if((a == null && b != null) || (a != null && b == null) || (a.val != b.val)){
            return false;
        }
        boolean res1 = isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right);
        boolean res2 = isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left);
        return (res1 || res2);
    }
}
