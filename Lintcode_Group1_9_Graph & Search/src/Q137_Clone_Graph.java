import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Q137_Clone_Graph {
	/********************************************************/
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
	                    q1.add(n);
	                    q2.add(newNeighbor);
	                } else{
	                    newNode.neighbors.add(map.get(n.label));
	                }
	            }
	        }
	        
	        return newRoot;
		}
		
		
		
	/********************************************************/	
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


class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
