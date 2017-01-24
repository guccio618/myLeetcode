/***********
 * 
	Given a linked list, remove the nth node from the end of list and return its head.

	For example,

   	Given linked list: 1->2->3->4->5, and n = 2.

   	After removing the second node from the end, the linked list becomes 1->2->3->5.
	
	Note:
	Given n will always be valid.
	Try to do this in one pass.
	
 * 
 * */


public class Le_019_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode faster = dummy, slower = dummy;
        int index = 0;
        
        while(index < n && faster.next != null) {
            faster = faster.next;
            index++;
        }
        
        if(index < n) {
            return dummy.next;
        }
        
        while(faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        
        slower.next = slower.next.next;
        return dummy.next;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************** main function *************************************/	
	
	public static void main(String[] args){
		Le_019_Remove_Nth_Node_From_End_of_List t = new Le_019_Remove_Nth_Node_From_End_of_List();
		ListNode head = new ListNode(1);
		ListNode res = t.removeNthFromEnd(head, 1);
		if(res == null){
			System.out.println("null");
		} else {
			System.out.println("not null");
		}
		
	}
}
