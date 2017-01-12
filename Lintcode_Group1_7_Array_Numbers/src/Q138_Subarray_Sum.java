import java.util.ArrayList;
import java.util.HashMap;

public class Q138_Subarray_Sum {
	/*************************************************/
	// by ninechapter using hashmap， nine!
	public ArrayList<Integer> subarraySum(int[] nums) {
		// write your code here
		int len = nums.length;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		map.put(0, -1);     // 必须要此处的初始化，因为要考虑前n项为0的情况
	
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) { // 一个循环
				ans.add(map.get(sum) + 1);
				ans.add(i);
				return ans;
			}
			map.put(sum, i);
		}
		return ans;
	}
	
	
	/*************************************************/
	// by Jackie
	public ArrayList<Integer> subarraySum2(int[] nums) {
		// write your code here
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (nums == null) {
			return res;
		}
		for (int start = 0, len = nums.length; start < len; ++start) {
			int sum = 0;
			for (int end = start; end < len; ++end) {
				sum += nums[end];
				if (sum == 0) {
					res.add(start);
					res.add(end);
					return res;
				}
			}
		}
		return res;
	}

	
}
