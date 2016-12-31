import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Lecture6_LinkedList_11_Merge_k_Sorted_Lists {
	/*****************************************************************
	 * 时间复杂度：O(NlogK)
	 * 		用树形分析法, 按层算每层结点数*层数
	 *
	 *****************************************************************/
	// Divide and Conquer
	public ListNode mergeKLists1(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        return dummy.next;
    }



/********************************************************************
 * 时间复杂度: NlogK, N为list里的结点数； K为list总数； 
 * 		每个结点都要入队出队各一次， 耗费为logK, 共N个结点，因此总数为O(NlogK)
 * 
 ********************************************************************/
// Heap
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;
    }




/******************************************************************/
// merge two by two
/****************************
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 ****************************/ 
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1) {
            List<ListNode> new_lists = new ArrayList<ListNode>();
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                ListNode merged_list = merge(lists.get(i), lists.get(i+1));
                new_lists.add(merged_list);
            }
            if (lists.size() % 2 == 1) {
                new_lists.add(lists.get(lists.size() - 1));
            }
            lists = new_lists;
        }
        
        return lists.get(0);
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
        
        return dummy.next;
    }
    
    
    
    
    /*******************************************************/
    // by Jackie
    public ListNode mergeKLists2(List<ListNode> lists) {  
        if(lists==null||lists.size()==0) {  
            return null;  
        }  
        if(lists.size()==1) {  
            return lists.get(0);  
        }  
        int length = lists.size() ;  
        int mid = (length - 1)/2 ;  
        ListNode l1 = mergeKLists(lists.subList(0,mid + 1)) ;  
        ListNode l2 = mergeKLists(lists.subList(mid + 1,length)) ;  
  
        return merge2Lists(l1,l2) ;  
    }  
    
    ListNode merge2Lists(ListNode list1, ListNode list2) {  
        ListNode head    = new ListNode(-1);  
        ListNode current = head;  
        while(list1!=null&&list2!=null) {  
            if(list1.val<list2.val) {  
                current.next = list1;  
                list1   = list1.next;  
            } else {  
                current.next = list2;  
                list2   = list2.next;  
            }  
            current = current.next;  
        }  
        if(list1!=null) {  
            current.next = list1;  
        } else {  
            current.next = list2;  
        }  
        return head.next;  
    }
}
