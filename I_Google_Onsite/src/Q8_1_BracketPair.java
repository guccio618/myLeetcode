import java.util.*;

public class Q8_1_BracketPair {
	public List<List<Integer>> getBracketPair(String s) {
		List<List<Integer>> ans = new ArrayList<>();
		
		if(s == null || s.length() == 0) {
			return ans;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '(') {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				ans.add(list);
				stack.push(ans.size() - 1);
			} else if(c == ')') {
				if(stack.isEmpty()) {
					return new ArrayList<>();
				}
				
				int insertIndex = stack.pop();
				ans.get(insertIndex).add(i);
			}
		}
		
		return ans;
	}
	
	
	
	
	
	
	

	/******************************* main function ************************************/
	
	public static void main(String[] args) {
		Q8_1_BracketPair t = new Q8_1_BracketPair();
		String s = "(()())()()";
		List<List<Integer>> ans = t.getBracketPair(s);
		
		for(List<Integer> list : ans) {
			System.out.println(list.get(0) + " " + list.get(1));
		}
	}
}
