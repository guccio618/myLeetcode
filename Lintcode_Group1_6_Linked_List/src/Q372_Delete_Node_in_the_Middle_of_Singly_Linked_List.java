
public class Q372_Delete_Node_in_the_Middle_of_Singly_Linked_List {
	// by ninechapter
	public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	
	public static void main(String[] args){
		Q372_Delete_Node_in_the_Middle_of_Singly_Linked_List t = new Q372_Delete_Node_in_the_Middle_of_Singly_Linked_List();
		ListNode head = new ListNode(1);
		ListNode node = head;
		node.next = new ListNode(2);
		node = node.next;
		node.next = new ListNode(3);
		node = node.next;
		node.next = new ListNode(4);
		node = node.next;
		node.next = new ListNode(5);
		node = node.next;
		t.deleteNode(head);
		
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}
}
