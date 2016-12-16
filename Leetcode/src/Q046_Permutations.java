import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Q046_Permutations {
	// test case:
    // nums is empty
    
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

	
	
	/******************************************************/
	// by Jackie using backtrack
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();
    
    public LinkedList<LinkedList<Integer>> permute2(int[] nums) {
        if(nums == null) return res;
        backtrack(nums, 0);
        return res;
    }
    
    public void backtrack(int[] nums, int curPos){
    	if(curPos == nums.length){
            LinkedList<Integer> path = new LinkedList<Integer>();
            for(int i = 0, len = nums.length; i < len; ++i)
            	path.add(nums[i]);
            res.add(new LinkedList<Integer>(path));
    	}
    	else{
    		for(int i = curPos, len = nums.length; i < len; ++i){
    			swap(nums, curPos, i);
    			backtrack(nums, curPos+1);
    			swap(nums, curPos, i);
    		}
    	}
    }
    
    public void swap(int[] nums, int x, int y){
    	int temp = nums[x];
    	nums[x] = nums[y];
    	nums[y] = temp;
    }
    
    
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
