import java.util.Stack;

/**************************************************
 * 如何用stack记录当前最小值
 * 
 **************************************************/

public class Le_155_Min_Stack {
	private Stack<Integer> s = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();  
    
    public void push(int x) {
        s.push(x);
        if(min.isEmpty()){
            min.push(x);
        } else {
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        if(s.isEmpty()){
            return;
        }
        s.pop();
        min.pop();
    }

    public int top() {
        if(s.isEmpty()){
            return -1;
        }
        return s.peek();
    }

    public int getMin() {
        if(min.isEmpty()){
            return -1;
        }
        return min.peek();
    }
}
