
public class Subtree_Check {
	/*****
	 * T2是不是T1的子树
	 * 
	 * */
	
	public boolean isSubTree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
        	return true;
        } else if (T1 == null) {
        	return false;
        }
        
        return (isSameTree(T1, T2) || isSubTree(T1.left, T2) || isSubTree(T1.right, T2));
    }
	
    public boolean isSameTree(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        } else if (T1 == null || T2 == null) {
            return false;
        } else if (T1.value != T2.value) {
            return false;
        }
        
        return (isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right));
    }
}
