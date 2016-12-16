import java.util.Arrays;
import java.util.LinkedList;


public class Q090_Subsets_II {
	/******************************************************/
	// by Jackie
	private LinkedList<LinkedList<Integer>> res = new LinkedList<LinkedList<Integer>>();

	public LinkedList<LinkedList<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null) return res;
		LinkedList<Integer> path = new LinkedList<Integer>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		res.add(new LinkedList<Integer>(path));
		for (int i = 1, len = nums.length; i <= len; ++i) {
			for (int j = 0; j < len; ++j){
				backtrack(nums, j, i, path, visited);
				while(j+1 < len && nums[j+1] == nums[j]) ++j;
			}
		}
		return res;
	}

	public void backtrack(int[] nums, int curPos, int num, LinkedList<Integer> path, boolean[] visited) {
		if (visited[curPos] == true) return;
		visited[curPos] = true;
		path.add(nums[curPos]);
		if (path.size() == num) {
			res.add(new LinkedList<Integer>(path));
		}
		for (int i = curPos + 1; i < nums.length; ++i) {
			backtrack(nums, i, num, path, visited);		
			while(i+1 < nums.length && nums[i] == nums[i+1]) ++i;
		}
		path.remove(path.size() - 1);
		visited[curPos] = false;
	}
	
	
	public static void main(String[] args){
		Q090_Subsets_II t = new Q090_Subsets_II();
    	int[] candidates = {1,2,2};
    	LinkedList<LinkedList<Integer>> res = t.subsetsWithDup(candidates);
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
