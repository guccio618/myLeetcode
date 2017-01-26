import java.util.*;

public class myHashMap {
	private class Pair{
		String key;
		String value;
		
		public Pair(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private final int size = 100;
	private int used = 0;
	private List<Pair>[] array = new List[size];
	
	public void put(String key, String value) {
		int pos = key.hashCode() % size;
		
		if(array[pos] == null) {
			array[pos] = new LinkedList<Pair>();
			array[pos].add(new Pair(key, value));
			used++;
		} else {
			for(int i = 0; i < array[pos].size(); i++) {
				if(array[pos].get(i).key.equals(key)) {
					array[pos].get(i).value = value;
					return;
				}
			}
			
			array[pos].add(new Pair(key, value));
			used++;
		}
	}
	
	public String get(String key) {
		int pos = key.hashCode() % size;
		
		if(!containsKey(key)) {
			return null;
		}
		
		for(int i = 0; i < array[pos].size(); i++) {
			Pair p = array[pos].get(i);
			
			if(p.key.equals(key)) {
				return p.value;
			}
		}
		
		return null;
	}
	
	public boolean containsKey(String key) {
		int pos = key.hashCode() % size;
		
		if(array[pos] == null) {
			return false;
		} 
		
		for(int i = 0; i < array[pos].size(); i++) {
			Pair p = array[pos].get(i);
			
			if(p.key.equals(key)) {
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
			Pair p = array[pos].get(i);
			
			if(p.key.equals(key)) {
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
		myHashMap t = new myHashMap();
		t.put("abc", "string1");
		System.out.println(t.get("abc"));
		t.put("abc", "string2");
		System.out.println(t.get("abc"));
		System.out.println(t.size());
		t.put("abc1", "string2");
		System.out.println(t.size());
		System.out.println(t.get("abc1"));
		t.remove("abc1");
		System.out.println(t.size());
		System.out.println(t.get("abc1"));
	}
}


	
	
//	private int used = 0;
//	private int size = 100;
//	private List<String>[] strings = new List[size];
//
//	public void put(String key, String value) {
//		if (used == size) {
//			grow();
//		}
//
//		insert(key, value);
//	}
//
//	public String get(String key) {
//		int code = key.hashCode();
//		int pos = code % size;
//
//		if (strings[pos] == null) {
//			return "";
//		} else if (strings[pos].get(0).equals(key)) {
//			return strings[pos].get(1);
//		} else {
//			int index = (pos + 1) % size;
//
//			while (index != pos) {
//				if (strings[index] == null) {
//					return "";
//				} else if (strings[index].get(0).equals(key)) {
//					return strings[index].get(1);
//				} else {
//					index = (index + 1) % size;
//				}
//			}
//
//			return "";
//		}
//	}
//
//	public void insert(String key, String value) {
//		int code = key.hashCode();
//		int pos = code % size;
//
//		if (strings[pos] == null) {
//			strings[pos] = new ArrayList();
//			strings[pos].add(key);
//			strings[pos].add(value);
//			used++;
//		} else if (!strings[pos].get(0).equals(key)) {
//			int index = (pos + 1) % size;
//
//			while (index != pos) {
//				if (strings[index] == null || strings[index].get(0).equals(key)) {
//					break;
//				} else {
//					index = (index + 1) % size;
//				}
//			}
//
//			if (strings[index] == null) {
//				strings[index] = new ArrayList();
//				strings[index].add(key);
//				strings[index].add(value);
//				used++;
//			} else {
//				strings[index].set(1, value);
//			}
//		} else {
//			strings[pos].set(1, value);
//		}
//	}
//
//	public void grow() {
//		List<String>[] temp = strings;
//		strings = new List[size * 2];
//		size *= 2;
//
//		for (int i = 0; i < temp.length; i++) {
//			if (temp[i] != null) {
//				insert(temp[i].get(0), temp[i].get(1));
//			}
//		}
//	}
	
	
	
	
//}
