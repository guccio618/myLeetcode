import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Q000_Data_Structure_Queue implements Queue {
	
	/************   定义和生成   ************/
	public static final int CAPACITY = 1000; // 数组的默认容量
	protected int capacity;                  // 数组的实际容量
	protected Object[] Q;                    // 对象数组
	protected int front = 0;                 // 对首
	protected int back = 0;                  // 对尾

	public Q000_Data_Structure_Queue() {
		this(CAPACITY);
	}

	public Q000_Data_Structure_Queue(int cap) {
		capacity = cap;
		Q = new Object[capacity];
	}

	/************   基本操作   ************/
	public int getSize() {
		return (capacity - front + back) % capacity;  // 注意要mod
	}

	public boolean isEmpty() {
		return (front == back);
	}

	public void enqueue(Object obj) throws Exception {
		if (getSize() == capacity - 1)
			throw new Exception("Queue overflow");
		Q[back] = obj;
		back = (back + 1) % capacity;      //注意mod
	}

	public Object dequeue() throws Exception {
		Object elem;
		if (isEmpty())
			throw new Exception("error:empty queue");
		elem = Q[front];
		Q[front] = null;
		front = (front + 1) % capacity;   //注意mod
		return elem;
	}

	// 取(并不删除)队首元素
	public Object front() throws Exception {
		if (isEmpty())
			throw new Exception("error:empty queue");
		return Q[front];
	}

	// 遍历(不属于ADT)
	public void Traversal() {
		for (int i = front; i < back; i++)
			System.out.print(Q[i] + " ");
		System.out.println();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}
}
