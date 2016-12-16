import java.util.ArrayList;
import java.util.List;


public class Le_093_Restore_IP_Addresses {
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

    
    
    public static void main(String[] args){
    	Le_093_Restore_IP_Addresses t = new Le_093_Restore_IP_Addresses();
//    	String ip = "010010";
    	String ip = "19216811";
    	List<String> ans = t.restoreIpAddresses(ip);
    	for(String str : ans){
    		System.out.print(str + ", ");
    	} 
    }
}
