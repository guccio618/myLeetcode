import java.util.LinkedList;
import java.util.List;


public class myQueue {
	private List<String> list = new LinkedList();
	
	public String poll() {
		if(list.isEmpty()) {
			return null;
		} else {
			int pos = 0;
			String ans = list.get(pos);
			list.remove(pos);
			return ans;
		}
	}
	
	public void add(String value) {
		list.add(value);
	}
	
	public String peek() {
		if(list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	public int size() {
		return list.size();
	}
}
