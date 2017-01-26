import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*****
 * 
Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to check whether these 
edges make up a valid tree.

For example:
	Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
	Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
	
 * 
 * */

public class Le_261_Graph_Valid_Tree {
	// using BFS
	public boolean validTree(int n, int[][] edges) {
        if(n <= 0){
            return false;
        }
        
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        queue.offer(0);
        visited.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();

            if(graph[node].size() == 0){
                continue;
            }
            
            for(int nextNode : graph[node]){
                if(visited.contains(nextNode)){
                    return false;
                }
                
                visited.add(nextNode);
                queue.offer(nextNode);
                graph[nextNode].remove(node);   // 注意这里是nextNode remove node !!!
            }
        }
        
        return visited.size() == n;
    }
	
	
	
	
	
	
	
	
	
	/*************************** main function ********************************/
	
	// by Jackie using BFS
	public boolean validTree2(int n, int[][] edges) {
        if(n <= 0){
            return true;
        }
        
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            if(visited.contains(i)){
                continue;
            } else if(bfs(graph, i, visited) == false){
                return false;
            }
            count++;
        }
        
        return count == 1;
    }
    
    public boolean bfs(Set<Integer>[] graph, int root, Set<Integer> visited){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(root);
        Set<Integer> canReach = new HashSet<Integer>();
        
        while(!q.isEmpty()){
            int num = q.poll();
            Set<Integer> node = graph[num];
            visited.add(num);
            
            for(int n : node){
                if(visited.contains(n)){
                    continue;
                }
                if(canReach.contains(n)){
                    return false;
                }
                canReach.add(n);
                q.offer(n);
            }
        }
             
        return true;
    }
	
	
	// by ninechapter
//	public boolean validTree(int n, int[][] edges) {
//		if(edges == null || edges.length == 0){
//            if(n == 1){
//                return true;
//            } else{
//                return false;
//            }
//        }
//        
//		Node[] nodes = new Node[n];
//		Queue<Node> q = new LinkedList<Node>();
//		HashSet<Integer> visited = new HashSet<Integer>();
//		
//		for(int row = 0; row < edges.length; ++ row){
//			if(nodes[edges[row][0]] == null){
//				nodes[edges[row][0]] = new Node(edges[row][0]);
//			}
//			nodes[edges[row][0]].neighbor.add(edges[row][1]);
//			
//			if(nodes[edges[row][1]] == null){
//				nodes[edges[row][1]] = new Node(edges[row][1]);
//			}
//			nodes[edges[row][1]].neighbor.add(edges[row][0]);
//		}
//		
//		for(int i = 0; i < n; ++i){
//		    if(nodes[i] == null){
//				return false;
//			} else if(visited.contains(i)){
//				continue;
//			}
//			
//			q.add(nodes[i]);
//			HashSet<Integer> canReach = new HashSet<Integer>();
//			while(!q.isEmpty()){
//				Node temp = q.poll();
//				visited.add(temp.label);
//
//				for(int nextIndex : temp.neighbor){
//					if(visited.contains(nextIndex)){
//						continue;
//					} 
//					if(canReach.contains(nextIndex)){
//						return false;
//					}
//					q.add(nodes[nextIndex]);
//					canReach.add(nextIndex);
//				}
//			}
//		}
//		
//		return true;
//	}
//	
//	class Node{
//		int label;
//		HashSet<Integer> neighbor;
//		
//		public Node(int l){
//			label = l;
//			neighbor = new HashSet<Integer>();
//		}
//	}
}
