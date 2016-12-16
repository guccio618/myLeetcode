
public class Q328_Odd_Even_Linked_List {
	// by Jackie
	public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode oddPoint = head, evenPoint = head.next, evenStart = head.next;
        
        while(evenPoint.next != null && evenPoint.next.next != null){
            oddPoint.next = evenPoint.next;
            oddPoint = oddPoint.next;
            evenPoint.next = oddPoint.next;
            evenPoint = evenPoint.next;
        }
        if(evenPoint.next == null){
            oddPoint.next = evenStart;
        }
        else{
            oddPoint.next = evenPoint.next;
            oddPoint.next.next = evenStart;
            evenPoint.next = null;
        }
        return head;
    }
}
