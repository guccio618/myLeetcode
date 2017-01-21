import org.w3c.dom.ls.LSException;

public class Q16_1_Longest_Consecutive_Subsequence_Array {
	public int getLongestConsecutiveSubsequenceInArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int positiveCount = 1, negativeCount = 1;
		int maxLen = 1;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i - 1] + 1) {
				positiveCount++;
				negativeCount = 1;
			} else if(nums[i] == nums[i - 1] - 1) {
				positiveCount = 1;
				negativeCount++;
			} else {
				positiveCount = negativeCount = 1;
			}
			
			maxLen = Math.max(maxLen, Math.max(positiveCount, negativeCount));
		}
		
		return maxLen;
	}
	
	
	
	
	
	// follow up:
	public int getLongestConsecutiveSubsequenceInTree(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int[] ans = DFS(root);
		return Math.max(ans[0], ans[1]);
	}
	
	public int[] DFS(TreeNode node) {
		if(node == null) {
			return new int[] {0, 0};
		}
		
		int[] leftCount = DFS(node.left);
		int[] rightCount = DFS(node.right);
		int[] currentCount = new int[2];
		
		if(node.left != null && node.value + 1 == node.left.value) {
			currentCount[0] = leftCount[0];
		}
		
		if(node.right != null && node.value + 1 == node.right.value) {
			currentCount[0] = Math.max(currentCount[0], rightCount[0]);
		}
		
		if(node.left != null && node.value - 1 == node.left.value) {
			currentCount[1] = leftCount[1];
		}
		
		if(node.right != null && node.value - 1 == node.right.value) {
			currentCount[1] = Math.max(currentCount[1], rightCount[1]);
		}
		
		currentCount[0] += 1;
		currentCount[1] += 1;
		return currentCount;
	}
	
	
	
	
	
	
	
	/*********************************** main function **************************************/
	
	public static void main(String[] args) {
		Q16_1_Longest_Consecutive_Subsequence_Array t= new Q16_1_Longest_Consecutive_Subsequence_Array();
		int[] nums = {1,2,3,5,4,3,2,1};
		System.out.println(t.getLongestConsecutiveSubsequenceInArray(nums));
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(6);
		root.right = new TreeNode(4);
		
		root.left.left = new TreeNode(7);
		root.right.right = new TreeNode(3);
		
		root.left.left.left = new TreeNode(8);
		root.right.right.right = new TreeNode(2);
		
		root.left.left.left.left = new TreeNode(9);
		
		System.out.println(t.getLongestConsecutiveSubsequenceInTree(root));
	}
}
