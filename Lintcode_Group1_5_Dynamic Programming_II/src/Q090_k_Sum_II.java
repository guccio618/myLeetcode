import java.util.ArrayList;
import java.util.Arrays;


public class Q090_k_Sum_II {
	// by Jackie
	public ArrayList<ArrayList<Integer>> kSumII(int[] nums, int k, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, list, nums, 0, target, k);
        return res;
        
    }
    
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int start, int target, int k){
        if(list.size() == k){
            if(target == 0){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = start; i < nums.length; ++i){
            if(target - nums[i] < 0){
                return;
            }
            list.add(nums[i]);
            helper(res, list, nums, i + 1, target - nums[i], k);
            list.remove(list.size() - 1);
        }
    }
}
