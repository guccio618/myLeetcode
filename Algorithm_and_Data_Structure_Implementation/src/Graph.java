import java.util.*;


public class Graph {
	public void buildGraph(int[][] edges, Set<Integer>[] graph) {
		for(int[] edge : edges) {
			if(graph[edge[0]] == null) {
				graph[edge[0]] = new HashSet<Integer>();
			}			
			graph[edge[0]].add(edge[1]);
			
			if(graph[edge[1]] == null) {
				graph[edge[1]] = new HashSet<Integer>();
			}			
			graph[edge[1]].add(edge[0]);
		}
	}
	
	
	public void DFS(int[][] edges, int vetexCount, int root) {
		Set<Integer>[] graph = new Set[vetexCount];
		buildGraph(edges, graph);
		
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root);
		visited.add(root);
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			System.out.print(node + ", ");
			
			for(int neighbor : graph[node]) {
				if(visited.contains(neighbor)) {
					continue;
				}
				
				visited.add(neighbor);
				stack.push(neighbor);
			}
		}
		
		System.out.println();
	}
	
	
	public void BFS(int[][] edges, int vetexCount, int root) {
		Set<Integer>[] graph = new Set[vetexCount];
		buildGraph(edges, graph);
		
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(root);
		visited.add(root);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + ", ");
			
			for(int neighbor : graph[node]) {
				if(visited.contains(neighbor)) {
					continue;
				}
				
				visited.add(neighbor);
				queue.offer(neighbor);
			}
		}
		
		System.out.println();
	}
	
	
	public boolean isConnect(int[][] edges, int vetexCount) {
		Set<Integer>[] graph = new Set[vetexCount];
		buildGraph(edges, graph);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		
		queue.offer(0);   // pick up any vetex
		visited.add(0);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			if(graph[node] == null) {
				continue;
			}
			
			for(int neighbor : graph[node]) {
				if(visited.contains(neighbor)) {
					continue;
				}
				
				visited.add(neighbor);
				queue.offer(neighbor);
			}
		}
		
		return visited.size() == vetexCount;
	}
	
	
	public void topologySort(int vetexCount, int[][] edges) {
		Set<Integer>[] graph = new Set[vetexCount];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int[] edge : edges) {
			if(graph[edge[0]] == null) {
				graph[edge[0]] = new HashSet<Integer>();
			}		
			
			if(!graph[edge[0]].contains(edge[1])) {
				graph[edge[0]].add(edge[1]);
				map.put(edge[1], map.getOrDefault(edge[1], 1) + 1);
			}
		}
		
		for(int i = 0; i < vetexCount; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + ", ");
			
			if(graph[node] == null) {
				continue;
			}
			
			for(int nextNode : graph[node]) {
				int count = map.get(nextNode);
				
				if(count == 1) {
					queue.offer(nextNode);
					map.remove(nextNode);   // optional					
				} else {
					map.put(nextNode, count - 1);
				}
			}
		}
	}
	
	
	
	/**
	 *          0
	 *       /  |  \
	 *     1    2    3
	 *    / \  / \  / \
	 *   4  5  6 7  8  9
	 * */
	
	public static void main(String[] args) {
		Graph t = new Graph();
		
		int vetexCount = 10;
		int[][] edges = {
				{0,1}, {0,2}, {0,3}, 
				{1,4}, {1,5},
				{2,6},{2,7},
				{3,8},{3,9}
		};
		
		System.out.println("DFS: ");
		t.DFS(edges, vetexCount, 0);
		System.out.println("BFS: ");
		t.BFS(edges, vetexCount, 0);
		System.out.println("is connect: " + t.isConnect(edges, vetexCount));
		System.out.println("topology sort: ");
		t.topologySort(vetexCount, edges);
	}
}
