import java.util.HashMap;
import java.util.Map;


public class Other_Maximum_Palindrome_Subarray {
	public int findMaximumPalindromeSubarray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int oddNum = 0;
		int evenNum = 0;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();			
			evenNum += (count / 2) * 2;
			oddNum = (oddNum == 1) ? 1 : (count % 2);
		}
		
		return evenNum + oddNum;
	}
	
	public static void main(String[] args) {
		Other_Maximum_Palindrome_Subarray t = new Other_Maximum_Palindrome_Subarray();
		int[] nums = {4, 4, 1, 2, 4, 4};
		System.out.println(t.findMaximumPalindromeSubarray(nums));
	}
}
