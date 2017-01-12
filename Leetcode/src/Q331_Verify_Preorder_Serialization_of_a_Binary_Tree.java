import java.util.Stack;
/******
 * 
One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
	"9,3,4,#,#,1,#,#,2,#,6,#,#"
	Return true

Example 2:
	"1,#"
	Return false

Example 3:
	"9,#,#,1"
	Return false
	
 * 
 * */

public class Q331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	// test case: [1,#,#,#,#], [1,#], [#,#,#]
	public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        
        String[] nodes = preorder.split(",");
        if(nodes.length == 0){
            return false;
        }
        
        int len = nodes.length;
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < len; i++){
            if(nodes[i].equals("#")){                                    // 不可以做stack.isEmpty()的check，防止test case "#"
                while(!stack.isEmpty() && stack.peek().equals("#")){     // 这里必须用while !!!
                    stack.pop();
                    
                    if(!stack.isEmpty() && !stack.peek().equals("#")) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************* main function ***********************************/
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
