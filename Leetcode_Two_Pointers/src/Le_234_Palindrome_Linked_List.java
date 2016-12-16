import java.util.*;

/*******
 * 
Given a singly linked list, determine if it is a palindrome.

Follow up:
	Could you do it in O(n) time and O(1) space?
 * 
 * **/


public class Le_234_Palindrome_Linked_List {
	// solution 1: using hashmap, time O(n), space O(n)
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        
        Map<Integer, ListNode> map = new HashMap();
        int index = 0;
        ListNode node = head;
        
        while(node != null) {
            map.put(index, node);
            node = node.next;
            index++;
        }
        
        int len = index;
        
        for(int i = 0; i <= len/2; i++) {
            ListNode n1 = map.get(i);
            ListNode n2 = map.get(len - 1 - i);
            
            if(n1.val != n2.val) {
                return false;
            }
        }
        
        return true;
    }
	
	
	// solution 2: reverse part of the list, time O(n), space O(1)
	public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode faster = dummy, slower = dummy;
        
        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        
        ListNode nextHead = reverseList(slower.next);
        slower.next = null;
        
        while(head != null && nextHead != null) {
            if(head.val != nextHead.val) {
                return false;
            }
            
            head = head.next;
            nextHead = nextHead.next;
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        
        ListNode current = node;
        ListNode curNext = node.next;
        ListNode curNextNext = node.next.next;
        
        while(curNextNext != null) {
            curNext.next = current;
            current = curNext;
            curNext = curNextNext;
            curNextNext = curNextNext.next;
        }
        
        curNext.next = current;
        node.next = null;
        return curNext;
    }
}
