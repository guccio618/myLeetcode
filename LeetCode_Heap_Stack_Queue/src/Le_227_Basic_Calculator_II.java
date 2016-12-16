import java.util.Stack;


public class Le_227_Basic_Calculator_II {
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int n = s.length();
        char sign = ' ';
        int num = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (int) (c - '0'); 
            } 
            
            if(!Character.isDigit(c) && c != ' ' || i == n - 1){   // 这里不能用else，防止test case: [1]
                if(sign == '+'){
                    stack.push(num);
                } else if(sign == '-'){
                    stack.push(-num);
                } else if(sign == '*'){
                    stack.push(stack.pop() * num);
                } else if(sign == '/'){
                    stack.push(stack.pop() / num);
                } else {                  // 此步用于清理最后一个位，test case: [1] 
                    stack.push(num);
                }
                sign = c;
                num = 0;
            } 
        }
        
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        
        return ans;
    }
}
