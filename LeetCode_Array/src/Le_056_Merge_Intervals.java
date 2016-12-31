import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
/*******
 * 
Given a collection of intervals, merge all overlapping intervals.

For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
	
 * 
 * */

public class Le_056_Merge_Intervals {
	// test case:
    // intervals is empty
    // intervals is sorted?
    // invalid input: interval.start >= intervals.end
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        
        if(intervals == null || intervals.size() == 0) {
            return ans;
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval l1, Interval l2){
                if(l1.start != l2.start) {
                    return l1.start - l2.start;
                } else {
                    return l1.end - l2.end;
                }
            }
        });
        
        Integer startPos = null;
        Integer endPos = null;
        
        for(Interval node : intervals) {
            if(startPos == null) {
                startPos = node.start;
                endPos = node.end;
                continue;
            }
            
            if(endPos >= node.start) {
                endPos = Math.max(endPos, node.end);
            } else {
                ans.add(new Interval(startPos, endPos));
                startPos = node.start;
                endPos = node.end;
            }
        }
        
        ans.add(new Interval(startPos, endPos));
        return ans;
    }
	
    
    
	
	
	/******************************* main function *************************************/
	
    public static void main(String[] args){
    	Le_056_Merge_Intervals t = new Le_056_Merge_Intervals();
    	ArrayList<Interval> list = new ArrayList<Interval>();
    	int[][] array = {
//    			{1,3},
//    			{2,6},
//    			{8,10},
//    			{15,18}
//    			{1,4},
//    			{2,3}
    			{2,3},
    			{4,5},
    			{6,7},
    			{8,9},
    			{1,10}
    	};
    	
    	for(int i = 0; i < array.length; ++i){
    		list.add(new Interval(array[i][0], array[i][1]));
    	}
    	
    	List<Interval> ans = t.merge(list);
    	
    	for(int i = 0; i < ans.size(); ++i){
    		System.out.print("[" + ans.get(i).start + ", " + ans.get(i).end + "], ");
    	}
    }
}
