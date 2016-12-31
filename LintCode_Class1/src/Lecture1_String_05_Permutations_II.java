import java.util.ArrayList;
import java.util.Arrays;


public class Lecture1_String_05_Permutations_II {
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            return res;
        }
        int[] n = new int[nums.size()];
        boolean[] visited = new boolean[nums.size()];
        for(int i = 0, len = nums.size(); i < len; ++i){
            n[i] = nums.get(i);
        }
        Arrays.sort(n);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res, list, n, visited);
        return res;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] n, boolean[] visited){
        if(list.size() == n.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < n.length; ++i){
            if(visited[i] == true) {
                continue;
            }
    		visited[i] = true;
    		list.add(n[i]);
    		helper(res, list, n, visited);
    		list.remove(list.size()-1);
    		visited[i] = false;
    		while(i+1 < n.length && n[i+1] == n[i]) {
    		    ++i;
    		}
        }
    }
}
