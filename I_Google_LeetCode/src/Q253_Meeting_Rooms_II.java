import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*******
 * 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
	Given [[0, 30],[5, 10],[15, 20]],
	return 2.
	
 * 
 * */

public class Q253_Meeting_Rooms_II {
	public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        int ans = 0;
        int count = 0;
        
        Queue<Pair> heap = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
            public int compare(Pair left, Pair right){
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
            heap.offer(new Pair(interval.start, true));
            heap.offer(new Pair(interval.end, false));
        }
        
        while(!heap.isEmpty()){
            Pair node = heap.poll();
            
            if(node.isStart == true){
                count++;
            } else {
                count--;
            }
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
    
    class Pair {
        int pos;
        boolean isStart;
        
        public Pair(int pos, boolean isStart){
            this.pos = pos;
            this.isStart = isStart;
        }
    }
}
