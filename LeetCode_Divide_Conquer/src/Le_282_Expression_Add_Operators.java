import java.util.List;
import java.util.ArrayList;
/*******
 * 
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
	"123", 6 -> ["1+2+3", "1*2*3"] 
	"232", 8 -> ["2*3+2", "2+3*2"]
	"105", 5 -> ["1*0+5","10-5"]
	"00", 0 -> ["0+0", "0-0", "0*0"]
	"3456237490", 9191 -> []

 * 
 * */



public class Le_282_Expression_Add_Operators {
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
