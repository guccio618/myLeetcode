/****
 * 
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
	Given nums = [-2, 0, 3, -5, 2, -1]

	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3

Note:
	You may assume that the array does not change.
	There are many calls to sumRange function.
 * 
 * */


public class Le_303_Range_Sum_Query_Immutable {
	private int[] sum;

    public Le_303_Range_Sum_Query_Immutable(int[] nums) {
        sum = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0) ? nums[i] : sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || i >= sum.length || j < 0 || j >= sum.length || i > j) {
            return -1;
        }
        
        return (i == 0) ? sum[j] : sum[j] - sum[i-1];
    }
    
    
    
    
    
    
    
    /***** main function ******/
    public static void main(String[] args){
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	Le_303_Range_Sum_Query_Immutable t = new Le_303_Range_Sum_Query_Immutable(nums);
    	System.out.println(t.sumRange(0, 2));
    	System.out.println(t.sumRange(2, 5));
    	System.out.println(t.sumRange(0, 5));
    	
    }
}
