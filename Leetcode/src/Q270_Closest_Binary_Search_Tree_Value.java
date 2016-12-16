
public class Q270_Closest_Binary_Search_Tree_Value {
	// by Jackie
	public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int ans = 0;
        
        while(root != null){
            if(root.val > target){
                if(diff > Math.abs(root.val - target)){
                    diff = Math.abs(root.val - target);
                    ans = root.val;
                }
                root = root.left;
            } else if(root.val < target){
                if(diff > Math.abs(root.val - target)){
                    diff = Math.abs(root.val - target);
                    ans = root.val;
                }
                root = root.right;
            } else {
                return root.val;
            }
        }
        
        return ans;
    }
}
