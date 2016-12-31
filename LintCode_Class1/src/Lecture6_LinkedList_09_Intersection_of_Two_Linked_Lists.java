
public class Lecture6_LinkedList_09_Intersection_of_Two_Linked_Lists {
	/***********************************************************************
	 * 解法类似求linkedlist cycle II, 将list1的最后一个结点和list2的头结点相连，此时
	 * 形成了和linkedlist cycle II相同的结构， list1的头结点即为head
	 * 
	 ***********************************************************************/
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        } 
        ListNode node = headA;
        while(node.next != null){
            node = node.next;
        }
        node.next = headB;
        
        ListNode faster = headA.next, slower = headA;
        
        while(faster != slower){
            if(faster == null || faster.next == null){
                return null;
            }
            faster = faster.next.next;
            slower = slower.next;
        }
        
        while(headA != slower.next){
            headA = headA.next;
            slower = slower.next;
        }
        return headA;
    }  
}
