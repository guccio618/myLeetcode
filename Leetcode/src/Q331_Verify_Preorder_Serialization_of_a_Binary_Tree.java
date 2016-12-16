import java.util.Stack;


public class Q331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        
        String[] nodes = preorder.split(",");
        if(nodes.length == 0){
            return false;
        }
        
        int n = nodes.length;
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < n; i++){
            if(nodes[i].equals("#")){                                    // 不可以做stack.isEmpty()的check，防止test case "#"
                while(!stack.isEmpty() && stack.peek().equals("#")){     // 这里必须用while !!!
                    stack.pop();
                    if(!stack.isEmpty()){
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            stack.push(nodes[i]);
        }
        
        if(stack.size() == 1 && stack.peek().equals("#")){
            return true;
        } else {
            return false;
        }
    }
	
	// by other
	public boolean isValidSerialization2(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<String>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) { // 按照#+#+num对进行剔除，完成后压入一个#表示遍历过
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);  // 此步骤可以把#压入栈
        }
        return st.size() == 1 && st.peek().equals("#");  // 这里的#表示已经遍历完毕
    }
	
	
	public static void main(String[] args){
		Q331_Verify_Preorder_Serialization_of_a_Binary_Tree t = new Q331_Verify_Preorder_Serialization_of_a_Binary_Tree();
		System.out.println(t.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}
