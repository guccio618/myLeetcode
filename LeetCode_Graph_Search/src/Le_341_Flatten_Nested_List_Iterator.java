import java.util.*;


/*******************************************************************************************************
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 * 
 *******************************************************************************************************/

// 此题为dfs, 通常考虑用stack来完成

public class Le_341_Flatten_Nested_List_Iterator {
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        int sum = 0;
        int totalLevel = 1;
        Queue<Pair> queue = new LinkedList();
        List<Pair> list = new ArrayList();
        
        for(NestedInteger node : nestedList) {
            queue.offer(new Pair(node, 1));
        }
        
        while(!queue.isEmpty()) {
            Pair n = queue.poll();
            NestedInteger current = n.node;
            totalLevel = Math.max(totalLevel, n.level);
            
            if(current.isInteger()) {
                list.add(n);
            } else {
                for(NestedInteger next : current.getList()) {
                    queue.offer(new Pair(next, n.level + 1));
                }
            }
        }
        
        for(Pair n : list) {
            sum += n.node.getInteger() * (totalLevel - n.level + 1);
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
	
	
	private Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public Le_341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return ;
        }
        
        for(int i = nestedList.size() - 1; i >= 0; i--){   // 因为是栈，因此从最后一个开始往stack里存
            stack.push(nestedList.get(i));
        }
    }

//    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

//    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger current = stack.peek();
            if(current.isInteger() == true){
                return true;
            }
            
            stack.pop();
            List<NestedInteger> curList = current.getList();
            
            for(int i = curList.size() - 1; i >= 0; i--){
                stack.push(curList.get(i));
            }
        }
        
        return false;
    }
}

