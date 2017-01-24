import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*****
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, 
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * 
 * */


public class Q020_Valid_Parentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
	
	
	
	// follow up, if there have many kinds of Parentheses
	public boolean isValid_follow_up(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Set<Character> set = new HashSet<Character>();
        Map<Character, Character> map = new HashMap();
        Stack<Character> stack = new Stack();
        
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        set.add('(');
        set.add('[');
        set.add('{');
        
        for(char c : s.toCharArray()) {
        	if(set.contains(c)) {
        		stack.push(c);        		
        	} else if(map.containsKey(c)) {
        		if(stack.isEmpty()) {
        			return false;
        		} 
        		
        		if(stack.pop() != map.get(c)) {
        			return false;
        		}
        	} else {
        		return false;
        	}
        }
        
        return stack.isEmpty();
	}
	
	
	
	// follow up 2, if given a tree of string
	private Set<Character> set = new HashSet<Character>();
    private Map<Character, Character> map = new HashMap();
    private Stack<Character> stack = new Stack();
	
	public boolean isValid_follow_up_2(StringTreeNode root) {
        if (root == null) {
            return true;
        }
               
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        set.add('(');
        set.add('[');
        set.add('{');
        
        Stack<StringTreeNode> treeStack = new Stack();
        
        while(!treeStack.isEmpty() || root != null) {
        	while(root != null) {
        		if(isValidParentheses(root.str) == false) {
        			return false;
        		}
        		
        		treeStack.push(root);
        		root = root.left;
        	}
        	
        	root = treeStack.pop();
        	root = root.right;
        }
        
        return stack.isEmpty();
	}
	
	public boolean isValidParentheses(String str) {
		for(char c : str.toCharArray()) {
        	if(set.contains(c)) {
        		stack.push(c);        		
        	} else if(map.containsKey(c)) {
        		if(stack.isEmpty()) {
        			return false;
        		} 
        		
        		if(stack.pop() != map.get(c)) {
        			return false;
        		}
        	} else {
        		return false;
        	}
        }
        
        return true;
	}
	
	
	
	
	/************************ main function **************************/	
	public static void main(String[] args) {
		Q020_Valid_Parentheses t = new Q020_Valid_Parentheses();
		String[] strs = {
				"()[]{}",
				"([)]",
				"(]"
		};
		
		for(String str : strs) {
			System.out.println(t.isValid_follow_up(str));
		}
		
		
		
		
		
		
		StringTreeNode root = new StringTreeNode("()[");
		root.left = new StringTreeNode("()]");
		root.right = new StringTreeNode("");
		
		System.out.println(t.isValid_follow_up_2(root));
		
	}
}

class StringTreeNode {
	String str;
	StringTreeNode left, right;
	
	public StringTreeNode(String str) {
		this.str = str;
		left = right = null;
	}
}
