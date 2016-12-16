/*****************************************************************
 * Given an array of integers, every element appears twice except 
 * for one. Find that single one.
 *****************************************************************/


public class Q136_Single_Number {
	// by Jackie
	public int singleNumber(int[] nums) {
		if(nums == null) return 0;
		int res = 0;
		for(int i = 0, len = nums.length; i < len; ++i){
			res ^= nums[i]; 
		}
		return res;
    }
	
/*****************************************************************/	
	public static void main(String[] args){
		Q136_Single_Number t = new Q136_Single_Number();
		int[] nums = {1,1,2,2,3,4,4,5,5};
		System.out.println(t.singleNumber(nums));
	}
}
