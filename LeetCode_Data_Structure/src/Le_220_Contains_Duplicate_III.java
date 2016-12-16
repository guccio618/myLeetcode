import java.util.Arrays;
import java.util.Comparator;

/**************************************************
 * 自定义数据类型
 * 
 **************************************************/
public class Le_220_Contains_Duplicate_III {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || t < 0 || k < 1) {
            return false;
        }
        
        int n = nums.length;
        Pair[] nodes = new Pair[n];
        
        for(int i = 0; i < n; i++){
            nodes[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(nodes, new Comparator<Pair>(){
            public int compare(Pair left, Pair right){
                return left.val - right.val;
            }
        });
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n && Math.abs((long) nodes[j].val - (long) nodes[i].val) <= (long) t; j++){
                if(Math.abs(nodes[j].index - nodes[i].index) <= k){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    class Pair{
        int val;
        int index;
        
        public Pair(int v, int i){
            val = v;
            index = i;
        }
    }
}
