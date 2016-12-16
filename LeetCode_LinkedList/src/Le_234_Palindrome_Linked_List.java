
public class Le_234_Palindrome_Linked_List {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode faster = dummy, slower = dummy;
        
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        
        ListNode n1 = dummy.next;
        ListNode n2 = revertList(slower.next);
        
        while(n1 != null && n2 != null){
            if(n1.val != n2.val){
                return false;
            } else {
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        
        return true;
    }
    
    public ListNode revertList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode current = head;
        ListNode curNext = current.next;
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
