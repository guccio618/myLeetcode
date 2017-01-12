public class Q207_Interval_Sum_II {
	// by Jackie using Segment Tree
	class SegmentTreeNode {
		public int start, end;
		public long sum;
		public SegmentTreeNode left, right;

		public SegmentTreeNode(int start, int end, long sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
			this.left = this.right = null;
		}
	}

	SegmentTreeNode root;

	public SegmentTreeNode build(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		if(start == end){
			return new SegmentTreeNode(start, end, nums[start]);
		}
		SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
		root.left = build(nums, start, (start + end) / 2);
		root.right = build(nums, (start + end) / 2 + 1, end);
		root.sum = root.left.sum + root.right.sum;
		return root;
	}

	public long querySegmentTree(SegmentTreeNode root, int start, int end) {
		if (start <= root.start && root.end <= end) {
			return root.sum;
		}

		int mid = (root.start + root.end) / 2;
		long leftsum = 0, rightsum = 0;

		if (start <= mid) {
			if (mid < end) {
				leftsum = querySegmentTree(root.left, start, mid);
			} else {
				leftsum = querySegmentTree(root.left, start, end);
			}
		}

		if (mid < end) {
			if (start <= mid) {
				rightsum = querySegmentTree(root.right, mid + 1, end);
			} else {
				rightsum = querySegmentTree(root.right, start, end);
			}
		}

		return leftsum + rightsum;
	}

	public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
		if (root.start == index && root.end == index) {
			root.sum = value;
			return;
		}

		int mid = (root.start + root.end) / 2;
		if (root.start <= index && index <= mid) {
			modifySegmentTree(root.left, index, value);
		}

		if (mid < index && index <= root.end) {
			modifySegmentTree(root.right, index, value);
		}

		root.sum = root.left.sum + root.right.sum;
	}

	/**
	 * @param A: An integer array
	 */
	public Q207_Interval_Sum_II(int[] nums) {
		root = build(nums, 0, nums.length - 1);
	}

	/**
	 * @param start, end: Indices
	 * @return: The sum from start to end
	 */
	public long query(int start, int end) {
		return querySegmentTree(root, start, end);
	}

	/**
	 * @param index, value: modify A[index] to value.
	 */
	public void modify(int index, int value) {
		modifySegmentTree(root, index, value);
	}
	
	
	
	
	

	/****************************** main function *******************************/

	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 8, 5 };
		Q207_Interval_Sum_II t = new Q207_Interval_Sum_II(nums);
		System.out.println(t.query(0, 2));
    	t.modify(0,4);
    	System.out.println(t.query(0,1));
    	t.modify(2,1);
    	System.out.println(t.query(2,4));
    }
}
