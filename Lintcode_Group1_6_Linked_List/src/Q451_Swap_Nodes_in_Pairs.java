
public class Q451_Swap_Nodes_in_Pairs {
	// by Jackie
	public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode front = head, back = head.next, traveler = tempHead;
        
        while(back != null){
            traveler.next = back;
            front.next = back.next;
            back.next = front;
            traveler = front;
            front = traveler.next;
            if(front != null){
                back = front.next;
            }
            else{
                back = null;
            }
        }
        return tempHead.next;
    }
}
