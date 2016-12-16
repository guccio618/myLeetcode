import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Li_178_Graph_Valid_Tree {
	/*******************************************************************
	 * visited和canReach的使用方法：
	 * 		visited表示已经作为根结点展开过的结点编号
	 * 		canReach表示在当前访问下，可以到达的结点的范围
	 *  
	 *******************************************************************/
	
	public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0){
            if(n == 1){
                return true;
            } else{
                return false;
            }
        }
    
        HashSet<Integer>[] graph = new HashSet[n];
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();  // 表示已经作为根结点展开过的结点编号
        
        for(int i = 0; i < n; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < edges.length; ++i){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i = 0; i < n; ++i){
            if(graph[i].size() == 0){
                return false;
            } else if(visited.contains(i)){
                continue;
            } else {
                q.offer(i);
                HashSet<Integer> canReach = new HashSet<Integer>();
                
                while(!q.isEmpty()){
                    int index = q.poll();
                    HashSet<Integer> node = graph[index];
                    visited.add(index);
                    
                    for(int next : node){
                        if(visited.contains(next)){
                            continue;
                        } else if(canReach.contains(next)){
                            return false;
                        } else {
                            canReach.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
