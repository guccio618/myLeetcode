
public class Lecture6_LinkedList_07_Linked_List_Cycle {
	public Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } 
        return true;
	}
	
	
	
	
	/*******************************************************/
    // by Jackie
	public boolean hasCycle2(ListNode head) {  
        // write your code here
        if(head == null){
            return false;
        }
        ListNode faster = head, slower = head;
        
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower){
                return true;
            }
        }
        return false;
    }
}
