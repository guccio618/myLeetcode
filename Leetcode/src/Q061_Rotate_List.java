import java.util.Stack;

/************
 * 
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

 * 
 * 
 * */

public class Q061_Rotate_List {
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode faster = head;
        int len = 0;
        
        while(faster != null){
            len++;
            faster = faster.next;
        }
        
        k %= len;
        faster = dummy;
        
        for(int i = 0; i < len - k; i++){
            faster = faster.next;
        }
        
        node.next = faster.next;
        faster.next = null;
        
        while(node.next != null){
            node = node.next;
        }
        
        node.next = head;
        return dummy.next;
    }

	
	
	
	public ListNode rotateRight_2(ListNode head, int k) { // by other
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode current = head;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		int rotations = stack.size() == 0 ? 0 : k % stack.size();
		for (int i = 0; i < rotations; i++) {
			ListNode node = stack.pop();
			ListNode last = stack.peek();
			last.next = null;
			node.next = head;
			head = node;
		}
		return head;
	}
	
	public static void main(String[] args){
		Q061_Rotate_List r = new Q061_Rotate_List();
		ListNode head = new ListNode(1);
		head.Insert(head, 2);
		head.Insert(head, 3);
		head.Insert(head, 4);
		head.Insert(head, 5);
		ListNode temp = r.rotateRight(head, 2);
		temp.Display(temp);
	}
}
