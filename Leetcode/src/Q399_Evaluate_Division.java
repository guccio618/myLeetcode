import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Q399_Evaluate_Division {
	private Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
	private Map<String, Double> map = new HashMap<String, Double>();
	
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        if(equations == null || values == null || query == null || query.length == 0 || equations.length != values.length){
        	return new double[0];
        }
        
        int len = equations.length;
        double[] ans = new double[query.length];
        
        for(int i = 0; i < len; i++){
        	if(!graph.containsKey(equations[i][0])){
        		graph.put(equations[i][0], new HashSet<String>());
        	}
        	graph.get(equations[i][0]).add(equations[i][1]);
        	
        	if(!graph.containsKey(equations[i][1])){
        		graph.put(equations[i][1], new HashSet<String>());
        	}
        	graph.get(equations[i][1]).add(equations[i][0]);
        	
        	map.put(equations[i][0] + ":" +equations[i][1], values[i]);
        	map.put(equations[i][1] + ":" +equations[i][0], 1.0 / values[i]);
        }
        
        for(int i = 0; i < query.length; i++){
        	Set<String> visited = new HashSet<String>();
        	ans[i] = DFS(query[i][0], query[i][1], 1, visited);
        }
        
        return ans;
    }
    
    public double DFS(String start, String end, double sum, Set<String> visited){		
		if(!graph.containsKey(start)){
			return -1.0;
		} else if(start.equals(end)){
			return 1.0;
		} else if(map.containsKey(start + ":" + end)){
			return sum * map.get(start + ":" + end);
		} 
 		
		visited.add(start);
		double result = -1.0;		
		
		for(String next : graph.get(start)){			
			if(!visited.contains(next)){			
				if(map.containsKey(start + ":" + next)){
					result = DFS(next, end, sum * map.get(start + ":" + next), visited);
				} 
				
				if(result != -1.0){
					return result;
				}
			}
		}
		
		visited.remove(start);
		return result;
	}
}
