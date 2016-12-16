import java.util.*;


public class Q093_Restore_IP_Addresses {
	// test case = "0000"
	public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList();
        
        if(s == null || s.length() == 0) {
            return ans;
        }
        
        backtrack(ans, new ArrayList<String>(), s, 0);
        return ans;
    }
    
    public void backtrack(List<String> ans, List<String> solution, String s, int start){
        if(solution.size() == 4 || start == s.length()) {
            if(solution.size() == 4 && start == s.length()) {
                StringBuilder sb = new StringBuilder();
                
                for(int i = 0; i < 3; i++) {
                    sb.append(solution.get(i)).append(".");
                }
                sb.append(solution.get(3));
                ans.add(sb.toString());
            }
            return ;
        } 
        
        for(int i = start; i < s.length() && i < start + 3; i++) {
            String str = s.substring(start, i + 1);
            int num = Integer.parseInt(str);
            
            if(s.charAt(start) == '0' && i > start) {
                return ;
            }
            
            if(num >= 0 && num <= 255) {
                solution.add(str);
                backtrack(ans, solution, s, i + 1);
                solution.remove(solution.size() - 1);
            }
        }
    }
}
