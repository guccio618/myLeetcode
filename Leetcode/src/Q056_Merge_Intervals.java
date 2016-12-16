import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class Q056_Merge_Intervals {
	// test case: [[1,4],[2,3]]
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0){
			return ans;
		} else if(intervals.size() == 1){
		    return intervals;
		}
      
		intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval left, Interval right){
				if(left.start != right.start){
					return (left.start - right.start);
				} else {
					return (left.end - right.end);
				}
			}
		});
		
		int n = intervals.size();
		int curStart = intervals.get(0).start;
		int curEnd = intervals.get(0).end;
		
		for(int i = 1; i < n; ++i){
			Interval node = intervals.get(i);
			if(curEnd < node.start){
				ans.add(new Interval(curStart, curEnd));
				curStart = node.start;
				curEnd = node.end;
			} else {
				curEnd = Math.max(curEnd, node.end);
			}
		}
      
		return ans;
	}
	
    
      
    public static void main(String[] args){
    	Q056_Merge_Intervals t = new Q056_Merge_Intervals();
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
