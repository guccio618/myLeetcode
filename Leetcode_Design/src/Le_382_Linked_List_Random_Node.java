import java.util.*;
/*******
 * 
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
	What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

 * 
 * */

public class Le_382_Linked_List_Random_Node {
	// solution 1: using map, time is O(n), space is O(n)
	private java.util.Random rand = null;
    private Map<Integer, Integer> map = null;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Le_382_Linked_List_Random_Node(ListNode head) {
        rand = new java.util.Random();
        map = new HashMap<>();
        int index = 0;
        
        while(head != null) {
            map.put(index++, head.val);
            head = head.next;
        }   
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return map.get(rand.nextInt(map.size()));
    }
    
    
    
    // solution 2: time is O(n), space is O(1)
    /*****************
    private java.util.Random rand = null;
    private ListNode myHead = null;
    private int length;

    public Solution(ListNode head) {
        rand = new java.util.Random();
        myHead = head;
        
        while(head != null) {
            length++;
            head = head.next;
        }   
    }
    
    public int getRandom() {
        int index = rand.nextInt(length);
        ListNode node = myHead;
        
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        
        return node.val;
    }

 	*****/
}
