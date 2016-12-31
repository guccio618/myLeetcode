import java.util.Stack;


public class Lecture6_LinkedList_06_Reorder_List {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;

        merge(head, tail);
    }
	
	private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    private void merge(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    
    
    /*******************************************************/
    // by Jackie
    public void reorderList2(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
			return;
		}
		ListNode faster = head, slower = head, traveler = head;
		Stack<ListNode> s = new Stack<ListNode>();
		boolean oddFlag = false;
		while(faster != null && faster.next != null){
			faster = faster.next.next;
			slower = slower.next;
		}
		if(faster != null && faster.next == null){
			oddFlag = true;
		}
		while(slower != null){
			s.push(slower);
			slower = slower.next;
		}
		
		while(!s.isEmpty()){
			ListNode node = s.pop();
			node.next = traveler.next;
			traveler.next = node;
			if(oddFlag == true && s.size() == 1){
				ListNode tempNode = s.pop();
				traveler = traveler.next.next;
				traveler.next = tempNode;
				traveler.next.next = null;
			}
			else{
				traveler = traveler.next.next;
			}
		}
		if(oddFlag == false){
			traveler.next = null;
		}
		return ;
    }
}
