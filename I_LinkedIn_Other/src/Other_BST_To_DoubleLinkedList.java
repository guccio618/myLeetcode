import java.util.Stack;


public class Other_BST_To_DoubleLinkedList {
	public DoubleListNode BST_To_List(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		DoubleListNode dummy = new DoubleListNode(0);
		DoubleListNode node = dummy;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(!stack.isEmpty() || root != null) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			DoubleListNode n = new DoubleListNode(root.val);
			node.next = n;
			n.prev = node;
			node = node.next;
			root = root.right;
		}
		
		dummy.next.prev = null;
		return dummy.next;
	}
	
	
	public void print(DoubleListNode head) {
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Other_BST_To_DoubleLinkedList t = new Other_BST_To_DoubleLinkedList();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		DoubleListNode head = t.BST_To_List(root);
		t.print(head);
	}
	
}

class DoubleListNode {
	int val;
	DoubleListNode prev, next;
	
	public DoubleListNode(int val) {
		this.val = val;
		prev = next = null;
	}
}