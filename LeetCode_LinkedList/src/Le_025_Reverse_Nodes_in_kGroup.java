
/*************************************************
 *  (1). 此题分段进行转置，需要纪录每段的头和尾；
 *  (2). 转置的时候需要考虑到结束的条件为node = null；
 * 
 *************************************************/

public class Le_025_Reverse_Nodes_in_kGroup {
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
}
