
public class Le_260_Single_Number_III {
	/***************************************************************
	 * flag is the last "1" bit of n, the two elements which appear 
	 * only once must be different in this bit, so we can use flag to
	 * divide all the elements into two parts, one contains a and the 
	 * other one contains b
	 ***************************************************************/
	
	public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int xor = nums[0];
        int[] ans = new int[2];
        int n = nums.length;
        
        for(int i = 1; i < n; i++){
            xor ^= nums[i];
        }
        
        int bit = xor & ~(xor - 1);
        
        for(int num : nums){
            if((num & bit) > 0){
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        
        return ans;
    }
}
