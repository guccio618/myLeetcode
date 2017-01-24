import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/**********
 * 
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 * 
 * */


public class Q057_Insert_Interval {
	// test case:
    // intervals is empty
    // newInterval == null
	
	// solution 1: using sort, time complexity is O(nlogn)
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

			Integer startPos = null, endPos = null;

			for (Interval inter : intervals) {
				if (startPos == null) {
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

		
		
		
		// follow up solution 2: time complexity is O(n)
		public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
			List<Interval> ans = new ArrayList<>();
			int len = intervals.size();
			int index = 0;
			int startPos = newInterval.start, endPos = newInterval.end;

			while (index < len) {
				Interval curInterval = intervals.get(index);

				if(curInterval.end < newInterval.start) {
					ans.add(curInterval);
					index++;
				} else {
					break;
				}
			}

			while (index < len) {
				Interval curInterval = intervals.get(index);

				if (curInterval.start <= endPos) {
					startPos = Math.min(startPos, curInterval.start);
					endPos = Math.max(endPos, curInterval.end);
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
	
	
	
    
		
		
		
		
		
	
	
    /****************************** main function ***********************************/
    
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
