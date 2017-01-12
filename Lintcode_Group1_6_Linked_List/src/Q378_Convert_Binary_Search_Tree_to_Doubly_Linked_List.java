import java.util.Stack;


public class Q378_Convert_Binary_Search_Tree_to_Doubly_Linked_List {
	// by Jackie
	public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null){
            return null;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        DoublyListNode head = new DoublyListNode(0);
        DoublyListNode listNode = head;
        
        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            DoublyListNode tempNode = new DoublyListNode(root.val);
            listNode.next = tempNode;
            tempNode.prev = listNode;
            listNode = listNode.next;
            root = root.right;
        }
        DoublyListNode res = head.next;
        res.prev = null;
        return res;
    }
}
