
public class Q203_Remove_Linked_List_Elements {
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode res_head = new ListNode(0), loc = res_head;
                
        while(head != null){
        	if(head.val != val){
        		loc.next = head;
        		loc = loc.next;
        	}
        	head = head.next;        	
        }
        loc.next = null;                    //此句非常重要
        return res_head.next;
    }
	
	public ListNode removeElements_2(ListNode head, int val) {
        if(head == null) return null;
        ListNode res_head = new ListNode(0), loc = res_head;
        
        while(head != null){
            if(head.val == val){
                head = head.next;
                continue;
            }
            loc.next = head;
            loc = loc.next;
            head = head.next;
        }
        loc.next = null;
        return res_head.next;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.Insert(head, 1);
		head.Insert(head, 2);
		Q203_Remove_Linked_List_Elements r = new Q203_Remove_Linked_List_Elements();
		head.Display(r.removeElements_2(head, 2));
	}
}
