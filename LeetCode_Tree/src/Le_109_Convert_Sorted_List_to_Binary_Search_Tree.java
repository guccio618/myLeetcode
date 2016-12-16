/*****
 * 
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.

 * 
 * */


public class Le_109_Convert_Sorted_List_to_Binary_Search_Tree {
	/****************************************************************
	 * Given a singly linked list where elements are sorted in 
	 * ascending order, convert it to a height balanced BST.
	 ****************************************************************/
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        } else if(head.next == null){
            return new TreeNode(head.val);
        }
        
        ListNode faster = head;
        ListNode slower = head;
        ListNode frontTail = slower;
        
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            frontTail = slower;
            slower = slower.next;
        }
        
        frontTail.next = null;
        TreeNode root = new TreeNode(slower.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slower.next);
        return root;
    }
}
