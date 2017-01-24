/********
 * 
Given a linked list, swap every two adjacent nodes and return its head.

For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. 
	You may not modify the values in the list, only nodes itself can be changed.
	
 * 
 * */

public class Le_024_Swap_Nodes_in_Pairs {
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
