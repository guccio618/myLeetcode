import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Lecture2_Data_Structure_I_06_Graph_Valid_Tree {
	private HashSet<Integer> visited;
    
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0){
            if(n == 1){
                return true;
            } else{
                return false;
            }
        }
        
        int edgeNum = edges.length;
        Node[] nodes = new Node[n];
        visited = new HashSet<Integer>();
        
        for(int i = 0; i < edgeNum; ++i){
        	if(nodes[edges[i][0]] == null){
        		nodes[edges[i][0]] = new Node(edges[i][0]);
        	}
        	nodes[edges[i][0]].neighbor.add(edges[i][1]);
        	
        	if(nodes[edges[i][1]] == null){
        		nodes[edges[i][1]] = new Node(edges[i][1]);
        	}
        	nodes[edges[i][1]].neighbor.add(edges[i][0]);
        }
        
        for(int i = 0; i < n; ++i){
            if(visited.contains(nodes[i])){
                continue;
            }
            if(nodes[i] == null || bfs(nodes, i) == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean bfs(Node[] nodes, int index){
        Queue<Node> q = new LinkedList<Node>();
        q.add(nodes[index]);
        HashSet<Integer> canReach = new HashSet<Integer>();
        
        while(!q.isEmpty()){
            Node n = q.poll();
            visited.add(n.val);
        
            for(int nextIndex : n.neighbor){
            	if(visited.contains(nodes[nextIndex].val)){
            		continue;
            	}
                if(canReach.contains(nodes[nextIndex].val)){
                    return false;
                }
                q.add(nodes[nextIndex]); 
                canReach.add(nodes[nextIndex].val);
            }
        }     
        return true;
    }
    
    class Node{
        int val;
        HashSet<Integer> neighbor;
        public Node(int v){
            val = v;
            neighbor = new HashSet<Integer>();
        }
    }
}
