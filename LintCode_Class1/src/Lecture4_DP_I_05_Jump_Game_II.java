
public class Lecture4_DP_I_05_Jump_Game_II {
	/***************************************************************************************
	 * 坐标型动态规划
	 * 		state:     f[i] 表示跳到i时的最小step数;
	 * 		function:  f[i] = Math.min(f[i], f[j]+1), 其中j < i && nums[j] + j >= i;
	 * 		initial:   f[0] = 0;
	 * 		answer:    f[n-1];
	 * 
	 ***************************************************************************************/
	
	public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int[] f = new int[len];
        for(int i = 1; i < len; ++i){
            f[i] = Integer.MAX_VALUE;
        }
        f[0] = 0;
        
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){
                if(nums[j] + j >= i){
                    f[i] = Math.min(f[i], f[j] + 1); 
                }
            }
        }
        return f[len - 1];
    }
}
