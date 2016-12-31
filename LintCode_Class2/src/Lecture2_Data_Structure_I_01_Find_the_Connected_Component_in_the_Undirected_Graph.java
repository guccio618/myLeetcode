import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class Lecture2_Data_Structure_I_01_Find_the_Connected_Component_in_the_Undirected_Graph {
	// by Jackie
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0){
            return res;
        }
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        int size = nodes.size();
        
        for(int i = 0; i < size; ++i){
            UndirectedGraphNode node = nodes.get(i);
            if(visited.contains(node)){
                continue;
            }
            q.add(node);
            visited.add(node);
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(!q.isEmpty()){
                UndirectedGraphNode n = q.poll();
                list.add(n.label);
                for(UndirectedGraphNode neighbor : n.neighbors){
                    if(visited.contains(neighbor)){
                        continue;
                    }
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
