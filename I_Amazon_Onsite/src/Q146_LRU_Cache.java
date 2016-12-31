import java.util.*;

/*******
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 * 
 * */

public class Q146_LRU_Cache {
	private class Node{
        int key;
        int value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
	
    public Q146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);
        return current.value;
    }

    public void set(int key, int value) {
        if(get(key) != -1) {             // 这里必须用get(key)而不是map.containsKey(key)， 因为相当于访问过了，需要做move_to_tail操作
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);    // 必须先remove，否则head.next改变了 ！！！
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
    
    
    
    
    // class Amazon_OA2_LRU_Cache_Count_Miss
    public int Solution(int[] array, int size) {
		if (array == null){
			return 0;
		}
		
		List<Integer> cache = new LinkedList<Integer>();   // need to use linkedlist
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (cache.contains(array[i])) {
				cache.remove(new Integer(array[i]));    // remove the number "i"，not the number whose index is i ！！！
			} else {
				count++;
				
				if (size == cache.size()){
					cache.remove(0);
				}
			}
			
			cache.add(array[i]);      // each element should be added to the cache ！！！
		}
		
		return count;
	}
}
