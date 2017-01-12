
public class Q450_Reverse_Nodes_in_k_Group {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null){
            head = reverseHelper(head, k);
        }
        
        return dummy.next;
    }
    
    public ListNode reverseHelper(ListNode head, int k){
        ListNode node = head;
        for(int i = 0; i < k; ++i){
            if(node.next == null){
                return node;
            }
            node = node.next;
        }
        // 每次head均为需要reverse的头结点的前一个结点，相当于dummy；res记录了实际翻转的序列的头结点
        ListNode cur = head, curNext = cur.next, r = null, res = head.next;
        for(int i = 0; i < k; ++i){
            r = curNext.next;
            curNext.next = cur;
            cur = curNext;
            curNext = r;
        }
        res.next = curNext;
        head.next = cur;
        return res;
    }
}
