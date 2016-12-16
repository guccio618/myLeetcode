import java.util.ArrayList;
import java.util.List;


public class Le_022_Generate_Parentheses {
	public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if(n <= 0){
            return ans;
        }
        
        helper(ans, "", 0, 0, n);
        return ans;
    }
    
    public void helper(List<String> ans, String solution, int openNum, int closeNum, int n){
        if(solution.length() == 2 * n){
            ans.add(solution);
            return;
        }
        
        if(openNum < n){
            helper(ans, solution + "(", openNum + 1, closeNum, n);     // 均为在solution 后面加 "(" 和 ")" !!!
        }
        if(closeNum < openNum){
            helper(ans, solution + ")", openNum, closeNum + 1, n);
        }
    } 
}
