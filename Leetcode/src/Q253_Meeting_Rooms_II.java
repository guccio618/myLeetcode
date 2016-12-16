import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q253_Meeting_Rooms_II {
	public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        int ans = 0;
        int count = 0;
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                if(left.pos != right.pos){
                    return left.pos - right.pos;
                } else {
                    if(left.isStart == true && right.isStart == false){
                        return 1;
                    } else if(left.isStart == false && right.isStart == true){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        
        for(Interval interval : intervals){
            heap.offer(new Node(interval.start, true));
            heap.offer(new Node(interval.end, false));
        }
        
        while(!heap.isEmpty()){
            Node node = heap.poll();
            
            if(node.isStart == true){
                count++;
            } else {
                count--;
            }
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
    
    class Node {
        int pos;
        boolean isStart;
        
        public Node(int pos, boolean isStart){
            this.pos = pos;
            this.isStart = isStart;
        }
    }
}
