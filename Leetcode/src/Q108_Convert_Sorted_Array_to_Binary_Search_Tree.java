import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/****
 * 
Given an array where elements are sorted in ascending order, 
convert it to a height balanced BST.
 * 
 * */

public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
	// using recursive
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        return buildTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

    
    
    // using iterator
	public TreeNode sortedArrayToBST_iterative(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;

		// 0 as a placeholder
		TreeNode head = new TreeNode(0);

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>() {
			{
				push(head);
			}
		};
		Deque<Integer> leftIndexStack = new LinkedList<Integer>() {
			{
				push(0);
			}
		};
		Deque<Integer> rightIndexStack = new LinkedList<Integer>() {
			{
				push(len - 1);
			}
		};

		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid = left + (right - left) / 2; // avoid overflow
			currNode.val = nums[mid];
			if (left <= mid - 1) {
				currNode.left = new TreeNode(0);
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid - 1);
			}
			if (mid + 1 <= right) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid + 1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}
}

	
