import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/******
 * 
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0.
So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * */

public class Q207_Course_Schedule {
	/*******************************************************************
	 * (1). 建图
	 * (2). 拓扑排序
	 *  
	 *******************************************************************/
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) {
            return true;
        }
        
        Set<Integer>[] graph = new Set[numCourses];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int[] prerequisite : prerequisites) {
            if(graph[prerequisite[1]] == null) {
                graph[prerequisite[1]] = new HashSet<Integer>();
            }
            
            if(!graph[prerequisite[1]].contains(prerequisite[0])) {
                graph[prerequisite[1]].add(prerequisite[0]);
                map.put(prerequisite[0], map.getOrDefault(prerequisite[0], 0) + 1);
            }
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(!map.containsKey(i)) {
                queue.offer(i);
            }
        }
        
        if(queue.isEmpty()){
            return false;
        }
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            if(graph[node] == null) {
                continue;
            }
            
            for(int next : graph[node]) {
                int count = map.get(next);
                
                if(count == 1) {
                    map.remove(next);
                    queue.offer(next);
                } else {
                    map.put(next, count - 1);
                }
            }
        }
        
        return map.size() == 0;
    }
	
	
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites.length == 0 || numCourses <= 0){
            return true;
        }
    
        HashSet<Integer>[] graph = new HashSet[numCourses];
        int n = prerequisites.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<HashSet> q = new LinkedList<HashSet>();
        
        for(int i = 0; i < numCourses; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int i = 0; i < n; ++i){
            if(!graph[prerequisites[i][1]].contains(prerequisites[i][0])){  // 必须要判断contains，防止[1,9][1,9]此类的重复出现
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
                
                // 这么写也可以，表示有效的前置课的情况；或者就是遍历每个结点下的每个邻居，同标准拓扑排序一样
                if(!map.containsKey(prerequisites[i][0])){
                    map.put(prerequisites[i][0], 1);
                } else {
                    map.put(prerequisites[i][0], map.get(prerequisites[i][0]) + 1);
                }
            }
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(!map.containsKey(i)){
                q.offer(graph[i]);
            }
        }
        
        if(q.isEmpty()){
            return false;
        }
        
        while(!q.isEmpty()){
            HashSet<Integer> node = q.poll();
            for(int nextClass : node){
                if(map.containsKey(nextClass)){
                    int num = map.get(nextClass);
                    if(num == 1){
                        q.offer(graph[nextClass]);
                            map.remove(nextClass);
                    } else {
                        map.put(nextClass, num - 1);
                    }
                }
            }
        }
        
        return map.size() == 0;
    }
}	
