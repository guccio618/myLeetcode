
public class Q223_Palindrome_Linked_List {
	/***********************************************************/
	// by ninechapter, O(n), space O(1)
	public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        
        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p2 == null;
    }
    
    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
	
	
	/***********************************************************/
	// by Jackie, O(n), space O(n)
	public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = null;
        ListNode traveler = head;
        
        while(traveler != null){
            ListNode node = new ListNode(traveler.val);
            node.next = tempHead.next;
            tempHead.next = node;
            traveler = traveler.next;
        }
        
        tempHead = tempHead.next;
        traveler = head;
        
        while(tempHead != null && traveler != null){
            if(tempHead.val != traveler.val){
                return false;
            }
            tempHead = tempHead.next;
            traveler = traveler.next;
        }
        return true;
    }
}
