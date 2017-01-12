
public class Q165_Merge_Two_Sorted_Lists {
	// by Jackie
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode tempHead = new ListNode(0);
        ListNode traveler = tempHead;
        
        while(l1 != null || l2 != null){
            if(l1 != null && l2 == null){
                traveler.next = l1;
                l1 = l1.next;
            } else if(l1 == null && l2 != null){
                traveler.next = l2;
                l2 = l2.next;
            } else{
                if(l1.val < l2.val){
                    traveler.next = l1;
                    l1 = l1.next;
                } else{
                    traveler.next = l2;
                    l2 = l2.next;
                }
            }
            traveler = traveler.next;
        }
        return tempHead.next;
    }
}	
