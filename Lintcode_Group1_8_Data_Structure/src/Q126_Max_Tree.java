import java.util.Stack;

public class Q126_Max_Tree {
	/**************
	 * Star
	 **************/
	// by ninechapter
	
	public static TreeNode maxTree(int[] nums) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		
		for (int i = 0; i <= nums.length; i++) {
			TreeNode right = (i == nums.length) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(nums[i]);
			while (!stack.isEmpty()) {
				if (right.val > stack.peek().val) {
					TreeNode nodeNow = stack.pop();
					if (stack.isEmpty()) {
						right.left = nodeNow;
					} else {
						TreeNode left = stack.peek();
						if (left.val > right.val) {
							right.left = nodeNow;
						} else {
							left.right = nodeNow;
						}
					}
				} else {
					break;
				}
			}
			stack.push(right);
		}
		return stack.peek().left;
	}
	
	
	
	/******************************************************/
	// by Jackie but will cause the stack overflow
	public TreeNode maxTree2(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int start, int end){
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int maxValue = nums[start];
        int rootIndex = start;
        for(int i = start + 1; i <= end; ++i){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                rootIndex = i;
            }
        }
        
        TreeNode node = new TreeNode(maxValue);
        if(rootIndex > start){
            node.left = helper(nums, start, rootIndex - 1);
        }
        if(rootIndex < end){
            node.right = helper(nums, rootIndex + 1, end);
        }
        return node;
    }
    
    
    
    public static void main(String[] args){
    	Q126_Max_Tree t = new Q126_Max_Tree();
    	int[] nums = {2, 5, 6, 0, 3, 1};
    	t.maxTree(nums);
    }
    
}
