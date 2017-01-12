
public class Q113_Remove_Duplicates_from_Sorted_List_II {
	// by Jackie
	public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode travelPoint = tempHead;
        ListNode start = head;
        ListNode end = start.next;
        
        while(end != null){
            if(start.val == end.val){
                while(end != null && start.val == end.val){
                    end = end.next;
                } 
                if(end == null){
                    travelPoint.next = null;
                }
                else{
                    start = end;
                    end = start.next;
                }
            }
            else{
                travelPoint.next = start;
                travelPoint = travelPoint.next;
                start = end;
                end = start.next;
            }
        }
        return tempHead.next;
    }
	
	
	public static void main(String[] args){
		Q113_Remove_Duplicates_from_Sorted_List_II t = new Q113_Remove_Duplicates_from_Sorted_List_II();
		ListNode root = new ListNode(1);
		ListNode temp = root;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		
		ListNode res = t.deleteDuplicates(root);
		
		while(res != null){
			System.out.print(res.val + ",, ");
			res = res.next;
		}
	}
}
