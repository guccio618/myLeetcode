
public class Q148_Sort_List {	
	/***************************
	 *       mergeSort         *
	 ***************************/
	// by other using mergeSort
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode post = fakeHead;
        
        while (post != null && post.next != null) {  // 找到list的中点
            post = post.next.next;
            pre = pre.next;
        }
        ListNode next = pre.next;
        pre.next = null;
        ListNode a = sortList(next);
        ListNode b = sortList(head);
        return merge(a,b);
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val > b.val) {
            b.next = merge(a,b.next);   // merge混合很巧妙。。。
            return b;
        }
        else {
            a.next = merge(a.next,b);
            return a;
        }
    }
    
    
    /***************************
	 *       quickSort         *
	 ***************************/
    
}
