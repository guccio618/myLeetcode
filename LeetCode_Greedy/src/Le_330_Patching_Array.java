/*******
 * 
Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
 * 
 * */

public class Le_330_Patching_Array {
	/*****************************************************************************************************************************
	 * 1:当num <= currentRange＋1时，sum可以得到扩展currentRange = currentRange + num;
	 * 
	 * 2:当num > currentRange＋1时，此时sum不可以直接扩展，因为此时由currentRange + num的到的范围并不是连续的，
	 * 	 如{1，2，3} ,currentRange = 6,如果此时插入一个数字8，集合变为｛1，2，3，8｝这个时候是得不到7这个和的，
	 * 	 所以只能再插入一个数字，这个时候为了尽可能增加currentRange，并保持连续性，最好的选择是插入currentRange＋1这个数字，
	 * 
	 * 	插入后更新currentRange ＝ currentRange*2+1；然后再把num和currentRange＋1进行比较，进行相应的处理，直到currentRange达到所需要的值。	
	 *	由此可知，我们需要记录currentRange+1的值，假设n为我们的预期，那么当currentRange+1=n时，我们仍然要继续计算，
	 *	因为这个时候currentRange=n-1,并没有达到我们的预期 需要注意的点：集合中的数字是int型的，
	 *	但是currentRange的值可能超出int的范围
	 * 
	 ******************************************************************************************************************************/
	
	// test case: [1,2,31,33] [2147483647] -> 28
	
	// using Greedy
	public int minPatches(int[] nums, int n) {
		int index = 0;
		int count = 0;
		long curRange = 0; // 当前能覆盖到的最大范围，必须从0开始 ！！！ 防止test case: [1,2,31,33] [2147483647]

		while (curRange < n) {
			if (index < nums.length && nums[index] <= curRange + 1) {
				curRange = curRange + nums[index];
				index++;
			} else {
				curRange = curRange * 2 + 1; // 增添currentRange+1可以让currentRange增长的最快同时保证中间不出现裂口
				count++;
			}
		}
		
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*************************** main function *******************************/
	// by ninechapter, easily unstand
	public int minPatches2(int[] nums, int n) {
		long sumRange = 0;
		int index = 0;
		int ans = 0;
		
		if(nums.length > 0 && nums[0] == 1){
			sumRange = 1;
			index = 1;
		}
		
		while(sumRange < n){
			while(index < nums.length && nums[index] <= sumRange){
				sumRange += nums[index];
				index++;
			}
			
			if(sumRange < n){
				if(index < nums.length && nums[index] == sumRange + 1){
					index++;
				} else {
					ans++;
				}
				sumRange = sumRange * 2 + 1;
			}
		}
		
		return ans;
	}
	
	
	public static void main(String[] args){
		Le_330_Patching_Array t = new Le_330_Patching_Array();
		int[] nums = {2, 3};
		System.out.println(t.minPatches(nums, 6));
	}
}
