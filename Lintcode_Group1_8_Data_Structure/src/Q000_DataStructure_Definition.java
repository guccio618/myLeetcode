
public class Q000_DataStructure_Definition {

}

class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

// Definition for ListNode.
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

//Definition for singly-linked list with a random pointer.
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

//Definition for Doubly-ListNode.
class DoublyListNode {
	int val;
	DoublyListNode next, prev;
	DoublyListNode(int val) {
		this.val = val;
		this.next = this.prev = null;
	}
}
