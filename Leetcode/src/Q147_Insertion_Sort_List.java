public class Q147_Insertion_Sort_List {
	// by ninechapter
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);  // 注意这里没有dummy.next = head ！！！
		ListNode traver = dummy;
		ListNode pivot = head;

		while (pivot != null) {
			traver = dummy;

			while (traver.next != null && traver.next.val < pivot.val) {
				traver = traver.next;
			}

			ListNode pivotNext = pivot.next;
            pivot.next = traver.next;
            traver.next = pivot;
            pivot = pivotNext;
		}

		return dummy.next;
	}
}
