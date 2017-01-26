public class myLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	/**********************   链表里存放的节点   ***********************/
	private class Node {
		private Object data;    // 数据对象
		private Node next;      // 指向后继节点

		public Node() {
			data = null;
			next = null;
		}

		public Node(Object d, Node n) {
			data = d;
			next = n;
		}
	}

	/************************   构造函数   *************************/
	public myLinkedList() {    // 指向数据对象、后继节点的引用都置空
		head = null;
		tail = null;
		size = 0;
	}

	public myLinkedList(Object e) {   // 指定数据对象及后继节点
		tail = null;
		head = new Node(e, tail);
		size = 1;
	}

	/***********************   基本操作   *************************/
	public int insert_at(Object d, int pos) {
		if (pos > size || pos < 1) {
			return -1;
		}
		
		Node p = head, q;
		
		for (int i = 1; i < pos; i++) {
			p = p.next;
		}
		
		q = new Node(d, p.next);
		p.next = q;
		size++;
		return 0;
	}

	public void insert(Object d) {
		if (head == null) {
			head = new Node(d, null);
		} else if ((int) head.data > (int) d) {
			Node p = new Node(d, head);
			head = p;
		} else {
			Node p = head, q;
			
			while (p.next != null && (int) p.next.data <= (int) d) {
				p = p.next;
			}
			
			q = new Node(d, p.next);
			p.next = q;
		}
		
		size++;
	}

	public Object Delete_at(int pos) {
		if (pos > size || pos <= 0) {
			return -1;
		} else if (pos == 1) {
			Node p = head;
			Object res;
			res = head.data;
			head = head.next;
			p = null;
			size--;
			return res;
		} else {
			Node p = head, q;
			Object res;
			int i = 2;
			
			while (p.next.next != null && i < pos) {
				p = p.next;
				i++;
			}
			
			q = p.next;
			res = q.data;
			p.next = q.next;
			q = null;
			size--;
			return res;
		}
	}

	// 链表翻转
	public int Reverse() {       
		if (size <= 0) {
			return -1;
		} else if (size == 1) {
			return 0;
		} else {                   
			Node current = head, cur_next = current.next, r = null;
			
			while (cur_next != tail) {
				r = cur_next.next;
				cur_next.next = current;
				current = cur_next;
				cur_next = r;
			}
			
			head.next = tail;
			head = current;
			return 0;
		}
	}

	public boolean isEmpty() {
		if (head == tail) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return size;
	}

	public void display() {
		if (head == null) {
			return;
		}
		
		Node p = head;
		
		while (p != null) {
			System.out.print(p.data + ", ");
			p = p.next;
		}
		
		System.out.println("size:" + size);
	}

	public void clear() {
		if (head == null) {
			return;
		}
		
		while (head != null) {
			Node p = head;
			head = head.next;
			p = null;
		}
		
		size = 0;
	}
}
