import java.util.*;
/*******
 * 
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * 
 * */

public class Q046_Permutations {
	// test case:
    // nums is empty
    
	// using backtrack
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        boolean[] visited = new boolean[nums.length];
        backtrack(ans, new ArrayList<Integer>(), nums, visited);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                list.add(nums[i]);
                backtrack(ans, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

	
	
    
    
    
    
    
    
    
    
    
	/**************************** main function **************************/
    
    public static void main(String[] args){
    	Q046_Permutations t = new Q046_Permutations();
    	int[] nums = {1,2,3};
    	List<List<Integer>> res = t.permute(nums);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
