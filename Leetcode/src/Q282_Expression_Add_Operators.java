import java.util.List;
import java.util.ArrayList;


public class Q282_Expression_Add_Operators {
	public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        
        if(num == null || num.length() == 0) {
        	return ans;
        }
        
        helper(ans, "", num, target, 0, 0, 0);
        return ans;
    }
    
    public void helper(List<String> rst, String solution, String num, int target, int pos, long sum, long multed){
        if(pos == num.length()){
            if(target == sum){
                rst.add(solution);
            }
            
            return;
        }
        
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0'){
            	break;
            }
            
            long cur = Long.parseLong(num.substring(pos, i + 1));
            
            if(pos == 0){
                helper(rst, solution + cur, num, target, i + 1, cur, cur);
            } else{
                helper(rst, solution + "+" + cur, num, target, i + 1, sum + cur , cur);                
                helper(rst, solution + "-" + cur, num, target, i + 1, sum - cur, -cur);               
                helper(rst, solution + "*" + cur, num, target, i + 1, sum + multed * cur - multed, multed * cur );
            }
        }
    }
}
