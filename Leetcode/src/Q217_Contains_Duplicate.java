import java.util.HashSet;
import java.util.Set;


public class Q217_Contains_Duplicate {
	// by Jackie using hashtable
	public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            if(!set.add(i)) {     // if there is same, 这样比较快 ！！！
                 return true;
            }
        return false;
    }
}
