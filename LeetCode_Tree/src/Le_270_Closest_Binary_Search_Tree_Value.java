
public class Le_270_Closest_Binary_Search_Tree_Value {
	// naive method is to use inorder travel, and find the node 
	// which is most close to the target node, time is O(n).
	
	// using binary search, time is O(logn)
	public int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        }
        
        double diff = Double.MAX_VALUE;
        int ans = 0;
        
        while(root != null) {
            double currentDiff = Math.abs(root.val - target);
            
            if(currentDiff < diff) {
                diff = currentDiff;
                ans = root.val;
            }
            
            if(root.val > target) {
                root = root.left;
            } else if(root.val < target) {
                root = root.right;
            } else {
                break;
            }
        }
        
        return ans;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*****************************************************************/
	// using binary search, time is O(logn)
	public int closestValue2(TreeNode root, double target) {
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
