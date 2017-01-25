import java.util.*;

class Order {
	String orderName;
	
	public Order(String orderName) {
		this.orderName = orderName;
	}
}

class OrderDependency {
	Order order;
	Order dependency;
	
	public OrderDependency(Order order, Order dependency) {
		this.order = order;
		this.dependency = dependency;
	}
}


public class P2_Order_Dependency {
	// using topology sort to find out the order sequence
	public ArrayList<Order> findOrder(ArrayList<OrderDependency> dependencies) {
		ArrayList<Order> ans = new ArrayList<>();
		
		if(dependencies == null || dependencies.size() == 0) {
			return ans;
		}
		
		HashMap<String, Order> orders = new HashMap<>();           // save all the orders
		HashMap<String, HashSet<String>> graph = new HashMap<>();  // draw a one direction graph of how the dependencies related
		HashMap<String, Integer> indegree = new HashMap<>();       // keep track how many orders you have to do before doing this one 
		Queue<String> queue = new LinkedList<>();                  // list to record sequence
		
		for(OrderDependency elem : dependencies) {	
			orders.put(elem.order.orderName, elem.order);
			orders.put(elem.dependency.orderName, elem.dependency);
			
			if(!graph.containsKey(elem.order.orderName)) {
				graph.put(elem.order.orderName, new HashSet<String>());
			}
			
			HashSet<String> dependencySet = graph.get(elem.order.orderName);
			
			if(!dependencySet.contains(elem.dependency.orderName)) {
				dependencySet.add(elem.dependency.orderName);
				
				if(indegree.containsKey(elem.dependency.orderName)) {
					indegree.put(elem.dependency.orderName, indegree.get(elem.dependency.orderName) + 1);		
				} else {
					indegree.put(elem.dependency.orderName, 1);
				}				
			}
			
			graph.put(elem.order.orderName, dependencySet);
		}
		
		for(String order : orders.keySet()) {
			if(!indegree.containsKey(order)) {
				queue.offer(order);
			}
		}
		
		while(!queue.isEmpty()) {
			String curOrderName = queue.poll();
			ans.add(orders.get(curOrderName));
			
			if(!graph.containsKey(curOrderName)) {
				continue;
			}
			
			for(String nextOrderName : graph.get(curOrderName)) {
				int count = indegree.get(nextOrderName);
				
				if(count == 1) {
					queue.offer(nextOrderName);
					indegree.remove(nextOrderName);
				} else {
					indegree.put(nextOrderName, count - 1);
				}
			}
		}
		
		return ans.size() == orders.size() ? ans : new ArrayList<Order>();
	}
	
	
	
	
	
	
	
	
	
	/********************************** main function *****************************************/
	
	public static void main(String[] args) {
		P2_Order_Dependency t = new P2_Order_Dependency();	
		ArrayList<OrderDependency> dependencies = new ArrayList<>();
		dependencies.add(new OrderDependency(new Order("D"), new Order("A")));
		dependencies.add(new OrderDependency(new Order("D"), new Order("B")));
		dependencies.add(new OrderDependency(new Order("D"), new Order("C")));
		dependencies.add(new OrderDependency(new Order("C"), new Order("A")));
		dependencies.add(new OrderDependency(new Order("C"), new Order("B")));
		
		ArrayList<Order> ans = t.findOrder(dependencies);
		
		for(Order order : ans) {
			System.out.print(order.orderName + " ");
		}
	}
}