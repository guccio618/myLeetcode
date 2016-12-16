import java.util.HashMap;


public class Q000_Algorithm_UnionFind {
	private HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
	
	public int find(int x){
		int parent = father.get(x);
		while(parent != father.get(parent)){
			parent = father.get(parent);
		}
		return parent;
	}
	
	public int compressFind(int x){
		int parent = father.get(x);		
		while(parent != father.get(parent)){
			parent = father.get(parent);
		}		
		int temp = -1;
		int current = x;
		while(current != father.get(current)){
			temp = father.get(current);
			father.put(current, parent);
			current = temp;
		}
		return parent;
	}
	
	public void union(int x, int y){
		int father_x = father.get(x);
		int father_y = father.get(y);
		if(father_x != father_y){
			father.put(father_x, father_y);
		}
	}
}
