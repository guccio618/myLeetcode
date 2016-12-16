import java.util.HashMap;


public class Le_138_Copy_List_with_Random_Pointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        RandomListNode newNode = null;
        
        while(head != null){
            if(map.containsKey(head)){
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            node.next = newNode;
            
            if(head.random != null){
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            
            node = newNode;
            head = head.next;
        }
        
        return dummy.next;
    }
}
