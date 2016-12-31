import java.util.*;

public class P2_Copy_List_with_Random_Pointer {
	public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while(head != null){
            if(map.containsKey(head)){
                node.next = map.get(head);
            } else {
                RandomListNode copyNode = new RandomListNode(head.label);
                node.next = copyNode;
                map.put(head, copyNode);
            }
            
            if(head.random != null){
                if(map.containsKey(head.random)){
                    node.next.random = map.get(head.random);
                } else {
                    RandomListNode copyRandom = new RandomListNode(head.random.label);
                    node.next.random = copyRandom;
                    map.put(head.random, copyRandom);
                }
            }
            
            head = head.next;
            node = node.next;
        }
        
        return dummy.next;
    }
}
