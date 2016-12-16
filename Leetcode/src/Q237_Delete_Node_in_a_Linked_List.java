
public class Q237_Delete_Node_in_a_Linked_List {
	public void deleteNode(ListNode node) {
        if(node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}