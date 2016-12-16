
public class Le_142_Linked_List_Cycle_II {
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode faster = head.next, slower = head;   // 注意faster开始要和slower错开
        
        while(faster != null && faster.next != null && faster != slower){
            faster = faster.next.next;
            slower = slower.next;
        }
        
        if(faster != slower){
            return null;
        }
        
        faster = head;
        while(faster != slower.next){    // 注意判断条件是faster != slower.next
            faster = faster.next;
            slower = slower.next;
        }
        return faster;
    }
}
