
public class Lecture6_LinkedList_10_Rotate_List {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        int length = getLength(head);
        n = n % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    
	private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
	
	
	
	
	/*******************************************************/
    // by Jackie
	public ListNode rotateRight2(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null || k <= 0){
            return head;
        }
        ListNode front = head, back = head;
        
        int count = 0, num = 1;
        while(front.next != null){
            front = front.next;
            num++;
        }
        k = k % num;
        if(k == 0){
            return head;
        }
        front = head;
        
        while(count < k && front != null){
            front = front.next;
            count++;
        }
        
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        ListNode res = back.next;
        back.next = null;
        front.next = head;
        return res;
    }
}
