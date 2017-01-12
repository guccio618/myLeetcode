
public class Q036_Reverse_Linked_List_II {
	// by Jackie
	public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null || head.next == null){
            return head;
        }
        ListNode faultHead = new ListNode(0);
        faultHead.next = head;
        ListNode start = head;
        ListNode end =  head;
        ListNode curPos = faultHead;
        int i = 0;
        while(i < n-m && end != null){
            end = end.next;
            i++;
        }
        
        if(end == null){
            return head;
        }
        i = 0;
        while(i < m-1 && end != null){
            curPos = curPos.next;
            start = start.next;
            end = end.next;
            i++;
        }
        if(end == null){
            return head;
        }
        ListNode tail = end.next;
        ListNode cur = start;
        ListNode cur_next = cur.next;
        ListNode r = null;
        while(cur_next != tail){  // 3 4 5 null
            r = cur_next.next;
            cur_next.next = cur;
            cur = cur_next;
            cur_next = r;
        }
        start.next = tail;
        curPos.next = cur;
        return faultHead.next;
    }
	
	
	public static void main(String[] args){
		Q036_Reverse_Linked_List_II t = new Q036_Reverse_Linked_List_II();
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		
		ListNode res = t.reverseBetween(head, 2, 4);
		while(res != null){
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
}
