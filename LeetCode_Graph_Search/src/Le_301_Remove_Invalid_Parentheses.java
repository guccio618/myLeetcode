import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*****
 * 
Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
 * 
 * */

public class Le_301_Remove_Invalid_Parentheses {
	/*******************************************************************
	 * 此题使用bfs，层序遍历
	 * 设置一个found标志位，当找到一个后，只统计这一层的符合的解
	 * 此例中判断是否是合法的Parentheses方法很简单！
	 *  
	 *******************************************************************/
	
	public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null){
            return ans;
        }
        
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        
        while(!q.isEmpty()){
            String tempStr = q.poll();
            if(isValid(tempStr)){
                ans.add(tempStr);
                found = true;
            }
            
            if(found == true){  // 只要找到一个解，则不再往下拆分，只统计当前层里的解
                continue;
            }
            
            int len = tempStr.length();
            for(int i = 0; i < len; ++i){
                char c = tempStr.charAt(i);  // 需要剔除无效字符
                if(c != '(' && c != ')'){
                    continue;
                }
                
                String newStr = tempStr.substring(0, i) + tempStr.substring(i + 1);
                if(!visited.contains(newStr)){
                    visited.add(newStr);
                    q.offer(newStr);
                }
            }
        }
        
        return ans;
    }
    
    public boolean isValid(String str){   // 此法验证是否是有效的Parentheses很巧 ！！！
        int count = 0;
        int n = str.length();
        
        for(int i = 0; i < n; ++i){
            char c = str.charAt(i);
            if(c == '('){
                count++;
            } else if (c == ')'){
                count--;
            }
            
            if(count < 0){
                return false;
            }
        }
        
        return count == 0;
    }
}
