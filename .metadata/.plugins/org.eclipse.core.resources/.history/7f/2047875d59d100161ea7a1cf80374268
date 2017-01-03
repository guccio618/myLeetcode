import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/*****
 * 
Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to find the number of 
connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 * 
 * */

public class Q323_Number_of_Connected_Components_in_an_Undirected_Graph {
	public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            return 0;
        }
        
        Set<Integer>[] graph = new Set[n];
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                BFS(graph, i, visited);
            }
        }
        
        return count;
    }
    
    public void BFS(Set<Integer>[] graph, int root, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int nextNode : graph[node]) {
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(nextNode);
                }
            }
        }
    }
	
    
    
	
	
	
    
    
    
    
    
    /***********************************************/
	// by Jackie using union find
	public int countComponents3(int n, int[][] edges) {
        if(n <= 0){
            return 0;
        } else if(edges == null || edges.length == 0 || edges[0].length == 0){
            return n;
        }
        
        Union_Find uf = new Union_Find(n);
        int len = edges.length;
        Set<Integer> reach = new HashSet<Integer>();
        int count = 0;
        
        for(int i = 0; i < len; i++){
            uf.union(edges[i][0], edges[i][1]);
        }
        
        for(int i = 0; i < n; i++){
            int parent = uf.compress_find(i);
            if(reach.contains(parent)){
                continue;
            } else {
                count++;
                reach.add(parent);
            }
        }
        
        return count;
    }
    
    class Union_Find{
        Map<Integer, Integer> father = new HashMap<Integer, Integer>();
        
        public Union_Find(int n){
            for(int i = 0; i < n; i++){
                father.put(i, i);
            }
        }
        
        public int compress_find(int x){
            int parent = father.get(x);
            
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            
            int temp = -1;
            int fa = x;
            
            while(fa != father.get(fa)){
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            
            return parent;
        }
        
        public void union(int x, int y){
            int fa_x = compress_find(x);     // 注意这里用的是compress_find(x)而不是直接father.get(x) !!!
            int fa_y = compress_find(y);
            
            if(fa_x != fa_y){
                father.put(fa_x, fa_y);
            }
        }
    }
}
