import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Lecture9_Graph_Search_02_Clone_Graph {
	/*************************************************************
	 * 用dfs实现联通快的问题； 而bfs通常可以用于求最短路径的问题； 
	 * 如果一个图有n个点, n-1条边，即为树
	 * 	1. 用dfs来完成深拷贝
	 * 	2. copy node
	 * 	3. copy edges
	 **************************************************************/
	
	// non_recursion
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q1 = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q2 = new LinkedList<UndirectedGraphNode>();
        q1.add(node);
        q2.add(newRoot);
        
        while(!q1.isEmpty()){
            UndirectedGraphNode oldNode = q1.poll();
            UndirectedGraphNode newNode = q2.poll();
            map.put(newNode.label, newNode);
            
            for(UndirectedGraphNode n : oldNode.neighbors){
                if(!map.containsKey(n.label)){
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(n.label);
                    newNode.neighbors.add(newNeighbor);
                    map.put(n.label, newNeighbor);
                    q1.offer(n);    // offer在当queue的capacity满了之后会返回false，而不会抛出exception； add会抛出exception   
                    q2.offer(newNeighbor);
                } else{
                    newNode.neighbors.add(map.get(n.label));
                }
            }
        }
        
        return newRoot;
	}
	
	
	// recursion
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        
        dfsHelper(node, copy, map);
        return copy;
    }
    
    public void dfsHelper(UndirectedGraphNode node, UndirectedGraphNode copy, Map<Integer, UndirectedGraphNode> map){
        map.put(copy.label, copy);
        
        for(UndirectedGraphNode n : node.neighbors){
            if(!map.containsKey(n.label)){
               UndirectedGraphNode newCopy = new UndirectedGraphNode(n.label);
               dfsHelper(n, newCopy, map);
               copy.neighbors.add(newCopy);
            } else{
                copy.neighbors.add(map.get(n.label));
            }
        }
    }
}
