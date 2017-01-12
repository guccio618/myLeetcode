
public class Q106_Convert_Sorted_List_to_Balanced_BST {
	// by Jackie
	public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null){
            return null;
        }
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return createTree(head, tail);
    }
    
    public TreeNode createTree(ListNode start, ListNode end){
        if(start == end){
            return new TreeNode(start.val);
        }
        if(start.next == end){
            TreeNode tNode = new TreeNode(end.val);
            tNode.left = new TreeNode(start.val);
            return tNode;
        }
        
        ListNode faster = start, slower = start, beforeSlower = start;
        while(faster != end && faster.next != end){
            faster = faster.next.next;
            beforeSlower = slower;
            slower = slower.next;
        }
        TreeNode tNode = new TreeNode(slower.val);
        tNode.left = createTree(start, beforeSlower);
        tNode.right = createTree(slower.next, end);
        return tNode;
    }
}
