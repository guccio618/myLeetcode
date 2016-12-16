
public class Le_148_Sort_List {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode faster = dummy, slower = dummy;
        
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        ListNode nextHead = slower.next;
        slower.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(nextHead);
        
        return mergeSort(left, right);
    }
    
    public ListNode mergeSort(ListNode node1, ListNode node2){
        if(node1 == null){
            return node2;
        } else if(node2 == null){
            return node1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(node1 != null || node2 != null){
            if(node1 != null && node2 != null){
                if(node1.val < node2.val){
                    node.next = node1;
                    node1 = node1.next;
                } else {
                    node.next = node2;
                    node2 = node2.next;
                }
                node = node.next;
            } else if(node1 != null && node2 == null){
                node.next = node1;
                break;
            } else {
                node.next = node2;
                break;
            }
        }
        
        return dummy.next;
    }
}
