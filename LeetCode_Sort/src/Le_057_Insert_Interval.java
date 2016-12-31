import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class Le_057_Insert_Interval {
	/********************************************************************************/
	// Sort
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return intervals;
        }
        
        List<Interval> ans = new ArrayList<Interval>();
        int startTime = Integer.MIN_VALUE, endTime = Integer.MIN_VALUE;
        intervals.add(newInterval);
        
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval left, Interval right){
        		if(left.start != right.start){
        			return left.start - right.start;
        		} else{
        			return left.end - right.end;
        		}
        	}
        });
        
        for(Interval node : intervals){
        	if(startTime == Integer.MIN_VALUE && endTime == Integer.MIN_VALUE){
        		startTime = node.start;
        		endTime = node.end;
        	} else {
        		if(endTime < node.start){
        			ans.add(new Interval(startTime, endTime));
        			startTime = node.start;
        			endTime = node.end;
        		} else {
        			endTime = Math.max(endTime, node.end);
        		}
        	}
        }
        
        ans.add(new Interval(startTime, endTime));
        return ans;
	}
	
	
	
	/********************************************************************************/
	// using scan line
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return intervals;
        }
        
        List<Interval> ans = new ArrayList<Interval>();
        int count = 0;
        int startTime = 0, endTime = 0;
        int n = intervals.size();
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
            	if(left.time != right.time){
            		return left.time - right.time;
            	} else {
            		if(left.isStart == true && right.isStart == false){
            			return -1;
            		} else if(left.isStart == false && right.isStart == true){
            			return 1;
            		} else {
            			return 0;
            		}
            	}
            }
        });
        
        for(Interval inter : intervals){
            heap.offer(new Node(inter.start, true));
            heap.offer(new Node(inter.end, false));
        }
        
        heap.offer(new Node(newInterval.start, true));
        heap.offer(new Node(newInterval.end, false));
        
        
        while(!heap.isEmpty()){
        	Node node = heap.poll();
            if(count == 0 && node.isStart == true){
                startTime = node.time;
                count++;
            } else if(count == 1 && node.isStart == false){
                endTime = node.time;
                ans.add(new Interval(startTime, endTime));
                count--;
            } else {
                if(node.isStart == true){
                    count++;
                } 
                if(node.isStart == false){
                    count--;
                }
            }
        }
        
        return ans;
    }
    
    class Node{
        int time;
        boolean isStart;
        
        public Node(int t, boolean s){
            time = t;
            isStart = s;
        }
    }
}
