/********
 * 
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Show Company Tags
Show Tags
Show Similar Problems
 
 * 
 * */

public class Q025_Reverse_Nodes_in_kGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 1){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode front = dummy;
        ListNode nextStart = null;
        int count = 0;
        
        while(front != null){
            count = 0;
            
            while(front != null && count < k){
                count++;
                front = front.next;
            }
            
            if(front == null){
                break;
            }
            
            nextStart = front.next;
            front.next = null;
            ListNode nodeNext = node.next;
            node.next = reverseList(node.next, nextStart);
            node = nodeNext;
            front = node;             // 每次front 都是从 node开始 ！！！
        }
        
        return dummy.next;
    }
    
    public ListNode reverseList(ListNode node, ListNode tail){     
        if(node.next == null){
            node.next = tail;
            return node;
        }
        
        ListNode current = node;
        ListNode curNext = current.next;
        ListNode curNextNext = curNext.next;
        
        while(curNextNext != null){
            curNext.next = current;
            current = curNext;
            curNext = curNextNext;
            curNextNext = curNextNext.next;
        }
        
        curNext.next = current;
        node.next = tail;
        return curNext;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /****************************** main function **********************************/
    
    public void print(ListNode node){
    	while(node != null){
    		System.out.print(node.val + ", ");
    		node = node.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args){
    	Q025_Reverse_Nodes_in_kGroup t = new Q025_Reverse_Nodes_in_kGroup();
    	ListNode head = new ListNode(1);
    	ListNode node = head;
    	node.next = new ListNode(2);
    	node = node.next;
    	node.next = new ListNode(3);
    	node = node.next;
    	node.next = new ListNode(4);    	
    	
    	t.print(head);
    	t.print(t.reverseKGroup(head, 2));    	
    }
}
