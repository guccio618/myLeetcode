/******
 * 
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself 
a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. That means 
the first house is the neighbor of the last one. Meanwhile, the security 
system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * */

public class Q213_House_Robber_II {
	/***************************************************************
	 * 此题是198的follow up, 但是需要考虑到头尾的特殊情况，因此分两种情况讨论，
	 * 采用两组动态规划数组
	 * 
	 ***************************************************************/
	
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        
        int n = nums.length;
        int[] profit1 = new int[n];
        int[] profit2 = new int[n];
        
        profit1[0] = nums[0];
        profit1[1] = Math.max(nums[0], nums[1]);
        profit2[1] = nums[1];
        profit2[2] = Math.max(nums[1], nums[2]);
        
        for(int i = 2; i < n - 1; ++i){
            profit1[i] = Math.max(profit1[i - 2] + nums[i], profit1[i - 1]);
        }
        
        for(int i = 3; i < n; ++i){
            profit2[i] = Math.max(profit2[i - 2] + nums[i], profit2[i - 1]);
        }
        
        return Math.max(profit1[n - 2], profit2[n - 1]);
    }
	
	
	
	
	
	
	
	
	
	
	/************************* main function ****************************/
	//by jackie using DP
	public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int array1[] = new int[n-1];
        int array2[] = new int[n-1];
        for(int i = 0; i < n-1; i++)
        	array1[i] = nums[i];
        for(int i = 1; i < n; i++)
        	array2[i-1] = nums[i];       
        return Math.max(robArray(array1), robArray(array2));
    }
	
	public int robArray(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int n = nums.length;
        int res[] = new int[n];
        if(n >= 1) res[0] = nums[0];
        if(n >= 2) res[1] = Math.max(nums[0], nums[1]);
        if(n >= 3) res[2] = Math.max(nums[0] + nums[2], nums[1]);
        for(int i = 3; i < n; i++)
        	res[i] = Math.max(res[i-2], res[i-3]) + nums[i];
        if(n == 1) return res[0];
        else return Math.max(res[n-1], res[n-2]);
	}
	
	public static void main(String[] args){
		int[] array = {1,1,1,2};
		Q213_House_Robber_II test = new Q213_House_Robber_II();
		System.out.println(test.rob(array));
	}
}
