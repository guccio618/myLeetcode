/****************************************************************
 * Given a singly linked list where elements are sorted in 
 * ascending order, convert it to a height balanced BST.
 ****************************************************************/

public class Le_109_Convert_Sorted_List_to_Binary_Search_Tree {
	// by Jackie
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
            frontTail = slower;
            faster = faster.next.next;
            slower = slower.next;
        }
        
        frontTail.next = null;
        TreeNode root = new TreeNode(slower.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slower.next);
        return root;
    }
	
	
	
	// by other
	public TreeNode sortedListToBST2(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode endMarker = null;                 // 引入一个endmark来记录slower的前一个节点位置！！！
        
        while(fast != null && fast.next != null){  // 两个指针用不同速度跑，找list的中点
            endMarker = slow;                      // 处理两个不同速度的指针，将list分成两段
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(endMarker != null) {                    //marking end point of first list !!!
            endMarker.next = null;  
        } else {
            head = null;                           // 注意这里的处理，head = null !!!             
        }     
        root.left = sortedListToBST(head);           
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
