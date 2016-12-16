/***********************************************************************************
 * 1:当num <= sum＋1时，sum可以得到扩展sum = sum + num;
 * 
 * 2:当num > sum＋1时，此时sum不可以直接扩展，因为此时由sum + num的到的范围并不是连续的，
 * 	 如{1，2，3} ,sum = 6,如果此时插入一个数字8，集合变为｛1，2，3，8｝这个时候是得不到7这个和的，
 * 	 所以只能再插入一个数字，这个时候为了尽可能增加sum，并保持连续性，最好的选择是插入sum＋1这个数字，
 * 
 * 	插入后更新sum ＝ sum*2+1；然后再把num和sum＋1进行比较，进行相应的处理，直到sum达到所需要的值。	
 *	由此可知，我们需要记录sum+1的值，假设n为我们的预期，那么当sum+1=n时，我们仍然要继续计算，
 *	因为这个时候sum=n-1,并没有达到我们的预期 需要注意的点：集合中的数字是int型的，
 *	但是sum的值可能超出int的范围
 * 
 ************************************************************************************/

public class Q330_Patching_Array {
	/**********************************************************/
	// by other using Greedy, nice!
	public int minPatches(int[] nums, int n) {
		int index = 0;
		int ans = 0;
		long currentRange = 0; // 当前能覆盖到的最大范围，必须从0开始

		while (currentRange < n) {
			if (index < nums.length && nums[index] <= currentRange + 1) {
				currentRange = currentRange + nums[index];
				index++;
			} else {
				ans++;
				currentRange = currentRange * 2 + 1; // 增添currentRange+1可以让currentRange增长的最快同时保证中间不出现裂口
			}
		}
		
		return ans;
	}
	
	
	
	/**********************************************************/
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
		Q330_Patching_Array t = new Q330_Patching_Array();
		int[] nums = {2, 3};
		System.out.println(t.minPatches(nums, 6));
	}
}
