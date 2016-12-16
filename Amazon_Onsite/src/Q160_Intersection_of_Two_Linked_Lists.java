/*****
 * 
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

 * 
 * */



public class Q160_Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        int len1 = 0, len2 = 0;
        ListNode node1 = headA;
        ListNode node2 = headB;
        
        while(node1 != null) {
            len1++;
            node1 = node1.next;
        }
        
        while(node2 != null) {
            len2++;
            node2 = node2.next;
        }
        
        int diff = Math.abs(len1 - len2);
        node1 = headA;
        node2 = headB;
        
        for(int i = 0; i < diff; i++) {
            if(len1 > len2) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
        }
        
        while(node1 != null && node2 != null) {
            if(node1 == node2) {
                break;
            }
            
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return (node1 == null || node2 == null) ? null : node1;
    }
	
	
	
	
	
	
	
	
	
	
	/****************************** main function ********************************/
	
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.Insert(a, 3);
		a.Insert(a, 5);
		a.Insert(a, 7);
		a.Insert(a, 9);
		a.Insert(a, 11);
		a.Insert(a, 13);
		a.Insert(a, 15);
		a.Insert(a, 17);
		a.Insert(a, 19);
		a.Insert(a, 21);
		a.Display(a);
		b.Display(b);
		Q160_Intersection_of_Two_Linked_Lists it = new Q160_Intersection_of_Two_Linked_Lists();
		it.getIntersectionNode(a, b);
	}
}
