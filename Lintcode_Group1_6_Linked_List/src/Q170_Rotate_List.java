
public class Q170_Rotate_List {
	// by Jackie
	public ListNode rotateRight(ListNode head, int k) {
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
	
	

	public static void main(String[] args){
		Q170_Rotate_List t = new Q170_Rotate_List();
		ListNode head = new ListNode(1);
		ListNode node = head;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(1);
		node = node.next;		
		ListNode n = t.rotateRight(head, 1);
	}
}
