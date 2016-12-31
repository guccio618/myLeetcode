
public class Q270_Closest_Binary_Search_Tree_Value {
	// using binary search, time is O(logn)
	public int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        }
        
        double diff = Double.MAX_VALUE;
        int ans = 0;
        
        while(root != null) {
            double currentDiff = Math.abs(root.value - target);
            
            if(currentDiff < diff) {
                diff = currentDiff;
                ans = root.value;
            }
            
            if(root.value > target) {
                root = root.left;
            } else if(root.value < target) {
                root = root.right;
            } else {
                break;
            }
        }
        
        return ans;
    }
}
