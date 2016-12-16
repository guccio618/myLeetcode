
public class Loop_in_linked_list {
	// 检测是否有环
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode faster = head.next, slower = head;  // 注意faster 从 head.next开始
        
        while(faster != null && faster.next != null && faster != slower){
            faster = faster.next.next;
            slower = slower.next;
        }
        
        return faster == slower;
    }
	
	
	// 查找cycle起点
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode faster = head.next, slower = head;
        
        while(faster != null && faster.next != null && faster != slower){
            faster = faster.next.next;
            slower = slower.next;
        }
        
        if(faster != slower){
            return null;
        }
        
        faster = head;
        slower = slower.next;
        
        while(faster != slower){
            faster = faster.next;
            slower = slower.next;
        }
        
        return faster;
    }
}



