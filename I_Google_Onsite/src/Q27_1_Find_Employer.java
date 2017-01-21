import java.util.*;


public class Q27_1_Find_Employer {
	private Map<String, List<String>> map = new HashMap<>();
	
	public Q27_1_Find_Employer(String s) {
		if(s == null || s.length() == 0) {
			return;
		}
		
		String[] strs = s.split("\n");
		Stack<String> stack = new Stack<>();
		
		for(String name : strs) {
			int level = name.length() - name.trim().length();
			
			while(level < stack.size()) {
				stack.pop();
			}
			
			String boss = (!stack.isEmpty()) ? stack.peek() : "";
			stack.push(name.trim());
			
			if(boss.equals("")) {				
				continue;
			}
			
			if(!map.containsKey(boss)) {
				map.put(boss, new ArrayList<String>());
			}
			
			map.get(boss).add(name.trim());
		}
	}
	
	public List<String> getEmployer(String name) {
		List<String> ans = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(name);
		
		while(!queue.isEmpty()) {
			String node = queue.poll();
			
			if(!node.equals(name)) {
				ans.add(node);
			}
			
			if(!map.containsKey(node)) {
				continue;
			}
			
			for(String next : map.get(node)) {
				queue.offer(next);
			}
		}
		
		return ans;
	}
	
	
	
	
	
	
	
	/****************************** main function ************************************/
	
	public static void main(String[] args) {
		String s = "AAA\n BBB\n CCC\n  DDD\n EEE";
		Q27_1_Find_Employer t = new Q27_1_Find_Employer(s);
		String name = "CCC";
		List<String> ans = t.getEmployer(name);
		
		for(String employer : ans) {
			System.out.print(employer + " ");
		}
	}
}
