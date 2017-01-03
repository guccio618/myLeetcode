import java.util.List;
import java.util.Stack;
/*******
 * 
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
	Given the list [[1,1],2,[1,1]],

	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
	Given the list [1,[4,[6]]],

	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
	
 * 
 * 
 * */

public class Le_341_Flatten_Nested_List_Iterator {
	private Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public Le_341_Flatten_Nested_List_Iterator(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return ;
        }
        
        for(int i = nestedList.size() - 1; i >= 0; i--){
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
	
    
    
    
//    public static void main(String[] args){
//    	List<NestedInteger> list = new ArrayList<NestedInteger>();
//    	NestedInteger
//    	
//    	Q341_Flatten_Nested_List_Iterator t = new Q341_Flatten_Nested_List_Iterator();
//    	
//    }
    
    
	
//	// by Jackie
//	public void flatten(TreeNode root) {
//        if(root == null) {
//        	return;
//        }
//        
//        Stack<TreeNode> s = new Stack<TreeNode>();
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//    
//        while(root != null || !s.isEmpty()){
//            while(root != null){
//                s.push(root);
//                q.offer(root);
//                root = root.left;
//            }
//            root = s.pop();
//            root = root.right;
//        }
//        
//        root = q.poll();
//        while(!q.isEmpty()){
//            root.left = null;
//            root.right = q.poll();
//            root = root.right;
//        }
//    }
}
