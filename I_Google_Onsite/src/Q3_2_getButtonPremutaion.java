import java.util.*;

public class Q3_2_getButtonPremutaion {
	public List<String> getButtonPremutaion(int n) {
		List<String> ans = new ArrayList<>();
		
		if(n <= 0) {
			return ans;
		}
		
		boolean[] visited = new boolean[n + 1];
		backtrack(ans, "", 0, n, visited);
		return ans;
	}
	
	public void backtrack(List<String> ans, String solution, int addNum, int n, boolean[] visited) {
		if(addNum == n) {
			ans.add(solution);
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtrack(ans, solution + i, addNum + 1, n, visited);
				
				if(addNum + 1 < n) {
					backtrack(ans, solution + i + "-", addNum + 1, n, visited);
				}
				visited[i] = false;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	/******************************* main function ************************************/
	
	public static void main(String[] args) {
		Q3_2_getButtonPremutaion t = new Q3_2_getButtonPremutaion();
		List<String> ans = t.getButtonPremutaion(3);
		
		for(String str : ans) {
			System.out.println(str);
		}
	}
}
