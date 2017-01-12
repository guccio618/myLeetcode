public class Q166_Nth_to_Last_Node_in_List {
	// by Jackie
	public ListNode nthToLast(ListNode head, int n) {
		// write your code here
		if (head == null) {
			return head;
		}

		ListNode tempHead = new ListNode(0);
		tempHead.next = head;
		ListNode front = head, back = head;
		int count = 0;

		while (count < n && front != null) {
			front = front.next;
			count++;
		}
		if (front == null && count < n) {
			return null;
		}

		while (front != null) {
			front = front.next;
			back = back.next;
		}

		return back;
	}
}
