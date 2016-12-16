import java.util.HashSet;


public class Le_128_Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}        
		
		int ans = 1;
		HashSet<Integer> set = new HashSet<Integer>();
		int n = nums.length;
		
		for(int i : nums){
			set.add(i);
		}
		
		for(int i = 0; i < n; i++){
			if(set.contains(nums[i])){
				int left = nums[i];
				while(set.contains(left - 1)){
					left--;
					set.remove(left);
				}
				int right = nums[i];
				while(set.contains(right + 1)){
					right++;
					set.remove(right);
				}
				ans = Math.max(ans, right - left + 1);
			}
		}
		
		return ans;
	}
	

	
	
	public static void main(String[] args){
		Le_128_Longest_Consecutive_Sequence t = new Le_128_Longest_Consecutive_Sequence();
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(t.longestConsecutive(nums));
	}
}
