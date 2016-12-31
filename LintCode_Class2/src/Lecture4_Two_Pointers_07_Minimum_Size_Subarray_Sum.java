
public class Lecture4_Two_Pointers_07_Minimum_Size_Subarray_Sum {
	public int minimumSize(int[] nums, int s) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(left = 0; left < nums.length; ++left){
        	while(right < nums.length && sum < s){
        		sum += nums[right];
        		right++;
        	}
        	if(sum >= s){
        		minLen = Math.min(minLen, right - left);
        		sum -= nums[left];
        	}
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
