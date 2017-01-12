import java.util.HashMap;


public class Q134_LRU_Cache {
	// by ninechapter
	private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
	
    public Q134_LRU_Cache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    // @return an integer
    public int get(int key) {
        if( !hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void set(int key, int value) {
        if( get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
    
    
    
    /****************************************************************/
    
//    public LRUCache(int capacity) {
//        this.capicity = capacity;
//        map = new HashMap<>();
//        head = new Node(0, 0);
//        tail = new Node(0, 0);
//        head.next = tail;
//        tail.pre = head;
//        head.pre = null;
//        tail.next = null;
//        count = 0;
//    }
//
//    public void deleteNode(Node node) {
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//    }
//
//    public void addToHead(Node node) {
//        node.next = head.next;
//        node.next.pre = node;
//        node.pre = head;
//        head.next = node;
//    }
//
//    public int get(int key) {
//        if (map.get(key) != null) {
//            Node node = map.get(key);
//            int result = node.value;
//            deleteNode(node);
//            addToHead(node);
//            return result;
//        }
//        return -1;
//    }
//
//    public void set(int key, int value) {
//        if (map.get(key) != null) {
//            Node node = map.get(key);
//            node.value = value;
//            deleteNode(node);
//            addToHead(node);
//        } else {
//            Node node = new Node(key, value);
//            map.put(key, node);
//            if (count < capicity) {
//                count++;
//                addToHead(node);
//            } else {
//                map.remove(tail.pre.key);
//                deleteNode(tail.pre);
//                addToHead(node);
//            }
//        }
//    }
}
