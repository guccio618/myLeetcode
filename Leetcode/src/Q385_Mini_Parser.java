import java.util.List;
import java.util.Stack;
/*******
 * 
Given a nested list of integers represented as a string, 
implement a parser to deserialize it.

Each element is either an integer, or a list -- 
whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].

Example 1:

	Given s = "324",

	You should return a NestedInteger object which contains a single integer 324.

Example 2:

	Given s = "[123,[456,[789]]]",

	Return a NestedInteger object containing a nested list with 2 elements:

	1. An integer containing value 123.
	2. A nested list containing two elements:
    	i.  An integer containing value 456.
    	ii. A nested list with one element:
         	a. An integer containing value 789.
         
 * 
 * */

public class Q385_Mini_Parser {
	public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0){
            return null;
        } else if(s.indexOf("[", 0) < 0){
            return new NestedInteger(Integer.parseInt(s));
        }
        
        int len = s.length();
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int start = 0;
        NestedInteger current = null;
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            
            if(c == '['){
                if(current != null){
                    stack.push(current);
                }
                
                current = new NestedInteger();
                start = i + 1;
                
            } else if(c == ']'){
                String num = s.substring(start, i);
                
                if(!num.isEmpty()){
                    current.add(new NestedInteger(Integer.parseInt(num)));
                }
                
                if(!stack.isEmpty()){
                    NestedInteger prev = stack.pop();
                    prev.add(current);
                    current = prev;
                }
                
                start = i + 1;
                
            } else if(c == ','){
                if(s.charAt(i - 1) != ']'){
                    String num = s.substring(start, i);
                    current.add(new NestedInteger(Integer.parseInt(num)));
                }
                
                start = i + 1;
            }
        }
        
        return current;
    }
	
	
	
	class NestedInteger {
		int value;
		List<NestedInteger> list;

		// Constructor initializes an empty nested list.
		public NestedInteger() {
			value = 0;
			list = null;
		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {
			this.value = value;
			list = null;
		}

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger() {
			return list == null;
		}

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return value;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {
			this.value = value;
		}

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni) {
			list.add(ni);
		}

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return list;
		}
	}
}
