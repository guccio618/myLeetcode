
public class Le_237_Delete_Node_in_a_Linked_List {
	// test case: [0, 0, 0]
	public void deleteNode(ListNode node) {
        if(node == null){
            return;
        } else if(node.next == null){
            node = null;
            return;
        }
        
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        
        node.val = node.next.val;
        node.next = null;
    }
}
