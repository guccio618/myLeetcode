import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


public class Q000_Java_Iterator {
	private Iterator iter;
	
	// 访问哈希表
	public void travelHashMap() {
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		int[] num = {1,2,3,4,5};
		String[] name = {"a", "b", "c", "d", "e"};
		
		for(int i = 0; i < num.length; ++i){
			myMap.put(num[i], name[i]);
		}
		
		System.out.println("iterator:");
		iter = myMap.entrySet().iterator();  // 需要用到entrySet，比用keySet快一倍
		while(iter.hasNext()) {
			HashMap.Entry entry = (HashMap.Entry) iter.next();
			int key = (int) entry.getKey();
			String val = (String) entry.getValue();
			System.out.print("[" + key + ", " + val + "], ");
		}
		System.out.println();
		
		// 非iterator访问方式
		System.out.println("non-iterator:");
		for(Map.Entry<Integer, String> entry : myMap.entrySet()){
	    	int key = entry.getKey();
	    	String val = entry.getValue();
	    	System.out.print("[" + key + ", " + val + "], ");
		}
		System.out.println();
	}
	
	// 访问链表
	public void travelLinkedList() {
		LinkedList<Integer> myList = new LinkedList<Integer>();
		int[] num = {1,2,3,4,5};
		
		for(int i = 0; i < num.length; ++i){
			myList.add(num[i]);
		}
		
		iter = myList.iterator();  // 直接用iterator
		while(iter.hasNext()) {
			System.out.print("[" + iter.next() + "], ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Q000_Java_Iterator test = new Q000_Java_Iterator();		
		test.travelHashMap();
		test.travelLinkedList();
	}
}
