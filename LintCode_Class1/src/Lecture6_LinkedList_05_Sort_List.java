
public class Lecture6_LinkedList_05_Sort_List {
	/************************************************************
	 * O(nlogn)的sort算法：
	 * 		heapSort, mergeSort, quickSort
	 * 		mergeSort: not in place, 稳定的，space O(n)
	 * 		quickSort: in place, 不稳定的, space O(1)
	 * 
	 ************************************************************/
	// MergeSort 
	public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);

//        ListNode right = sortList1(mid.next);    
//        mid.next = null;                         // 必须要此步
//        ListNode left = sortList1(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList1(head); 
        ListNode right = sortList1(rightHead);  
        return merge(left, right);
    }
	
	private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }    

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    
    
    /*************************************************************/
	// QuickSort 
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMedian(head); // O(n)
        
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head;
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
        
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        
        ListNode left = sortList2(leftDummy.next);
        ListNode right = sortList2(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
    }
    
    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0), tail = dummy;
        
        tail.next = left; tail = getTail(tail);
        tail.next = middle; tail = getTail(tail);
        tail.next = right; tail = getTail(tail);
        return dummy.next;
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
           return null;
        } 
       
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    
    
    
    /*************************************************************/
	// InsertSort 
    public ListNode sortList3(ListNode head) {
		ListNode cur = head;
	    ListNode dummy = new ListNode(0), p;
	    while (cur != null) {
	        //locate the insertion position.
	        p = dummy;
	        while (p.next != null &&  cur.val > p.next.val) {
	            p = p.next;
	        }
	        //insert between p and p.next.
	        ListNode pNext = p.next;
	        p.next = cur;
	        ListNode next = cur.next;
	        cur.next = pNext;
	        cur = next;
	    }
	    return dummy.next;
    }
    
    
    
    /*******************************************************/
    // by Jackie
    public ListNode sortList5(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode post = fakeHead;
        while (post != null && post.next != null) {
            post = post.next.next;
            pre = pre.next;
        }
        ListNode next = pre.next;
        pre.next = null;
        ListNode a = sortList5(next);
        ListNode b = sortList5(head);
        return merge(a,b);
    }

    public ListNode merge5(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val > b.val) {
            b.next = merge(a,b.next);
            return b;
        }
        else {
            a.next = merge(a.next,b);
            return a;
        }
    }
}






//// version 3: Quick Sort 2
///**
// * Definition for ListNode.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int val) {
// *         this.val = val;
// *         this.next = null;
// *     }
// * }
// */ 
//class Pair {
//    public ListNode first, second; 
//    public Pair(ListNode first, ListNode second) {
//        this.first = first;
//        this.second = second;
//    }
//}
//
//public class Solution {
//    /**
//     * @param head: The head of linked list.
//     * @return: You should return the head of the sorted linked list,
//                    using constant space complexity.
//     */
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        
//        ListNode mid = findMedian(head); // O(n)
//        Pair pair = partition(head, mid.val); // O(n)
//        
//        ListNode left = sortList(pair.first);
//        ListNode right = sortList(pair.second);
//        
//        getTail(left).next = right; // O(n)
//        
//        return left;
//    }
//    
//    // 1->2->3 return 2
//    // 1->2 return 1
//    private ListNode findMedian(ListNode head) {
//        ListNode slow = head, fast = head.next;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//    
//    // < value in the left, > value in the right
//    private Pair partition(ListNode head, int value) {
//        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
//        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
//        ListNode equalDummy = new ListNode(0), equalTail = equalDummy;
//        while (head != null) {
//            if (head.val < value) {
//                leftTail.next = head;
//                leftTail = head;
//            } else if (head.val > value) {
//                rightTail.next = head;
//                rightTail = head;
//            } else {
//                equalTail.next = head;
//                equalTail = head;
//            }
//            head = head.next;
//        }
//        
//        leftTail.next = null;
//        rightTail.next = null;
//        equalTail.next = null;
//        
//        if (leftDummy.next == null && rightDummy.next == null) {
//            ListNode mid = findMedian(equalDummy.next);
//            leftDummy.next = equalDummy.next;
//            rightDummy.next = mid.next;
//            mid.next = null;
//        } else if (leftDummy.next == null) {
//            leftTail.next = equalDummy.next;
//        } else {
//            rightTail.next = equalDummy.next;
//        }
//        
//        return new Pair(leftDummy.next, rightDummy.next);
//    }
//    
//    private ListNode getTail(ListNode head) {
//        if (head == null) {
//           return null;
//        } 
//       
//        while (head.next != null) {
//            head = head.next;
//        }
//        return head;
//    }
//}
