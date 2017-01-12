import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q127_Topological_Sorting {
	// by ninechapter
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				if (map.containsKey(neighbor)) {
					map.put(neighbor, map.get(neighbor) + 1);
				} else {
					map.put(neighbor, 1);
				}
			}
		}

		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		for (DirectedGraphNode node : graph) {
			if (!map.containsKey(node)) {
				q.offer(node);
				result.add(node);
			}
		}

		while (!q.isEmpty()) {
			DirectedGraphNode node = q.poll();
			for (DirectedGraphNode n : node.neighbors) {
				map.put(n, map.get(n) - 1);
				if (map.get(n) == 0) {
					result.add(n);
					q.offer(n);
				}
			}
		}
		return result;
	}

	public ArrayList<DirectedGraphNode> topSort2(
			ArrayList<DirectedGraphNode> graph) {
		if (graph == null || graph.size() == 1) {
			return graph;
		}

		Set<DirectedGraphNode> neighborSet = new HashSet<DirectedGraphNode>();
		for (DirectedGraphNode node : graph) {
			neighborSet.addAll(node.neighbors);
		}

		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		ArrayList<DirectedGraphNode> copyGraph = new ArrayList<DirectedGraphNode>();
		copyGraph.addAll(graph);

		for (DirectedGraphNode node : graph) {
			if (!neighborSet.contains(node)) {
				res.add(node);
				copyGraph.remove(node);
			}
		}
		ArrayList<DirectedGraphNode> remaining = topSort(copyGraph);
		res.addAll(remaining);
		return res;
	}
}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}
