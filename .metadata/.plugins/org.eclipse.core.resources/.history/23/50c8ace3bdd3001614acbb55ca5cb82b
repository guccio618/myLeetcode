
public class Q369_Plus_One_Linked_List {
	// by Jackie
	public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int flag = 1;
        
        dummy.next = reverseList(dummy.next);
        ListNode node = dummy;
        
        while(node.next != null && flag == 1){
            if(node.next.val == 9){
                node.next.val = 0;
            } else {
                node.next.val++;
                flag = 0;
            }
            
            node = node.next;
        }
        
        if(flag == 1){
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
}
