import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Q352_Data_Stream_as_Disjoint_Intervals {
	// by other using TreeMap
	private TreeMap<Integer, Interval> tree;

    /** Initialize your data structure here. */
    public Q352_Data_Stream_as_Disjoint_Intervals() {
        tree = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(tree.containsKey(val)){
            return ;
        }
        
        Integer low = tree.lowerKey(val);
        Integer high = tree.higherKey(val);
        
        if(low != null && high != null && tree.get(low).end + 1 == val && high == val + 1){
            tree.get(low).end = tree.get(high).end;
            tree.remove(high);
        } else if(low != null && tree.get(low).end + 1 >= val){
            tree.get(low).end = Math.max(tree.get(low).end, val);
        } else if(high != null && high == val + 1){
            tree.put(val, new Interval(val, tree.get(high).end));
            tree.remove(high);
        } else{
            tree.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
	
	
//	// by Jackie using binary search
//	private List<Interval> list;
//	
//    /** Initialize your data structure here. */
//    public Q352_Data_Stream_as_Disjoint_Intervals() {
//        list = new ArrayList<Interval>();
//    }
//    
//    public void addNum(int val) {
//        if(list.size() == 0){
//            list.add(new Interval(val, val));
//        } else {
//            int left = 0, right = list.size() - 1;
//            while(left + 1 < right){
//                int mid = left + (right - left) / 2;
//                Interval midInterval = list.get(mid);
//                if(val < midInterval.start){
//                    right = mid;
//                } else if(val > midInterval.end){
//                    left = mid;
//                } else {
//                    return ;
//                }
//            }
//            
//            Interval leftInterval = list.get(left);
//            Interval rightInterval = list.get(right);
//            
//            if(val < leftInterval.start){
//                if(left == 0){
//                    if(val + 1 == leftInterval.start){
//                        list.get(left).start = val;
//                    } else {
//                        list.add(0, new Interval(val, val));
//                    }
//                } else {
//                    Interval leftLeftInterval = list.get(left - 1);
//                    if(val + 1 == leftInterval.start && leftLeftInterval.end == val - 1){
//                        list.get(left).start = leftLeftInterval.start;
//                        list.remove(left - 1);
//                    } else if(val + 1 == leftInterval.start){
//                        list.get(left).start = val;
//                    } else if(leftLeftInterval.end == val - 1){
//                        list.get(left - 1).end = val;
//                    } else {
//                        list.add(left, new Interval(val, val));
//                    }
//                }
//            } else if(val > leftInterval.end && val < rightInterval.start){
//                if(val + 1 == rightInterval.start && val - 1 == leftInterval.end){
//                    list.get(left).end = rightInterval.end;
//                    list.remove(right);
//                } else if(val + 1 == rightInterval.start){
//                    list.get(right).start = val;
//                } else if(val - 1 == leftInterval.end){
//                    list.get(left).end = val;
//                } else {
//                    list.add(right, new Interval(val, val));
//                }
//            } else if(val > rightInterval.end){
//                if(right == list.size() - 1){
//                    if(val - 1 == rightInterval.end){
//                        list.get(right).end = val;
//                    } else {
//                        list.add(new Interval(val, val));
//                    }
//                } else {
//                    Interval rightRightInterval = list.get(right + 1);
//                    if(val + 1 == rightRightInterval.start && rightInterval.end == val - 1){
//                        list.get(right).end = rightRightInterval.end;
//                        list.remove(right + 1);
//                    } else if(val + 1 == rightRightInterval.start){
//                        list.get(right + 1).start = val;
//                    } else if(rightInterval.end == val - 1){
//                        list.get(right).end = val;
//                    } else {
//                        list.add(right + 1, new Interval(val, val));
//                    }
//                }
//            }
//        }
//    }
//    
//    public List<Interval> getIntervals() {
//        return list;
//    }
//    
//    public static void main(String[] args){
//    	Q352_Data_Stream_as_Disjoint_Intervals t = new Q352_Data_Stream_as_Disjoint_Intervals();
//    	
//    	int[] nums = {1, 3, 7, 2, 6};
//    	
//    	for(int i = 0; i < nums.length; i++){
//    		t.addNum(nums[i]);
//    		List<Interval> list = t.getIntervals();
//    		for(int j = 0; j < list.size(); j++){
//    			System.out.print("[" + list.get(j).start + ", " + list.get(j).end + "]  ");
//    		}
//    		System.out.println();
//    	}
//    }
//    
//    class Interval {
//    	int start;
//    	int end;
//    	Interval() { start = 0; end = 0; }
//    	Interval(int s, int e) { start = s; end = e; }
//    }
}
