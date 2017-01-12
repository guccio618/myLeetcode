
public class Q221_Add_Two_Numbers_II {
	// by Jackie
	public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode res = addLists1(l1, l2);
        return reverseList(res);
	}
   
	public ListNode addLists1(ListNode l1, ListNode l2) {
		int addFlag = 0;
        ListNode head = new ListNode(0);
        ListNode p1 = l1, p2 = l2, traveler = head;
                
        while(p1 != null || p2 != null){
            if(p1 != null && p2 == null){
                traveler.next = new ListNode( (p1.val + addFlag) % 10 );
                addFlag = (p1.val + addFlag) / 10;
                p1 = p1.next;
            } else if(p1 == null && p2 != null){
                traveler.next = new ListNode( (p2.val + addFlag) % 10 );
                addFlag = (p2.val + addFlag) / 10;
                p2 = p2.next;
            } else{
                traveler.next = new ListNode( (p1.val + p2.val + addFlag) % 10 );
                addFlag = (p1.val + p2.val + addFlag) / 10;
                p1 = p1.next;
                p2 = p2.next;
            }
            traveler = traveler.next;
        }
        if(addFlag > 0){
            traveler.next = new ListNode(addFlag);
        }
        return head.next;
	}
	
    public ListNode reverseList(ListNode head){
        ListNode current = head, curNext = head.next, node = null;
        
        while(curNext != null){
            node = curNext.next;
            curNext.next = current;
            current = curNext;
            curNext = node;
        }
        head.next = null;
        return current;
    }
    
    
    
    public void print(ListNode h){
    	ListNode p = h;
    	while(p != null){
    		System.out.print(p.val + ", ");
    		p = p.next;
    	}
    	System.out.println();
    }
    
    
    public static void main(String[] args){
    	Q221_Add_Two_Numbers_II t = new Q221_Add_Two_Numbers_II();
    	ListNode head1 = new ListNode(2);
		ListNode node1 = head1;
		node1.next = new ListNode(8);
		node1 = node1.next;
		node1.next = new ListNode(2);
		node1 = node1.next;
		node1.next = new ListNode(8);
		node1 = node1.next;
		node1.next = new ListNode(2);
		node1 = node1.next;
		node1.next = new ListNode(9);
		node1 = node1.next;
		node1.next = new ListNode(6);
		node1 = node1.next;
		node1.next = new ListNode(4);
		node1 = node1.next;
		node1.next = new ListNode(5);
		node1 = node1.next;
		node1.next = new ListNode(2);
		node1 = node1.next;
		node1.next = new ListNode(5);
		node1 = node1.next;
		node1.next = new ListNode(2);
		node1 = node1.next;
				
		ListNode head2 = new ListNode(5);
		ListNode node2 = head2;
		node2.next = new ListNode(8);
		node2 = node2.next;
		node2.next = new ListNode(9);
		node2 = node2.next;
		node2.next = new ListNode(5);
		node2 = node2.next;
		node2.next = new ListNode(6);
		node2 = node2.next;
		node2.next = new ListNode(5);
		node2 = node2.next;
		node2.next = new ListNode(1);
		node2 = node2.next;
		node2.next = new ListNode(8);
		node2 = node2.next;
		node2.next = new ListNode(7);
		node2 = node2.next;
		node2.next = new ListNode(5);
		node2 = node2.next;
		node2.next = new ListNode(5);
		node2 = node2.next;
		
		ListNode node3 = t.addLists2(head1, head2);
		
		while(node3 != null){
			System.out.print(node3.val + ", ");
			node3 = node3.next;
		}
    }
}
