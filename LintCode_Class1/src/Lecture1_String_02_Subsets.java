import java.util.ArrayList;
import java.util.Arrays;


public class Lecture1_String_02_Subsets {
	// DFS: 时间复杂度为答案的个数*构造每个答案的时间， time complexity: O(2^n * n)
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) { 
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsetHelper(res, list, nums, 0);
        return res;
    }
    
    public void subsetHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; ++i){
            list.add(nums[i]);
            subsetHelper(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
