import java.util.*;


public class Q316_Remove_Duplicate_Letters {
	// by other
	/*****************************************************************************************************
     * First loop: use an array hash[] to count the number of times each letter has appeared in s.
     * 
     * Second loop (Greedy): use a stack, pop() 
     * if previous character appears more than once, and current character is smaller than previous 
     * one in lexicographical order, the previous character should be removed;
     * 
     *****************************************************************************************************/
	
	public String removeDuplicateLetters(String s) { 
		if(s == null || s.length() == 0) {
            return "";
        }
        
        int[] hash = new int[256];
        Set<Character> inStack = new HashSet();
        Stack<Character> stack = new Stack();
        
        for(char c : s.toCharArray()) {
            hash[c]++;
        }
        
        for(char c : s.toCharArray()) {
            if(inStack.contains(c)) {
                hash[c]--;
                continue;
            }
            
            while(!stack.isEmpty()) {
                char top = stack.peek();
                
                if(hash[top] > 1 && c < top) {
                    stack.pop();
                    hash[top]--;
                    inStack.remove(top);
                } else {
                    break;
                }
            }
            
            stack.push(c);
            inStack.add(c);
        }
        
        StringBuilder builder = new StringBuilder();
        
        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        
        return builder.toString();
    }	
	
	
	public String removeDuplicateLetters2(String s) {
		if (s == null || s.isEmpty()) {
            return "";
		}
		
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> inStack = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }        
        
        for (char c : s.toCharArray()) {
            if (inStack.contains(c)) {
                map.put(c, map.get(c) - 1); 
                continue;
            } 
            
            while (!stack.isEmpty()) {
                char top = stack.peek();
                
                if (map.get(top) > 1 && c < top) {
                    stack.pop();
                    inStack.remove(top);
                    map.put(top, map.get(top) - 1);
                } else {
                    break;
                }
            }
            
            stack.push(c);
            inStack.add(c);
        }
        
        String res = "";
        
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        
        return res;
    }
	
	
	public static void main(String[] args){
		Q316_Remove_Duplicate_Letters t = new Q316_Remove_Duplicate_Letters();
		System.out.println(t.removeDuplicateLetters2("cbac"));	
	}
}
