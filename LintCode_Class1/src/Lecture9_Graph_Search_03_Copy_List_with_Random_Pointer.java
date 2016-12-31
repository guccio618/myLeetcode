import java.util.HashMap;


public class Lecture9_Graph_Search_03_Copy_List_with_Random_Pointer {
	/*************************************************************
	 * 1. 用map来记录source和copy的node对应关系;
	 * 2. 拷贝head; (分为已经拷贝过和未拷贝过的两种情况)
	 * 3. 拷贝head的neighbour; (分为已经拷贝过和未拷贝过的两种情况)
	 **************************************************************/
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();  // 用map来记录source和copy的node对应关系
        RandomListNode dummy = new RandomListNode(0);     // 链表的问题通常都运用到了dummy作为临时的头结点
        RandomListNode pre = dummy, newNode;
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = newNode;
            head = head.next;
        }

        return dummy.next;
    }
}
