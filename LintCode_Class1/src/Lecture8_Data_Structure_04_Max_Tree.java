import java.util.Stack;

public class Lecture8_Data_Structure_04_Max_Tree {
	// 单调栈，寻找一个数，其父亲必为左边第一个大于其的数和右边第一个大于其的数中的最小值
	public static TreeNode maxTree(int[] A) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		for (int i = 0; i <= A.length; i++) {
			TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
					: new TreeNode(A[i]);
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
				} else
					break;
			}
			stack.push(right);
		}
		return stack.peek().left;
	}

	/****************************************************/
	// 方法2
	/**
	 * @param A
	 *            : Given an integer array with no duplicates.
	 * @return: The root of max tree.
	 */
	public TreeNode maxTree2(int[] A) {
		// write your code here
		int len = A.length;
		TreeNode[] stk = new TreeNode[len];
		for (int i = 0; i < len; ++i)
			stk[i] = new TreeNode(0);
		int cnt = 0;
		for (int i = 0; i < len; ++i) {
			TreeNode tmp = new TreeNode(A[i]);
			while (cnt > 0 && A[i] > stk[cnt - 1].val) {
				tmp.left = stk[cnt - 1];
				cnt--;
			}
			if (cnt > 0)
				stk[cnt - 1].right = tmp;
			stk[cnt++] = tmp;
		}
		return stk[0];
	}
}
