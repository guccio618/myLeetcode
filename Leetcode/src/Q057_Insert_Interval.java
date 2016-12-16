import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q057_Insert_Interval {
	// Time complexity is O(nlogn)
		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
			List<Interval> ans = new ArrayList<>();
			intervals.add(newInterval);

			Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval inter1, Interval inter2) {
					if (inter1.start != inter2.start) {
						return inter1.start - inter2.start;
					} else {
						return inter1.end - inter2.end;
					}
				}
			});

			int startPos = Integer.MIN_VALUE, endPos = Integer.MIN_VALUE;

			for (Interval inter : intervals) {
				if (startPos == Integer.MIN_VALUE) {
					startPos = inter.start;
					endPos = inter.end;
					continue;
				}

				if (endPos >= inter.start) {
					endPos = Math.max(endPos, inter.end);
				} else {
					ans.add(new Interval(startPos, endPos));
					startPos = inter.start;
					endPos = inter.end;
				}
			}

			ans.add(new Interval(startPos, endPos));
			return ans;
		}

		// Time complexity is O(n)
		public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
			List<Interval> ans = new ArrayList<>();
			int len = intervals.size();
			int index = 0;
			int startPos = newInterval.start, endPos = newInterval.end;

			while (index < len) {
				Interval currentInterval = intervals.get(index);

				if (currentInterval.end >= newInterval.start) {
					break;
				} else {
					ans.add(currentInterval);
					index++;
				}
			}

			while (index < len) {
				Interval currentInterval = intervals.get(index);

				if (endPos >= currentInterval.start) {
					startPos = Math.min(startPos, currentInterval.start);
					endPos = Math.max(endPos, currentInterval.end);
					index++;
				} else {
					break;
				}
			}

			ans.add(new Interval(startPos, endPos));

			while (index < len) {
				ans.add(intervals.get(index++));
			}

			return ans;
		}
	
	
	// by Jackie
	public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
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
    
    
    
    public static void main(String[] args){
    	Q057_Insert_Interval t = new Q057_Insert_Interval();
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(1, 5));
    	intervals.add(new Interval(6, 9));
    	Interval newInterval = new Interval(5, 6);
    	List<Interval> ans = t.insert(intervals, newInterval);
    	System.out.println(ans.get(0).start + ", " + ans.get(0).end);
    }
}
