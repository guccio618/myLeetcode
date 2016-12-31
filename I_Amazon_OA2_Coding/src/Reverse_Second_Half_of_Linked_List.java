public class Reverse_Second_Half_of_Linked_List {
	public ListNode reverseSecondHalfList(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode faster = dummy;    // 从dummy开始 ！！！
		ListNode slower = dummy;
		
		while (faster != null && faster.next != null) {
			faster = faster.next.next;
			slower = slower.next;
		}
		
		slower.next = reverseList(slower.next);		   // nextHead = slower.next ！！！
		return dummy.next;
	}
	
	public ListNode reverseList(ListNode node){
		if(node == null || node.next == null){
			return node;
		}
		
		ListNode current = node;
		ListNode curNext = current.next;
		ListNode curNextNext = curNext.next;
		
		while(curNextNext != null){
			curNext.next = current;
			current = curNext;
			curNext = curNextNext;
			curNextNext = curNextNext.next;
		}
		
		curNext.next = current;
		node.next = null;
		return curNext;
	}
	
	
	
	
	/********************** main function ***********************/
	
	public static void main(String[] args){
		Reverse_Second_Half_of_Linked_List t = new Reverse_Second_Half_of_Linked_List();
		ListNode head = new ListNode(1);
		ListNode node = head;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(4);
		node = node.next;
		node.next = new ListNode(5);
		node = node.next;
//		node.next = new ListNode(6);
//		node = node.next;
//		node.next = new ListNode(7);
//		node = node.next;
		
		node = head;
		while(node != null){
			System.out.print(node.value + ", ");
			node = node.next;
		}
		System.out.println();
		
		node = t.reverseSecondHalfList(head);
		while(node != null){
			System.out.print(node.value + ", ");
			node = node.next;
		}
	}
}
