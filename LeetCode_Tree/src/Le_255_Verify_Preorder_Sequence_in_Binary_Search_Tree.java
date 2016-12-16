import java.util.Stack;

/**************************************************************************
 *  (1). 应用stack，当前的node小于stack.peek()时，表示当前结点处于左子树中，继续入栈；
 *  (2). 当node > stack.peek()时，表示到了右子树
 *  (3). currentLow记录当前为止最小的值，如果后续结点小于此值，表示不是合法的遍历顺序
 * 
 *  follow up 中用preorder数组模拟栈的形式	
 * 
 **************************************************************************/

public class Le_255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
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
	            while(!stack.isEmpty() && node > stack.peek()){
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
	        int index = -1;
	        
	        for(int node : preorder){
	            if(node < currentLow){
	                return false;
	            }
	            
	            while(index >= 0 && node > preorder[index]){
	                currentLow = preorder[index--];
	            }
	            
	            preorder[++index] = node;
	        }
	        
	        return true;
	    }
}
