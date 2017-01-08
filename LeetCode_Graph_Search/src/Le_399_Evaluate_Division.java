import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/********
 * 
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 * 
 * */

public class Le_399_Evaluate_Division {
	// using DFS
	private Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
	private Map<String, Double> resultMap = new HashMap<String, Double>();
	
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(equations == null || values == null || queries == null || queries.length == 0 || equations.length != values.length){
        	return new double[0];
        }
        
        int len = equations.length;
        double[] ans = new double[queries.length];
        
        // build graph
        for(int i = 0; i < len; i++){
        	if(!graph.containsKey(equations[i][0])){
        		graph.put(equations[i][0], new HashSet<String>());
        	}
        	graph.get(equations[i][0]).add(equations[i][1]);
        	
        	if(!graph.containsKey(equations[i][1])){
        		graph.put(equations[i][1], new HashSet<String>());
        	}
        	graph.get(equations[i][1]).add(equations[i][0]);
        	
        	resultMap.put(equations[i][0] + "/" + equations[i][1], values[i]);
        	resultMap.put(equations[i][1] + "/" + equations[i][0], 1.0 / values[i]);
        }
        
        for(int i = 0; i < queries.length; i++){
        	ans[i] = DFS(queries[i][0], queries[i][1], 1, new HashSet<String>());
        }
        
        return ans;
    }
    
    public double DFS(String start, String end, double sum, Set<String> visited){		
		if(!graph.containsKey(start)){
			return -1.0;
		} else if(start.equals(end)){
			return 1.0;
		} else if(resultMap.containsKey(start + "/" + end)){
			return sum * resultMap.get(start + "/" + end);
		} 
 		
		visited.add(start);
		double result = -1.0;		
		
		for(String next : graph.get(start)){			
			if(!visited.contains(next)){			
				if(resultMap.containsKey(start + "/" + next)){
					result = DFS(next, end, sum * resultMap.get(start + "/" + next), visited);
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
