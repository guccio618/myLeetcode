
public class Q035_Reverse_Linked_List {
	// by Jackie
	public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head, curNext = head.next, node = null;
        
        while(curNext != null){
            node = curNext.next;
            curNext.next = current;
            current = curNext;
            curNext = node;
        }
        head.next = null;
        return current;
    }
}
