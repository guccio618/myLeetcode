
public class Q173_Insertion_Sort_List {
	// by ninechapter
	public ListNode insertionSortList(ListNode head) {
		ListNode cur = head;
	    ListNode dummy = new ListNode(0), p;
	    while (cur != null) {
	        //locate the insertion position.
	        p = dummy;
	        while (p.next != null &&  cur.val > p.next.val) {
	            p = p.next;
	        }
	        //insert between p and p.next.
	        ListNode pNext = p.next;
	        p.next = cur;
	        ListNode next = cur.next;
	        cur.next = pNext;
	        cur = next;
	    }
	    return dummy.next;
    }
	
	
	public static void main(String[] args){
		Q173_Insertion_Sort_List t = new Q173_Insertion_Sort_List();
		ListNode head = new ListNode(1);
		ListNode node = head;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(0);
		node = node.next;
		
		ListNode res = t.insertionSortList(head);
		while(res != null){
			System.out.print(res.val + "->");
			res = res.next;
		}
	}
	
}
