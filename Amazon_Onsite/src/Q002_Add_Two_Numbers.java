/*****
 * 
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 * 
 * */

public class Q002_Add_Two_Numbers {	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int flag = 0;
        int sum = 0;
        
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                sum = l1.val + l2.val + flag;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null) {
                sum = l1.val + flag;
                l1 = l1.next;
            } else {
                sum = l2.val + flag;
                l2 = l2.next;
            }
            
            flag = sum / 10;
            sum %= 10;
            node.next = new ListNode(sum);
            node = node.next;
        }
        
        if(flag != 0) {
            node.next = new ListNode(flag);
            node = node.next;
        }
        
        node.next = null;
        return dummy.next;
    }
	
	
	
	
	
	/********************** main function ******************************/
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		Q002_Add_Two_Numbers a = new Q002_Add_Two_Numbers();
		l1.Insert(l1, 9);
		l1.Display(l1);
		l2.Display(l2);
		ListNode l3 = a.addTwoNumbers(l1, l2);
		l3.Display(l3);		
	}
}


class ListNode {	
	int val;
	ListNode next;
	ListNode(int x) {val = x;}

	void Insert(ListNode head, int val) {
		ListNode in = new ListNode(val);
		ListNode locate = head;
		while (locate.next != null)
			locate = locate.next;
		in.next = locate.next;
		locate.next = in;
	}

	void Display(ListNode head) {
		ListNode locate = head;
		while (locate != null) {
			System.out.print(locate.val + " ");
			locate = locate.next;
		}
		System.out.println();
	}
}
