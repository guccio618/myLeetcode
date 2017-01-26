import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/******
 * 
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
	Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
	Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, 
	and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 * 
 * */

public class Q339_Nested_List_Weight_Sum {
	/****************************************************
	 * 这里有level的概念，因此考虑用层序遍历
	 * 
	 ****************************************************/
	// solution 1: using recursion
	public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int totalSum = 0;
        
        for(NestedInteger elem : nestedList) {
            totalSum += DFS(elem, 1);
        }
        
        return totalSum;
    }
    
    public int DFS(NestedInteger node, int level) {
        if(node.isInteger() == true) {
            return node.getInteger() * level;
        }
        
        int sum = 0;
        
        for(NestedInteger elem : node.getList()) {
            sum += DFS(elem, level + 1);
        }
        
        return sum;
    }
	
	
    
    // solution 2: using iterator
    public int depthSum2(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        Queue<Pair> queue = new LinkedList();
        int sum = 0;
        
        for(NestedInteger elem : nestedList) {
            queue.offer(new Pair(elem, 1));
        }
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            
            if(p.node.isInteger()) {
                sum += p.node.getInteger() * p.level; 
            } else {
                for(NestedInteger next : p.node.getList()) {
                    queue.offer(new Pair(next, p.level + 1));
                }
            }
        }
        
        return sum;
    }
    
    class Pair {
        NestedInteger node;
        int level;
        
        public Pair(NestedInteger node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    
    
    
    
    
    
    
    /******************* class *******************/
    
    class NestedInteger{
    	int val;
    	List<NestedInteger> list;
    	
    	public NestedInteger(int v){
    		val = v;
    		list = null;
    	}
    	
    	public NestedInteger(List<NestedInteger> l){
    		list = l;
    	}
    	
    	public boolean isInteger(){
    		return list == null;
    	}
    	
    	public int getInteger(){
    		return val;
    	}
    	
    	public List<NestedInteger> getList(){
    		return list;
    	}
    }
}
