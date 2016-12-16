import java.util.LinkedList;
import java.util.Queue;


public class Le_225_Implement_Stack_using_Queues {
private Queue<Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {      // 存入时就进行处理
        q.offer(x);
        int size = q.size();
        for(int i = 0; i < size - 1; i++){
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(q.size() == 0){
            return;
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        if(q.size() == 0){
            return -1;
        }
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
