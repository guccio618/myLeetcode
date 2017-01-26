import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*******
 * 
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space. 

 * 
 * */

public class Le_229_Majority_Element_II {
	/*********************************************************************************************************
	 * The basic idea is based on Moore's Voting Algorithm, we need two candidates with top 2 frequency. 
	 * If meeting different number from the candidate, then decrease 1 from its count, 
	 * or increase 1 on the opposite condition. Once count equals 0, then switch the candidate to the current number.
	 * The trick is that we need to count again for the two candidates after the first loop. 
	 * Finally, output the numbers appearing more than n/3 times.
	 *********************************************************************************************************/
	// using Moore's Voting Algorithm
	
	public List<Integer> majorityElement(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0) return res;
		int count[] = new int[2];
		Integer x[] = new Integer[2];

		x[0] = 0;
		x[1] = 1;
		for (int i = 0; i < nums.length; i++) {
			if (x[0] == nums[i])
				count[0]++;
			else if (x[1] == nums[i])
				count[1]++;
			else if (count[0] == 0) {
				x[0] = nums[i];
				count[0] = 1;
			} 
			else if (count[1] == 0) {
				x[1] = nums[i];
				count[1] = 1;
			} 
			else {
				count[0]--;                // count--放在 count == 0之后，防止第一次进入的时候不会出错！！！
				count[1]--;
			}
		}
		
		Arrays.fill(count, 0);
		for (int i : nums) {    // Count again for x1, x2
			if (i == x[0])
				count[0]++;
			else if (i == x[1])
				count[1]++;
		}
		for (int j = 0; j < 2; j++) {
			if (count[j] > nums.length / 3 && !res.contains(x[j]))
				res.add(x[j]);
		}
		return res;
	}

	
	
	
	
	
	
	
	
	
	/************************** main function ***************************/
	// by other, slow	
	public List<Integer> majorityElement2(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}

		for (Integer in : map.keySet()) { // there is at most 2 numbers that
											// appear more than 1/3 times.
			if (map.get(in) > nums.length / 3)
				list.add(in);
		}

		return list;
	}
	
	
	public static void main(String[] args){
		Le_229_Majority_Element_II t = new Le_229_Majority_Element_II();
		int[] nums = {5, 5, 5, 4, 3, 2, 1, 6};
		List<Integer> res = t.majorityElement(nums);
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
	}
}
