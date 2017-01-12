import java.util.Stack;

public class Q126_Max_Tree {
	public TreeNode maxTree(int[] nums) {
		/*************************************************/
		// by ninechapter using stack
		if (nums == null || nums.length == 0) {
			return null;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();

		for (int i = 0; i <= nums.length; ++i) {
			TreeNode right = (i == nums.length) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(nums[i]);
			while (!s.isEmpty()) {
				if (right.val > s.peek().val) {
					TreeNode currentNode = s.pop();
					if (s.isEmpty()) {
						right.left = currentNode;
					} else {
						TreeNode left = s.peek();
						if (left.val > right.val) {
							right.left = currentNode;
						} else {
							left.right = currentNode;
						}
					}
				} else {
					break;
				}
			}
			s.push(right);
		}
		return (s.peek().left);
	}
	
	
	

	/*************************************************/
	// by Jackie but exceed time limit
	public TreeNode maxTree2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int start, int end) {
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		int maxValue = nums[start];
		int rootIndex = start;
		for (int i = start + 1; i <= end; ++i) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				rootIndex = i;
			}
		}
		TreeNode node = new TreeNode(maxValue);
		if (rootIndex > start) {
			node.left = helper(nums, start, rootIndex - 1);
		}
		if (rootIndex < end) {
			node.right = helper(nums, rootIndex + 1, end);
		}
		return node;
	}
}
