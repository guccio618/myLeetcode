import java.util.*;

public class P2_MST {
	public List<Connection> getSmallestCost(List<Connection> list){
		List<Connection> ans = new ArrayList<Connection>();
		
		if(list == null || list.size() == 0){
			return ans;
		}
		
		Map<String, Integer> citySet = new HashMap<String, Integer>();
		int index = 0;
		
		Collections.sort(list, new Comparator<Connection>() {
			public int compare(Connection p1, Connection p2){
				return p1.cost - p2.cost;
			}
		});
		
		for(Connection c : list){
			if(!citySet.containsKey(c.city1)){
				citySet.put(c.city1, index++);
			} 
			
			if(!citySet.containsKey(c.city2)){
				citySet.put(c.city2, index++);
			}
		}
		
		UnionFind uf = new UnionFind(citySet);
		
		for(Connection c : list){
			int id1 = citySet.get(c.city1);
			int id2 = citySet.get(c.city2);
			
			int parent1 = uf.find(id1);
			int parent2 = uf.find(id2);
			
			if(parent1 != parent2){
				ans.add(c);
				uf.union(id1, id2);
			}
		}
		
		int commonParent = uf.find(0);
		
		for(String city : citySet.keySet()){
			int id = citySet.get(city);
			
			if(commonParent != uf.find(id)){
				System.out.println("null");
				return null;
			}
		}
				
		Collections.sort(ans, new Comparator<Connection>() {
			public int compare(Connection p1, Connection p2){
				if(!p1.city1.equals(p2.city1)){
					return p1.city1.compareTo(p2.city1);
				} else {
					return p1.city2.compareTo(p2.city2);
				}
			}
		});
		
		return ans;
	}
	
	class UnionFind {
		private Map<Integer, Integer> father = new HashMap<Integer, Integer>();
		
		public UnionFind(Map<String, Integer> citySet){
			for(String city : citySet.keySet()){				
				int id = citySet.get(city);				
				father.put(id, id);
			}
		}
		
		public int find(int x){
			int parent = father.get(x);
			
			while(parent != father.get(parent)){
				parent = father.get(parent);
			}
			
			int tempFa = -1;
			int fa = x;
			
			while(fa != father.get(fa)) {
				tempFa = father.get(fa);
				father.put(fa, parent);
				fa = tempFa;
			}
			
			return parent;
		} 
		
		public void union(int x, int y){
			int parent1 = father.get(x);
			int parent2 = father.get(y);
			
			if(parent1 != parent2){
				father.put(parent1, parent2);
			}
		}
	}
	
	
	
	
	
	public List<Connection> findPath (List<Connection> list) {
        ArrayList<Connection> result = new ArrayList<Connection> ();
        ArrayList<String> cityTree = new ArrayList<String> ();        //to Maintain the cities have been traversed.

        while (!list.isEmpty()) {
                //find the minimum cost to the city from cityTree among the result.
                Connection temp = findMin(list, cityTree);
                if (temp == null) {// we finished
                        break;
                }
                list.remove(temp);        //remove the current minimum cost from grand set
                cityTree.add(temp.city1);
                cityTree.add(temp.city2);
                result.add(temp);
        }
        //override compare make it alphabet order
        Comparator<Connection> cmp = new Comparator<Connection>(){
                public int compare(Connection c1, Connection c2) {
                        if (c1.city1.equals(c2.city1)) {
                                return c1.city2.compareTo(c2.city2);
                        }
                        return c1.city1.compareTo(c2.city1);
                }};
        result.sort(cmp);

        return result;
}

//find the minimum cost between the city we traversed and we did not traverse.
public static Connection findMin(List<Connection> list, ArrayList<String> cityTree) {
        Connection result = null;
        int minCost = Integer.MAX_VALUE;        //minimum cost

        for (Connection con : list) {
                if (con.cost <= minCost) {
                        //if none of the city we traversed 
                        //or the connection is connected to either city from cityTree.
                        if ((cityTree.contains(con.city1) && !cityTree.contains(con.city2)) ||
                                        cityTree.contains(con.city2) && !cityTree.contains(con.city1)) {
                                minCost = con.cost;
                                result = con;
                        }
                        if (cityTree.isEmpty()) {
                                minCost = con.cost;
                                result = con;
                        }
                }
        }

        return result;
}

	
	
	
	public static void main(String[] args){
		List<Connection> list = new ArrayList<Connection>();
//		list.add(new Connection("fuzhou", "xiamen", 200));
//		list.add(new Connection("xiamen", "guangzhou", 300));
//		list.add(new Connection("hangzhou", "fuzhou", 500));
//		list.add(new Connection("hangzhou", "xiamen", 500));
//		list.add(new Connection("hangzhou", "guangzhou", 600));
//		list.add(new Connection("hangzhou", "shanghai", 200));
//		list.add(new Connection("fuzhou", "shanghai", 800));
//		list.add(new Connection("shanghai", "tianjin", 800));
//		list.add(new Connection("tianjin", "beijing", 100));
//		list.add(new Connection("beijing", "hangzhou", 900));
//		list.add(new Connection("tianjin", "hangzhou", 800));
		
		
		list.add(new Connection("A","B",6));
		list.add(new Connection("A","D",1));
		list.add(new Connection("A","E",5));
		list.add(new Connection("B","C",3));
		list.add(new Connection("B","D",5));
		list.add(new Connection("C","D",6));
		list.add(new Connection("C","F",6));
		list.add(new Connection("D","F",4));
		list.add(new Connection("D","E",5));
		list.add(new Connection("E","F",2));
		
		
		P2_MST t = new P2_MST();
		List<Connection> ans1 = t.getSmallestCost(list);
		
		for(Connection c : ans1){
			System.out.println("[" + c.city1 + "] -> [" + c.city2 + "]: " + c.cost);
		}
		System.out.println();
		
		
		
		
		List<Connection> ans2 = t.findPath(list);
		
		for(Connection c : ans2){
			System.out.println("[" + c.city1 + "] -> [" + c.city2 + "]: " + c.cost);
		}
	}
	
	
}


