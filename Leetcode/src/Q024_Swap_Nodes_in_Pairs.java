
public class Q024_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode traver = dummy;
        ListNode front = head.next, back = head;
        ListNode nextFront = null, nextBack = null;
        
        while(front != null){
            nextBack = front.next;
            
            if(front.next != null){
                nextFront = front.next.next;
            } else {
                nextFront = null;
            }
            
            traver.next = front;
            traver.next.next = back;
            traver = back;
            front = nextFront;
            back = nextBack;
        }
        
        if(back != null){
            traver.next = back;
            traver = traver.next;
        }
        
        traver.next = null;
        return dummy.next;
    }
}
