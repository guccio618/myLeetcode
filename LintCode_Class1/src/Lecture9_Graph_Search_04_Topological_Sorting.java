import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Lecture9_Graph_Search_04_Topological_Sorting {
	/*************************************************************
	 * 1. 先从arraylist里找出root，即没有上级结点的结点
	 * 2. 运用bfs遍历，当上级结点为0时，加入队列
	 **************************************************************/
	
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {            // 记录所有结点的上级结点数
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {           // 找出root结点
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        
        while (!q.isEmpty()) {              // BFS遍历
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {      // 当上级结点数为0时候，加入队列，并加入res
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
	}
}
