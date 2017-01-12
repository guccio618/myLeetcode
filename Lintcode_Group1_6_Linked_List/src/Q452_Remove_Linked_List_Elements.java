
public class Q452_Remove_Linked_List_Elements {
	// by Jackie
	public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode posPoint = tempHead;
        while(posPoint.next != null){
            if(posPoint.next.val == val){
                posPoint.next = posPoint.next.next;
                continue;
            }
            posPoint = posPoint.next;
        }
        return tempHead.next;
    }
}
