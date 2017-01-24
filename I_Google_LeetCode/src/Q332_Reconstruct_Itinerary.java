import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
/******
 * 
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
Thus, the itinerary must begin with JFK.

Note:
	If there are multiple valid itineraries, you should return the itinerary that has the 
	smallest lexical order when read as a single string. For example, 
	the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

	All airports are represented by three capital letters (IATA code).
	You may assume all tickets form at least one valid itinerary.

Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
	Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * */

public class Q332_Reconstruct_Itinerary {
	/*******************************************************************
	 * (1). 用map建立目的地＋其能去的地点链表的关系。
	 * (2). 对各自目的地链表排序
	 * (3). dfs
	 * 注意：如何在不知道图中总结点树的情况下，用map来dfs遍历一个图的方法
	 *  
	 *******************************************************************/
	
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0){
            return res;
        }
        
        Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();  // 这里必须使用linkedlist, 其有poll() API ！！！
        int len = tickets.length;
        
        for(int i = 0; i < len; ++i){
        	if(map.containsKey(tickets[i][0])){
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	} else{
        		LinkedList<String> tempList = new LinkedList<String>();  // 注意只有linkedlist有poll()！！！
        		tempList.add(tickets[i][1]);
        		map.put(tickets[i][0], tempList);
        	}
        }
        
        for(Map.Entry<String, LinkedList<String>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        Stack<String> stack = new Stack<String>();
        stack.add("JFK");
        
        // 以下是深度优先搜索的写法，必须写成这样；注释部分写法不正确
        // stack不断push之后，stack的peek()是不断变化的
        // 如何在不知道图中总结点树的情况下，用map来dfs遍历一个图的方法：
        while (!stack.empty()) {  
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
            
//            String str = stack.pop();
//            while (map.containsKey(str) && !map.get(str).isEmpty()){
//                stack.push(map.get(str).poll());
//            }
//            res.add(0, str);
        }
        
        return res;
    }
	
	
	
	
	
	
	
	
	
	
	/*********************** main function **************************/
	
	public static void main(String[] args){
		Q332_Reconstruct_Itinerary t = new Q332_Reconstruct_Itinerary();
		String[][] tickets = {
				{"MUC","LHR"},
				{"JFK","MUC"},
				{"SFO","SJC"},
				{"LHR","SFO"}
		};
		List<String> res = t.findItinerary(tickets);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
