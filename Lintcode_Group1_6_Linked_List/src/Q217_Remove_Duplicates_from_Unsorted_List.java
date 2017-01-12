import java.util.HashSet;
import java.util.Set;


public class Q217_Remove_Duplicates_from_Unsorted_List {
	// by Jackie
	public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if(head == null){
            return head;
        }
        
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode traveler = tempHead;
        Set<Integer> mySet = new HashSet<Integer>();
        
        while(traveler.next != null){
            if(mySet.contains(traveler.next.val)){
                traveler.next = traveler.next.next;
            } else{
                mySet.add(traveler.next.val);
                traveler = traveler.next;
            }
        }
        return tempHead.next;
    }  
}
