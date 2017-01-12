import java.util.LinkedList;


public class Q493_Implement_Queue_by_Linked_List_II {
	// by Jackie
private LinkedList<Integer> q;
    public Q493_Implement_Queue_by_Linked_List_II() {
        // do initialize if necessary
        q = new LinkedList<Integer>();
    }

    public void push_front(int item) {
        // Write your code here
        q.add(0, item);
    }

    public void push_back(int item) {
        // Write your code here
        q.add(item);
    }

    public int pop_front() {
        // Write your code here
        int res = q.get(0);
        q.remove(0);
        return res;
    }

    public int pop_back() {
        // Write your code here
        int res = q.get(q.size() - 1);
        q.remove(q.size() - 1);
        return res;
    }
}
