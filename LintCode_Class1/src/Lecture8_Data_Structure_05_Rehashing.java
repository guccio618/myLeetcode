
public class Lecture8_Data_Structure_05_Rehashing {
	public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0){
            return new ListNode[0];
        }
        
        int size = hashTable.length;
        int newSize = 2 * size;
        ListNode[] newHashTable = new ListNode[newSize];
        ListNode p1 = null, p2 = null;
        int pos = 0;
        
        for(int i = 0; i < size; ++i){
            p1 = hashTable[i];
            while(p1 != null){
                pos = p1.val % newSize;
                if(p1.val < 0){
                    pos += newSize;
                }
                if(newHashTable[pos] == null){
                    newHashTable[pos] = p1;
                    p1 = p1.next;
                    newHashTable[pos].next = null;
                }else{
                    p2 = newHashTable[pos];
                    while(p2.next != null){
                        p2 = p2.next;
                    }
                    p2.next = p1;
                    p1 = p1.next;
                    p2.next.next = null;
                }
            }
        }
        return newHashTable;
    }
}
