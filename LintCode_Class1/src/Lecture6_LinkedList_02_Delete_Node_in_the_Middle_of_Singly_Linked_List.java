
public class Lecture6_LinkedList_02_Delete_Node_in_the_Middle_of_Singly_Linked_List {
	public void deleteNode(ListNode node) {
        if(node == null || node.next == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
