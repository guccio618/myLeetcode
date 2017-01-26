import java.util.*;
import java.util.LinkedList;


public class myStack {
	private List<String> list = new LinkedList();
	
	public String pop() {
		if(list.isEmpty()) {
			return null;
		} else {
			int pos = list.size() - 1;
			String ans = list.get(pos);
			list.remove(pos);
			return ans;
		}
	}
	
	public void push(String value) {
		list.add(value);
	}
	
	public String peek() {
		if(list.isEmpty()) {
			return null;
		} else {
			return list.get(list.size() - 1);
		}
	}
	
	public int size() {
		return list.size();
	}
	
	
	
	public static void main(String[] args) {
		myStack stack = new myStack();
		System.out.println(stack.size());
		stack.push("abc1");
		stack.push("abc2");
		stack.push("abc3");
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}
}
