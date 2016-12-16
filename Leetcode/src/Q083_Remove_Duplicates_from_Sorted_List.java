
public class Q083_Remove_Duplicates_from_Sorted_List {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode loc = head;
        while(loc.next != null){
            if(loc.val == loc.next.val)
                loc.next = loc.next.next;
            else
                loc = loc.next;
        }
        return head;
    }
}
