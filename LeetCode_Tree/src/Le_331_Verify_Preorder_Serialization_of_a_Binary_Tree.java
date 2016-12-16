import java.util.Stack;


public class Le_331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	// test case: 1,#,#,#,# 和 1,#
	public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return true;
        }
        
        String[] nodes = preorder.split(",");
        int n = nodes.length;
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < n; i++){
            if(nodes[i].equals("#")){
                while(!stack.isEmpty() && stack.peek().equals("#")){
                    stack.pop();
                    if(stack.isEmpty()){  // 注意这里应该是判断是否为false, 防止1,#,#,#,#case
                        return false;
                    }
                    stack.pop();
                } 
            } 
            stack.push(nodes[i]);
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
