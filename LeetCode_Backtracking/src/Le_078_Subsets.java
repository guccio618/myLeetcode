import java.util.*;

/******
 * 
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * 
 * */

public class Le_078_Subsets {
	// using backtrack
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums, int start) {
        ans.add(new ArrayList<Integer>(list));
        
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
            
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
	

    
    
    
    
    
    
    
    
    /***************************************************/
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();    
    public LinkedList<LinkedList<Integer>> subsets2(int[] nums) {
        if(nums == null) return res;
        LinkedList<Integer> path = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        res.add(new LinkedList<Integer>(path));
        for(int i = 1, len = nums.length; i <= len; ++i){
        	for(int j = 0; j < len; ++j)
        		backtrack(nums, j, i, path, visited);
        }
        return res;
    }
    
    public void backtrack(int[] nums, int curPos, int num, LinkedList<Integer> path, boolean[] visited){
        if(visited[curPos] == true) return;        
        visited[curPos] = true;
        path.add(nums[curPos]);
        if(path.size() == num){
        	res.add(new LinkedList<Integer>(path));
        }
        for(int i = curPos+1; i < nums.length; ++i){
            backtrack(nums, i, num, path, visited);
        }
        path.remove(path.size()-1);
        visited[curPos] = false;
    }
    
    
    public static void main(String[] args){
    	Le_078_Subsets t = new Le_078_Subsets();
    	int[] candidates = {4,1,0};
    	List<List<Integer>> res = t.subsets(candidates);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
