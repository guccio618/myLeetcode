
public class Q082_Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode new_head = new ListNode(0), loc = new_head;
        new_head.next = head;
        
        while(head.next != null){
            if(head.val == head.next.val){
                while(head.next != null && head.val == head.next.val)
                    head.next = head.next.next;
                if(head.next != null){
                    head = head.next;
                    loc.next = head;
                }
                else
                    loc.next = null;
            }
            else{
                loc = loc.next;
                head = head.next;
            }
        }
        return new_head.next;
    }
	
	
	public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode start = head;
        ListNode end = head.next;
        
        while(end != null){
            if(start.val == end.val){
                while(end != null && start.val == end.val){
                    end = end.next;
                }
                start = end;
                if(end != null){
                    end = end.next;
                }
            } else {
                node.next = start;
                node = node.next;
                start = end;
                
                end = end.next;
            }
        }
        
        node.next = start;
        return dummy.next;
    }
	
	
	
	public static void main(String[] args){
		Q082_Remove_Duplicates_from_Sorted_List_II t = new Q082_Remove_Duplicates_from_Sorted_List_II();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode list = t.deleteDuplicates2(head);
		
		while(list != null){
			System.out.print(list.val + ", ");
			list = list.next;
		}
	}
}
