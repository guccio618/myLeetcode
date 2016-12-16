
public class Q092_Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || n - m <= 0) return head;
        ListNode start_pos = new ListNode(0), current, cur_next, r;
        ListNode new_head = start_pos;
        start_pos.next = head;
        
        for(int i = 1; i < m; i++)
            start_pos = start_pos.next;
        current = start_pos.next;
        cur_next = current.next;
        for(int i = 0; i < (n-m); i++){
            r = cur_next.next;
            cur_next.next = current;
            current = cur_next;
            cur_next = r;
        }
        start_pos.next.next = cur_next;
        start_pos.next = current;
        return new_head.next;
    }
}
