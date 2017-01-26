import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph_VertexList {
	private class Edge {
		public double cost;
		public int vertex;

		public Edge(int v, double c) {
			cost = c;
			vertex = v;
		}
	}

	private LinkedList<LinkedList<Edge>> edges;
	private int v_num;

	public Graph_VertexList(int V) {
		v_num = V;
		edges = new LinkedList<LinkedList<Edge>>();
		
		for (int i = 0; i < V + 1; ++i) {
			edges.add(new LinkedList<Edge>());
		}
	}

	public void add(int from, int to, double cost) {
		if (from > to) {
			int temp = from;
			from = to;
			to = temp;
		}

		for (Edge e : edges.get(from)) {
			if (e.vertex == to && e.cost == cost) {
				return;
			}
		}
		
		for (Edge e : edges.get(to)) {
			if (e.vertex == from && e.cost == cost){
				return;
			}
		}

		edges.get(from).add(new Edge(to, cost));
		edges.get(to).add(new Edge(from, cost));
	}

	public boolean isAdjacent(int from, int to) {
		for (Edge e : edges.get(from)) {
			if (e.vertex == to) {
				return true;
			}
		}
		
		return false;
	}

	public double getCost(int from, int to) {
		for (Edge e : edges.get(from)) {
			if (e.vertex == to) {
				return e.cost;
			}
		}
		
		return Double.MAX_VALUE;
	}

	/****************** DFS **********************/
	// recursive DFS
	public boolean[] DFS_recursive(int start) {
		boolean[] visited = new boolean[v_num + 1];
		
		for (int i = 0; i < v_num; ++i) {
			visited[i] = false;
		}
		
		DFS(start, visited);
		System.out.println();
		return visited;
	}

	public void DFS(int v, boolean[] visited) {
		if (visited[v] == true){
			return;
		}
		
		visited[v] = true;
		System.out.print(v + ", ");

		for (Edge e : edges.get(v)) {
			if (!visited[e.vertex]) {
				DFS(e.vertex, visited);
			}
		}
	}

	// stack DFS
	public void DFS_stack(int start) {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[v_num + 1];
		
		for (int i = 0; i < v_num; ++i){
			visited[i] = false;
		}
		
		s.push(start);
		visited[start] = true;

		while (!s.isEmpty()) {
			int temp = s.pop();
			System.out.print(temp + ", ");   // doing something

			for (Edge e : edges.get(temp)) {
				if (visited[e.vertex] == false){
					s.push(e.vertex);
					visited[e.vertex] = true;
				}
			}
		}
		
		System.out.println();
	}

	/****************** BFS **********************/
	public void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[v_num + 1];
		
		for (int i = 0; i < v_num; ++i){
			visited[i] = false;
		}
		
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + ", ");

			for (Edge e : edges.get(temp)) {
				if (visited[e.vertex] == false){
					q.add(e.vertex);
				}
			}
		}
		
		System.out.println();
	}

	/****************** isConnect **********************/
	public boolean isConnect() {
		boolean[] visited = DFS_recursive(1);
		
		for (int i = 1; i < visited.length; ++i) {
			if (visited[i] == false){
				return false;
			}
		}
		
		return true;
	}

	/****************** Bellman_Ford **********************/
	// 必须是有向图
	public double Bellman_Ford() {
		double[] dist = new double[v_num + 1];
		dist[1] = 0;

		for (int i = 2; i <= v_num; ++i) {
			dist[i] = Double.MAX_VALUE;
		}

		for (int j = 1; j < v_num; ++j) {
			for (Edge e : edges.get(j)) {
				if (dist[e.vertex] > dist[j] + e.cost) {
					dist[e.vertex] = dist[j] + e.cost;
				}
			}
		}

		return dist[v_num];
	}

	/****************** Bellman_Ford_Path **********************/
	public double Bellman_Ford_Path() {
		double[] dist = new double[v_num + 1];
		int[] path = new int[v_num + 1];
		dist[1] = 0;

		for (int i = 2; i <= v_num; ++i) {
			dist[i] = Double.MAX_VALUE;
		}

		for (int j = 1; j < v_num; ++j) {
			for (Edge e : edges.get(j)) {
				if (dist[e.vertex] > dist[j] + e.cost) {
					dist[e.vertex] = dist[j] + e.cost;
					path[e.vertex] = j;   // path[i]表示来源于结点j
				}
			}
		}

		for (int i = v_num; i >= 1;) {
			System.out.print(i + ", ");
			
			if (i == 1){
				break;
			}
			
			i = path[i];
		}

		System.out.println();
		return dist[v_num];
	}

	/****************** Floyd_Warshall **********************/
	public double Floyd_Warshall() {
		double[][] dist = new double[v_num + 1][v_num + 1];
		for (int i = 1; i <= v_num; ++i)
			for (int j = 1; j <= v_num; ++j) {
				if (i == j){
					dist[i][j] = 0;
				} else {
					dist[i][j] = Double.MAX_VALUE;
				}
			}

		for (int i = 1; i < edges.size(); ++i) {
			for (Edge e : edges.get(i)) {
				dist[i][e.vertex] = e.cost;
			}
		}

		for (int k = 1; k <= v_num; ++k) {
			for (int i = 1; i <= v_num; ++i) {
				for (int j = 1; j <= v_num; ++j) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		return dist[1][v_num];
	}

	/****************** Floyd_Warshall_Path **********************/
	public double Floyd_Warshall_Path() {
		double[][] dist = new double[v_num + 1][v_num + 1];
		int[][] path = new int[v_num + 1][v_num + 1];

		for (int i = 1; i <= v_num; ++i) {
			path[i][i] = i;
		}

		for (int i = 1; i <= v_num; ++i) {
			for (int j = 1; j <= v_num; ++j) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = Double.POSITIVE_INFINITY;
			}
		}

		for (int i = 1; i < edges.size(); ++i) {
			for (Edge e : edges.get(i)) {
				dist[i][e.vertex] = e.cost;
				path[i][e.vertex] = i;
			}
		}

		for (int k = 1; k <= v_num; ++k) {
			for (int i = 1; i <= v_num; ++i) {
				for (int j = 1; j <= v_num; ++j) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = k;
					}
				}
			}
		}

		// for(int i = 1; i <= v_num; ++i){
		// for(int j = 1; j <= v_num; ++j)
		// System.out.print(dist[i][j] + ", ");
		// System.out.println();
		// }

		for (int i = v_num; i >= 1;) {
			System.out.print(i + ", ");
			
			if (i == 1) {
				break;
			}
			
			i = path[1][i];
		}
		
		System.out.println();
		return dist[1][v_num];
	}

	public static void main(String[] args) {
		Graph_VertexList g1 = new Graph_VertexList(6);
		g1.add(1, 2, 1.0);
		g1.add(1, 4, 2.0);
		g1.add(2, 4, 1.0);
		g1.add(2, 3, 2.0);
		g1.add(3, 5, 1.1);
		g1.add(3, 6, 2.3);
		g1.add(4, 5, 0.5);
		g1.add(5, 6, 1.1);

		Graph_VertexList g2 = new Graph_VertexList(6);
		g2.add(1, 2, 2.5);
		g2.add(1, 4, 1.2);
		g2.add(2, 4, 0.6);
		g2.add(2, 3, 2.5);
		g2.add(3, 5, 0.4);
		g2.add(3, 6, 1.3);
		g2.add(4, 5, 0.5);
		g2.add(5, 6, 2.1);

		Graph_VertexList g3 = new Graph_VertexList(5);
		g3.add(1, 2, 2.5);
		g3.add(1, 4, 1.2);
		g3.add(1, 5, 2.0);
		g3.add(2, 4, 0.6);
		g3.add(2, 3, 2.5);
		g3.add(3, 4, 0.4);
		g3.add(3, 5, 1.3);
		g3.add(4, 5, 2.1);

		g1.DFS_recursive(6);
		// g.DFS_stack(6);
		// g.BFS(6);
		//
		// System.out.println(g.isConnect());

		System.out.println("Bellman_Ford_Path: smallest cost is "
				+ g1.Bellman_Ford_Path());
		System.out.println("Floyd_Warshall_Path: smallest cost is "
				+ g1.Floyd_Warshall_Path());
	}
}
