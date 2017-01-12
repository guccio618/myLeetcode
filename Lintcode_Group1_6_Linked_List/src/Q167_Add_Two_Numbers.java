
public class Q167_Add_Two_Numbers {
	// by Jackie
	public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int addFlag = 0;
        ListNode head = new ListNode(0);
        ListNode p1 = l1, p2 = l2, traveler = head;
        
        
        while(p1 != null || p2 != null){
            if(p1 != null && p2 == null){
                traveler.next = new ListNode( (p1.val + addFlag) % 10 );
                addFlag = (p1.val + addFlag) / 10;
                p1 = p1.next;
            } else if(p1 == null && p2 != null){
                traveler.next = new ListNode( (p2.val + addFlag) % 10 );
                addFlag = (p2.val + addFlag) / 10;
                p2 = p2.next;
            } else{
                traveler.next = new ListNode( (p1.val + p2.val + addFlag) % 10 );
                addFlag = (p1.val + p2.val + addFlag) / 10;
                p1 = p1.next;
                p2 = p2.next;
            }
            traveler = traveler.next;
        }
        if(addFlag > 0){
            traveler.next = new ListNode(addFlag);
        }
        return head.next;
    }
}
