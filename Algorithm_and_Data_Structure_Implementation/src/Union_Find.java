import java.util.*;


public class Union_Find {
	Map<Integer, Integer> father = new HashMap<Integer, Integer>();
	
	// time complexity O(n)
	public int find(int x){
		int parent = father.get(x);
		
		while(parent != father.get(parent)){
			parent = father.get(parent);
		}		
		return parent;
	}
	
	// average time complexity O(1)
	int compressed_find(int x){
		int parent = father.get(x);
		
		while(parent != father.get(parent)){
			parent = father.get(parent);
		}
		
		int tempNode = -1;
		int fa = x;
		
		while(fa != father.get(fa)){    // 将当前node到big parent路径上的所有结点都指向parent
			tempNode = father.get(fa);  // tempNode用于记录当前结点的下一个结点
			father.put(fa, parent);
			fa = tempNode;
		}
		
		return parent;
	}
	
	// time complexity O(n)
	public void union(int x, int y){
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX != parentY){
			father.put(parentX, parentY);
		}
	}
}
