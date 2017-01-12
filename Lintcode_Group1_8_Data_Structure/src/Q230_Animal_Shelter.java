import java.util.LinkedList;
import java.util.Queue;


public class Q230_Animal_Shelter {
	// by Jackie
	private class Pair{
        protected String name;
        protected int type;
        public Pair(String n, int t){
            name = n;
            type = t;
        }
    }
    
    private Queue<Pair> queue;
    private int dogNum, catNum;
    
    public Q230_Animal_Shelter() {
        // do initialize if necessary
        queue = new LinkedList<Pair>();
        dogNum = 0;
        catNum = 0;
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        queue.add(new Pair(name, type));
        if(type == 0){
            catNum++;
        } else if(type == 1){
            dogNum++;
        }
    }

    public String dequeueAny() {
        // Write your code here
        if(queue.size() == 0){
            return new String();
        }
        Pair res = queue.poll();
        if(res.type == 0){
            catNum--;
        } else if(res.type == 1){
            dogNum--;
        }
        return res.name;
    }

    public String dequeueDog() {
        // Write your code here
        if(dogNum == 0){
            return new String();
        }
        dogNum--;
        int count = 0, size = queue.size();
        Pair res = null;
        while(count < size){
            res = queue.poll();
            if(res.type == 1){
                for(int i = 0; i < size - count - 1; ++i){
                    queue.add(queue.poll());
                }
                return res.name;
            } else{
                queue.add(res);
            }
            count++;
        }
        return res.name;
    }

    public String dequeueCat() {
        // Write your code here
        if(catNum == 0){
            return new String();
        }
        catNum--;
        int count = 0, size = queue.size();
        Pair res = null;
        while(count < size){
            res = queue.poll();
            if(res.type == 0){
                for(int i = 0; i < size - count - 1; ++i){
                    queue.add(queue.poll());
                }
                return res.name;
            } else{
                queue.add(res);
            }
            count++;
        }
        return res.name;
    }
}
