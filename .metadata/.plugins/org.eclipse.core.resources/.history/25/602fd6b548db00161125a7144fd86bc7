/******
 * 
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
	Input:
	1->2->3

	Output:
	1->2->4

 * 
 * */

public class Q369_Plus_One_Linked_List {
	// test case: [9], [1,9,9]
	
	// solution 1: using reverse list, time is O(n)
	public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int addOneFlag = 1;
        
        dummy.next = reverseList(dummy.next);
        ListNode node = dummy;
        
        while(node.next != null && addOneFlag == 1){
            if(node.next.val == 9){
                node.next.val = 0;
            } else {
                node.next.val++;
                addOneFlag = 0;
            }
            
            node = node.next;
        }
        
        if(addOneFlag == 1){
            node.next = new ListNode(1);
        }
        
        return reverseList(dummy.next);
    }
    
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode current = head;
        ListNode curNext = head.next;
        ListNode curNextNext = curNext.next;
        
        while(curNextNext != null){
            curNext.next = current;
            current = curNext;
            curNext = curNextNext;
            curNextNext = curNextNext.next;
        }
        
        curNext.next = current;
        head.next = null;
        return curNext;
    }
    
    
     
    // solution 2
    public ListNode plusOne2(ListNode head) {
    	if(head == null) {
    		return head;
    	}
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode faster = dummy;
    	ListNode slower = dummy;
    	
    	while(faster != null) {
    		if(faster.val != 9) {
    			slower = faster;
    		}
    		
    		faster = faster.next;
    	}
    	
    	slower.val++;
    	slower = slower.next;
    	
    	while(slower != null) {
    		slower.val = 0;
    		slower = slower.next;
    	}
    	
    	return (dummy.val == 1) ?  dummy : dummy.next;    // test case: [9]
    }
}
