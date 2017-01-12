import java.util.Stack;


public class Q099_Reorder_List {
	// by Jackie
	public void reorderList(ListNode head) {  
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
	
	
	public static void main(String[] args){
		Q099_Reorder_List t = new Q099_Reorder_List();
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(6);
		temp = temp.next;
		temp.next = new ListNode(7);
		temp = temp.next;
		temp.next = new ListNode(8);
		temp = temp.next;
		temp.next = new ListNode(9);
		temp = temp.next;
		t.reorderList(head);
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}
}
