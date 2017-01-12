
public class Q098_Sort_List {
	// by other using merge sort
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode post = fakeHead;
        while (post != null && post.next != null) {
            post = post.next.next;
            pre = pre.next;
        }
        ListNode next = pre.next;
        pre.next = null;
        ListNode a = sortList(next);   // divide
        ListNode b = sortList(head);
        return merge(a,b);             // conquer
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val > b.val) {
            b.next = merge(a,b.next);  // 再细分
            return b;
        }
        else {
            a.next = merge(a.next,b);
            return a;
        }
    }
}
