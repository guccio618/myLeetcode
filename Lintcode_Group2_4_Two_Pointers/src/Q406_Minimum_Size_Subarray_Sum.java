public class Q406_Minimum_Size_Subarray_Sum {
	/******************************************************/
	// by ninechapter
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
	
	
	/******************************************************/
	// by Jackie
	public int minimumSize2(int[] nums, int s) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return (nums[0] == s) ? 1 : -1;
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0, len = nums.length;
        int sum = nums[0];
        
        while(right < len){
            if(sum < s){
                if(right == len - 1){
                    break;
                }
                sum += nums[++right];
            } else {           
            	int curLen = right - left + 1;
                minLen = Math.min(minLen, curLen);
                if(left == right && right < len - 1){
                    left++;
                    right++;
                    sum = nums[left];
                } else {
                    sum -= nums[left];
                    left++;
                }
            }
        }
        
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
	

	
	public static void main(String[] args){
		Q406_Minimum_Size_Subarray_Sum t = new Q406_Minimum_Size_Subarray_Sum();
		int[] nums = {100,50,99,50,100,50,99,50,100,50};
		System.out.println(t.minimumSize2(nums, 250));
		System.out.println(t.minimumSize2(nums, 250));
	}
}
