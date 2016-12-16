public class Insert_Into_Cycle_Linked_List {
	public ListNode Solution(ListNode head, int val) {
		if (head == null) {
			ListNode rvalue = new ListNode(val);
			rvalue.next = rvalue;
			return rvalue;
		}

		ListNode cur = head;

		do {
			if (val >= cur.value && val <= cur.next.value) { // 这里有等于号 ！！！
				break;
			}
			if (cur.value > cur.next.value && (val > cur.value || val < cur.next.value)) { // 头尾相接处 ！！！
				break;
			}

			cur = cur.next;
		} while (cur != head);    // 注意用do while，且循环条件为 cur != head ！！！

		ListNode newNode = new ListNode(val);
		newNode.next = cur.next;
		cur.next = newNode;
		return newNode;
	}

	
	
	
	
	
	
	
	
	
	/************************** main function ****************************/
	
	public static void main(String[] args) {
		Insert_Into_Cycle_Linked_List t = new Insert_Into_Cycle_Linked_List();
		ListNode head = new ListNode(0);
		ListNode node = head;
		node.next = new ListNode(1);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(4);
		node = node.next;
		node.next = head;

		t.Solution(head, 2);
		int index = 0;

		while (index < 5) {
			System.out.print(head.value + ", ");
			head = head.next;
			index++;
		}
	}
}
