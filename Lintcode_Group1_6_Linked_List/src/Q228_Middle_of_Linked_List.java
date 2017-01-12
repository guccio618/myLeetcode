
public class Q228_Middle_of_Linked_List {
	public ListNode middleNode(ListNode head) { 
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode faster = tempHead;
        ListNode slower = tempHead;
        
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        return slower;
    }
}
