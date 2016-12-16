import java.util.LinkedList;
import java.util.Queue;

/*****
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * 
 */

public class Le_100_Same_Tree {
	// solution 1: recursive method
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			if (p == null && q == null) {
				return true;
			} else {
				return false;
			}
		} else if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	// solution 2: iterator method
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList();
		queue.offer(p);
		queue.offer(q);

		while (!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();

			if (node1 == null && node2 == null) {
				continue;
			} else if (node1 == null || node2 == null) {
				return false;
			} else if (node1.val != node2.val) {
				return false;
			}

			queue.offer(node1.left);
			queue.offer(node2.left);
			queue.offer(node1.right);
			queue.offer(node2.right);
		}

		return true;
	}
}
