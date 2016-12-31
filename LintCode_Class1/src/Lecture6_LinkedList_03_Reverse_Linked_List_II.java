
public class Lecture6_LinkedList_03_Reverse_Linked_List_II {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
    }
	
	
	
	/*******************************************************/
    // by Jackie
	public ListNode reverseBetween2(ListNode head, int m , int n) {
        // write your code
        if(head == null || head.next == null){
            return head;
        }
        ListNode faultHead = new ListNode(0);
        faultHead.next = head;
        ListNode start = head;
        ListNode end =  head;
        ListNode curPos = faultHead;
        int i = 0;
        while(i < n-m && end != null){
            end = end.next;
            i++;
        }
        
        if(end == null){
            return head;
        }
        i = 0;
        while(i < m-1 && end != null){
            curPos = curPos.next;
            start = start.next;
            end = end.next;
            i++;
        }
        if(end == null){
            return head;
        }
        ListNode tail = end.next;
        ListNode cur = start;
        ListNode cur_next = cur.next;
        ListNode r = null;
        while(cur_next != tail){
            r = cur_next.next;
            cur_next.next = cur;
            cur = cur_next;
            cur_next = r;
        }
        start.next = tail;
        curPos.next = cur;
        return faultHead.next;
    }
}
