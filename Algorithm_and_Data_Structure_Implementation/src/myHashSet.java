import java.util.*;


public class myHashSet {
	private final int size = 100;
	private int used = 0;
	private List<String>[] array = new List[size];
	
	public void add(String key) {
		int pos = key.hashCode() % size;
		
		if(array[pos] == null) {
			array[pos] = new LinkedList<String>();
			array[pos].add(key);
			used++;
		} else {
			for(int i = 0; i < array[pos].size(); i++) {
				if(array[pos].get(i).equals(key)) {
					return;
				}
			}
			
			array[pos].add(key);
			used++;
		}
	}
	
	public boolean containsKey(String key) {
		int pos = key.hashCode() % size;
		
		if(array[pos] == null) {
			return false;
		} 
		
		for(int i = 0; i < array[pos].size(); i++) {			
			if(array[pos].get(i).equals(key)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void remove(String key) {
		int pos = key.hashCode() % size;
		
		if(!containsKey(key)) {
			return;
		} 
		
		for(int i = 0; i < array[pos].size(); i++) {
			if(array[pos].get(i).equals(key)) {
				array[pos].remove(i);
				used--;
				return;
			}
		}
	}
	
	public int size() {
		return used;
	}
						
	public static void main(String[] args) {
		myHashSet t = new myHashSet();
		System.out.println(t.containsKey("abc"));
		t.add("abc");
		System.out.println(t.containsKey("abc"));
		System.out.println(t.size());
		t.remove("ab");
		System.out.println(t.size());
		t.remove("abc");
		System.out.println(t.size());		
	}
}
