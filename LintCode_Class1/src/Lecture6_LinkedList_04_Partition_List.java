
public class Lecture6_LinkedList_04_Partition_List {
	public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
	
	
	
	
	/*******************************************************/
    // by Jackie
	public ListNode partition2(ListNode head, int x) {
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
