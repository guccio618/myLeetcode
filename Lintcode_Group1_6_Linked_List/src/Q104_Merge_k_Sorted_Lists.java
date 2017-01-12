import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q104_Merge_k_Sorted_Lists {
	/****************************************************/
	// by other using divide & conquer
	public ListNode mergeKLists(List<ListNode> lists) {  
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
    
    
    /****************************************************/
	// by other using PriorityQueue
    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>(new ListComparator());
        for(ListNode n: lists){
            if( n!= null) {
                q.add(n);
            }
        }
        ListNode head = new ListNode(0), p = head, cur = null;
        while( !q.isEmpty()) {
            cur = q.poll();
            if(cur.next!=null)
                q.offer(cur.next);
            p.next = cur;
            p = p.next;
        }
        return head.next;
    }
    
    class ListComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
}
