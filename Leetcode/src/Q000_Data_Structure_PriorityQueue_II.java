import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q000_Data_Structure_PriorityQueue_II {
	private class node{
		protected String name;
		protected int priority;
		
		public node(String n, int p){
			name = n;
			priority = p;
		}
	}
	
	private Queue<node> heap = new PriorityQueue<node>(10, new Comparator<node>(){
		public int compare(node left, node right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.priority - right.priority;
        }
	});

	public void function(){
		heap.add(new node("a", 5));
		heap.add(new node("b", 4));
		heap.add(new node("c", 3));
		heap.add(new node("d", 2));
		heap.add(new node("e", 1));
		
		while(!heap.isEmpty()){
			System.out.print(heap.poll().name + ", ");
		}
	}
	
	public static void main(String[] args){
		Q000_Data_Structure_PriorityQueue_II t = new Q000_Data_Structure_PriorityQueue_II();
		t.function();
	}
}
