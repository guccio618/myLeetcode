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



public class Q282_Expression_Add_Operators {
	// test case: ["0"], ["01"], ["101"]
	
	public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        
        if(num == null || num.length() == 0) {
        	return ans;
        }
        
        backtrack(ans, num, target, "", 0, 0, 0);
        return ans;
    }
    	
    public void backtrack(List<String> ans, String num, int target, String solution, int start, long sum, long prevNum){
    	// prevNum is used to store the previous valid number 
        if(start == num.length()){
            if(target == sum){
                ans.add(solution);
            }
            
            return;
        }
        
        for(int i = start; i < num.length(); i++){ 
            if(i != start && num.charAt(start) == '0'){    // 注意这里是start，而不是 i  ！！！
            	break;                                     // 可以是 "0", 但不可以是"01"之类的 ！！！
            }
            
            long cur = Long.parseLong(num.substring(start, i + 1));
            
            if(start == 0){
                backtrack(ans, num, target, solution + cur, i + 1, cur, cur);
            } else{
                backtrack(ans, num, target, solution + "+" + cur, i + 1, sum + cur, cur);                
                backtrack(ans, num, target, solution + "-" + cur, i + 1, sum - cur, -cur);               
                backtrack(ans, num, target, solution + "*" + cur, i + 1, sum + prevNum * cur - prevNum, prevNum * cur);   // because in last recusrion, multed has been add one time.
            }
        }
    }
}
