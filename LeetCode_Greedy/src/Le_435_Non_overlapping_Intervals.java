import java.util.*;
/*******
 * 
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
	You may assume the interval's end point is always bigger than its start point.
	Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

Example 1:
	Input: [ [1,2], [2,3], [3,4], [1,3] ]
	Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

Example 2:
	Input: [ [1,2], [1,2], [1,2] ]
	Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Example 3:
	Input: [ [1,2], [2,3] ]
	Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

 * 
 * */

public class Le_435_Non_overlapping_Intervals {
	/************************************************************************************************************************
	 * Actually, the problem is the same as "Given a collection of intervals, 
	 * find the maximum number of intervals that are non-overlapping." (the classic Greedy problem: Interval Scheduling). 
	 * With the solution to that problem, guess how do we get the minimum number of intervals to remove? : )
	 * Sorting Interval.end in ascending order is O(nlogn), 
	 * then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).
	 ************************************************************************************************************************/
	
	// test case:  
    //      (1). [1, 10], [2, 5], [6, 10]
    //      (2). [1, 5], [2, 6], [6, 10]
    //      (3). [1, 5], [4, 7], [6, 10]
    //      (4). [1, 2], [1, 3], [2, 3]
    
    // time complex is O(nlogn)
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        int count = 1;
        int end = intervals[0].end;
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= end){
                end = intervals[i].end;
                count++;
            }
        }
        
        return intervals.length - count;
    }
    
    
}
