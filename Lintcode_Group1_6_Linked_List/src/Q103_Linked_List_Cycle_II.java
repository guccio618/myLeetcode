
public class Q103_Linked_List_Cycle_II {
	// by ninechapter
	public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } 
        
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
