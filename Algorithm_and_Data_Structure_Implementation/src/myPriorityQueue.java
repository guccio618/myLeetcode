import java.util.LinkedList;

/****************************************************************
 * implement priority queue by LinkedList + Binary Search
 * method 2: using Collections.sort after each enqueue operation
 * 
 ****************************************************************/

public class myPriorityQueue {
	private LinkedList<Pair> list;
	
	public myPriorityQueue(){
		list = new LinkedList<Pair>();
	}

	public void enqueue(Pair node){
		int pos = findPos(node.value);
		list.add(pos, node);
	}

	public Pair dequeue(){
		if(list.size() == 0){
			return null;
		} else {
			Pair node = list.get(0);
			list.remove(0);
			return node;
		}
	}
	
	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	public int findPos(int target){
		if(list.size() == 0 || target > list.get(list.size() - 1).value){
			return list.size();
		}
		
		int left = 0, right = list.size() - 1;
		
		while(left + 1 < right){
			int mid = left + (right - left) / 2;
			Pair midElement = list.get(mid);
			
			if(target < midElement.value){
				right = mid;
			} else {
				left = mid;
			}
		}
		
		if(list.get(right).value <= target){
			return right + 1;
		} else if(list.get(left).value <= target){
			return right;
		} else {
			return left;
		}
	}
	
	
	public static void main(String[] args){
		myPriorityQueue queue = new myPriorityQueue();
		queue.enqueue(new Pair("Element", 3));
		queue.enqueue(new Pair("Element", 7));
		queue.enqueue(new Pair("Element", 6));
		queue.enqueue(new Pair("Element", 5));
		queue.enqueue(new Pair("Element", 7));
		queue.enqueue(new Pair("Element", 2));
		queue.enqueue(new Pair("Element", 9));
		queue.enqueue(new Pair("Element", 6));
		queue.enqueue(new Pair("Element", 3));
		queue.enqueue(new Pair("Element", 1));
		queue.enqueue(new Pair("Element", 3));
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}	
}

class Pair {
	String str;
	int value;
		
	public Pair(String str, int value){
		this.str = str;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [str=" + str + ", value=" + value + "]";
	}
}
