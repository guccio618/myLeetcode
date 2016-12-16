
/*****
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * */

public class Le_021_Merge_Two_Sorted_Lists {
	// test case
    // l1 == null || l2 == null
    // how to process the last element
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
            } else if(l1 != null) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            
            node = node.next;
        }
        
        node.next = null;
        return dummy.next;
    }
}
