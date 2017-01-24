import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class P2_MST_Kruskal {
	// by implementing the Kruskal Algorithm and with help of Union Find
	// structure
	// find the all possible low cost ways to connect those cities
	public ArrayList<Connection> connect(ArrayList<Connection> connections) {	
		ArrayList<Connection> ans = new ArrayList<Connection>();
		
		if (connections == null || connections.size() == 0) {
			return ans;
		}
	
		HashMap<String, Integer> map = new HashMap<>();
		int cityCount = 0;
		int connectCount = 0;
		
		for (Connection c : connections) {			
			if (!map.containsKey(c.city1)) {
				map.put(c.city1, cityCount++);
			}
			
			if (!map.containsKey(c.city2)) {
				map.put(c.city2, cityCount++);
			}
		}
		
		Collections.sort(connections, new Comparator<Connection>() {
			@Override
			public int compare(Connection a, Connection b) {
				return a.cost - b.cost;
			}
		});
		
		int[] uf = new int[cityCount];
		
		for (int i = 0; i < uf.length; i++) {
			uf[i] = i;
		}		
		
		for (Connection c : connections) {
			int cityIndex1 = map.get(c.city1);
			int cityIndex2 = map.get(c.city2);
			int parent1 = find(uf, cityIndex1);
			int parent2 = find(uf, cityIndex2);
			
			if (parent1 != parent2) {
				connectCount++;
				ans.add(c);
				uf[parent1] = parent2; // union
			}

			if (connectCount + 1 == cityCount) {  // 注意这里的退出条件 ！！！
				break;
			}
		}

		Collections.sort(ans, new Comparator<Connection>() {
			@Override
			public int compare(Connection c1, Connection c2) {
				if (!c1.city1.equals(c2.city1)) {
					return c1.city1.compareTo(c2.city1);			
				} else {
					return c1.city2.compareTo(c2.city2);
				}
			}
		});
		
		return connectCount + 1 == cityCount ? ans : null; // pay attention!!!!!  null
	}
	
	public static int find(int[] father, int x) {		
		while (x != father[x]) {
			father[x] = father[father[x]]; // path compression,for performance improve
			x = father[x];
		}
		
		return x;
	}
	
		
//	public static int find(int[] father, int x) {			
//		int parent = x;
//		
//		while(parent != father[parent]) {
//			parent = father[parent];
//		}
//		
//		int temp = -1; 
//		int fa = x;
//		
//		while(fa != father[fa]) {
//			temp = father[fa];
//			father[fa] = parent;
//			fa = temp;
//		}
//		
//		return parent;
//	}
	
	
	
	
	
	
	
	/*********************** main function***************************/
	public static void main(String[] args) {
		P2_MST_Kruskal kruskal = new P2_MST_Kruskal();
		ArrayList<Connection> list = new ArrayList<>();

		Connection c1 = new Connection("A", "B", 1);
		Connection c2 = new Connection("A", "D", 9);
		Connection c3 = new Connection("A", "C", 6);
		Connection c4 = new Connection("B", "D", 3);
		Connection c5 = new Connection("B", "E", 8);
		Connection c6 = new Connection("D", "E", 24);
		Connection c7 = new Connection("C", "E", 2);
		Connection c8 = new Connection("A", "B", 2);

		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		list.add(c7);
		list.add(c8);

		System.out.println(kruskal.connect(list));
	}
}
