import java.util.Stack;


public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
	// by other using stack, space O(n)
	public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length <= 1){
            return true;
        } 
        
        Stack<Integer> stack = new Stack<Integer>();
        int currentLow = Integer.MIN_VALUE;
        
        for(int node : preorder){
            if(node < currentLow){
                return false;
            }
            while(!stack.isEmpty() && node > stack.peek()){  // 注意这里是while ！！！
                currentLow = stack.pop();
            }
            stack.push(node);
        }
        
        return true;
    }
    
	
	
	// follow up, by other using array[i] to simulate the stack, space O(1)
    public boolean verifyPreorder2(int[] preorder) {
        if(preorder == null || preorder.length <= 1){
            return true;
        } 
        
        int n = preorder.length;
        int currentLow = Integer.MIN_VALUE;
        int index = -1;                  // 注意这里index初始值是－1 !!!
        
        for(int node : preorder){
            if(node < currentLow){
                return false;
            }
            
            while(index >= 0 && node > preorder[index]){
                currentLow = preorder[index--];        // 注意这里是index-- !!!
            }
            
            preorder[++index] = node;                  // 注意这里是 ++index !!!
        }
        
        return true;
    }
    
    public static void main(String[] args){
    	Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree t = new Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree();
    	int[] preorder = {5,3,2,4,7,6,8};
    	System.out.println(t.verifyPreorder(preorder));
    	System.out.println(t.verifyPreorder2(preorder));
    }
}
