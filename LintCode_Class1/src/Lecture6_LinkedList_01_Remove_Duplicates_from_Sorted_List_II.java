
public class Lecture6_LinkedList_01_Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }            
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
	
	
	
	/*******************************************************/
    // by Jackie
	public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode travelPoint = tempHead;
        ListNode start = head;
        ListNode end = start.next;
        
        while(end != null){
            if(start.val == end.val){
                while(end != null && start.val == end.val){
                    end = end.next;
                } 
                if(end == null){
                    travelPoint.next = null;
                }
                else{
                    start = end;
                    end = start.next;
                }
            }
            else{
                travelPoint.next = start;
                travelPoint = travelPoint.next;
                start = end;
                end = start.next;
            }
        }
        return tempHead.next;
    }
}
