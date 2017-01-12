
public class Q174_Remove_Nth_Node_From_End_of_List {
	// by Jackie
	ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head == null || n <= 0){
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode front = tempHead;
        ListNode back = tempHead;
        int count = 0;
        while(count < n && back != null){
            back = back.next;
            count++;
        }
        
        if(count < n){
            return tempHead.next;
        }
        
        while(back.next != null){
            back = back.next;
            front = front.next;
        }
        
        front.next = front.next.next;
        return tempHead.next;
    }
}
