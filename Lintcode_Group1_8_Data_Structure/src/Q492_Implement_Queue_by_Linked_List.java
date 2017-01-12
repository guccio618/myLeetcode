import java.util.LinkedList;

public class Q492_Implement_Queue_by_Linked_List {
	// by Jackie
	private LinkedList<Integer> queue;

	public Q492_Implement_Queue_by_Linked_List() {
		// do initialize if necessary
		queue = new LinkedList<Integer>();
	}

	public void enqueue(int item) {
		// Write your code here
		queue.add(item);
	}

	public int dequeue() {
		// Write your code here
		if (queue.size() == 0) {
			return -1;
		} else {
			int res = queue.get(0);
			queue.remove(0);
			return res;
		}
	}
}
