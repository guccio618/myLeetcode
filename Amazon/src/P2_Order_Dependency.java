import java.util.*;

public class P2_Order_Dependency {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0){
            return new int[0];
        }
        
        Set<Integer>[] graph = new Set[numCourses];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] ans = new int[numCourses];
        int index = 0;
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] elem : prerequisites){
            if(!graph[elem[1]].contains(elem[0])){
                graph[elem[1]].add(elem[0]);
                map.put(elem[0], map.getOrDefault(elem[0], 0) + 1);
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!map.containsKey(i)){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[index++] = node;
            
            if(graph[node].size() == 0){
                continue;
            }
            
            for(int next : graph[node]){
                int count = map.get(next);
                
                if(count == 1){
                    map.remove(next);
                    queue.offer(next);
                } else {
                    map.put(next, count - 1);
                }
            }
        }
        
        return map.size() == 0 ? ans : new int[0];
    }
}
