
public class Lecture6_LinkedList_13_Convert_Sorted_List_to_Balanced_BST {
	private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }
    
    // 把current开头的，长度为size的那么多个点，变成BST,
    // 并顺便把current移动到size + 1那个点
    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
    
    
    
    /*******************************************************/
    // by Jackie
    public TreeNode sortedListToBST2(ListNode head) {  
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
