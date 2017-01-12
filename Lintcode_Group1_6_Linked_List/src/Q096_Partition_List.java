
public class Q096_Partition_List {
	// by Jackie
	public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null){
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode smallPoint = smallHead;
        ListNode largePoint = largeHead;
        ListNode travelPoint = head;
        
        while(travelPoint != null){
            if(travelPoint.val < x){
                smallPoint.next = travelPoint;
                smallPoint = smallPoint.next;
            }
            else{
                largePoint.next = travelPoint;
                largePoint = largePoint.next;
            }
            travelPoint = travelPoint.next;
        }
        largePoint.next = null;
        smallPoint.next = largeHead.next;
        return smallHead.next;
    }
}
