
public class Q102_Linked_List_Cycle {
	// by Jackie
	public boolean hasCycle(ListNode head) {  
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
