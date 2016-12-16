import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Li_127_Topological_Sorting {
	/*******************************************************************
	 * 标准拓扑排序
	 * 	(1). map记录每个结点的的进入路径
	 *  (2). 寻找根结点： 无进入路径的结点
	 *  (3). 开始bfs，并update map中的对应结点的进入路径数
	 *  
	 *******************************************************************/
	
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> ans = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0){
            return ans;
        }
        
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        
        for(DirectedGraphNode node : graph){  // 被当作邻居的此数
            for(DirectedGraphNode n : node.neighbors){
                if(map.containsKey(n)){
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }    
            }
        }
        
        for(DirectedGraphNode node : graph){  // 找出没有被邻居的结点
            if(!map.containsKey(node)){
                ans.add(node);
                q.offer(node);
            }
        }
        
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            
            for(DirectedGraphNode n : node.neighbors){
                if(map.containsKey(n)){
                    int num = map.get(n);
                    if(num == 1){
                        ans.add(n);
                        q.offer(n);
                        map.remove(n);
                    } else {
                        map.put(n, num - 1);
                    }
                }
            }
        }
          
        return ans;      
    }
}
