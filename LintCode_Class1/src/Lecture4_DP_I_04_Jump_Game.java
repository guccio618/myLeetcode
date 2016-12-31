
public class Lecture4_DP_I_04_Jump_Game {
	/***************************************************************************************
	 * 坐标型动态规划
	 * 		state:     can[i] 表示是否可以跳到i;
	 * 		function:  can[i] = (can[j] && j + A[j] >= i && j < i);
	 * 		initial:   can[0] = true;
	 * 		answer:    f[n-1];
	 * 
	 ***************************************************************************************/
	
	public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[A.length - 1];
    }
}
