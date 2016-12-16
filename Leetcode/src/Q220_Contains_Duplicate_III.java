import java.util.Arrays;
import java.util.Comparator;


public class Q220_Contains_Duplicate_III {	
	/**********************************************************/
	// by other
	class Pair {
        int val;
        int index;
        
        Pair(int v, int i) {
            this.val = v;
            this.index = i;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {      
        if (nums == null || nums.length < 2 || t < 0 || k < 1) {
            return false;
        }
        int len = nums.length;
        Pair[] pair = new Pair[len];
        for(int i = 0; i < len; i++) {
            pair[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pair, new Comparator<Pair> () {   // sort's自定义比较函数的改写，nice
          public int compare(Pair p1, Pair p2) {
              return p1.val - p2.val;
          } 
        });

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len && Math.abs((long)pair[j].val - (long)pair[i].val) <= (long)t; j++){    // 注意，这里必需是Math.abs() 否则会错误 !!! 
                int indexDiff = Math.abs(pair[i].index - pair[j].index);                                       // 注意test case: [-1,2147483647], 1, 2147483647 !!!, 否则会等于 －2147483647
                if (indexDiff <= k) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public static void main(String[] args){
    	Q220_Contains_Duplicate_III t = new Q220_Contains_Duplicate_III();
    	int[] nums = {-1,2147483647};
    	System.out.println(t.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}
