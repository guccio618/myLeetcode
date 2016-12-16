public class Q086_Partition_List {
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode node1 = dummy1, node2 = dummy2;
        
        while(head != null) {
            if(head.val < x) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            
            head = head.next;
        }
        
        node1.next = dummy2.next;
        node2.next = null;
        return dummy1.next;
    }
	
	
	
	
	
	public static void main(String[] args){
		Q086_Partition_List t = new Q086_Partition_List();
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		ListNode res = t.partition(head, 2);
		
		while(res != null){
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
}
