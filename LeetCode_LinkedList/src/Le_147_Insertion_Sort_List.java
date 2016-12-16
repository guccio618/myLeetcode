
public class Le_147_Insertion_Sort_List {
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);  // 此处不可以有dummy.next = head， 会造成死循环， test case: [1, 1] ！！！
        ListNode node = null;
        ListNode current = head;
        
        while(current != null){
            node = dummy;                  // node每次均从dummy开始 ！！！
            while(node.next != null && node.next.val < current.val){
                node = node.next;
            }
            
            ListNode nodeNext = node.next;
            ListNode currentNext = current.next;
            node.next = current;
            current.next = nodeNext;
            current = currentNext;
        }
        
        return dummy.next;
    }
}
