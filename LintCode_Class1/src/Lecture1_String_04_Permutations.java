import java.util.ArrayList;


public class Lecture1_String_04_Permutations {
	// DFS: 时间复杂度为答案的个数*构造每个答案的时间， time complexity: O(n! * n)
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        permutationHelp(res, list, nums);
        return res;
    }
    
    public void permutationHelp(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> nums){
        if(list.size() == nums.size()){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0, len = nums.size(); i < len; ++i){
            if(list.contains(nums.get(i))){
                continue;
            }
            list.add(nums.get(i));
            permutationHelp(res, list, nums);
            list.remove(list.size()-1);
        }
    }
}
