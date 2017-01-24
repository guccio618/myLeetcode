import java.util.*;
/*******
 * 
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * 
 * */

public class Le_047_Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
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
                
                // 重复部分需要写在 visited[i] == false里
                // 表示当此element被选上时，才跳过相同的element
                while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    /**************************** main function ***********************************/
    
    public static void main(String[] args){
    	Le_047_Permutations_II t = new Le_047_Permutations_II();
    	int[] nums = {0,1,0,0,9};
    	List<List<Integer>> res = t.permuteUnique(nums);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
