public class Q055_Jump_Game {
	/*****************************************************/
	// by ninechapter using greedy
	public boolean canJump1(int[] nums) {
		if(nums == null || nums.length == 0){
            return true;
        }
        
        int len = nums.length;
        int fastest = nums[0];
        
        for(int i = 0; i < len; i++){
            if(fastest >= len - 1){
                return true;
            } else if(fastest < i){
                return false;
            }
            
            fastest = Math.max(fastest, nums[i] + i);
        }
        
        return fastest >= len - 1;
	}

	
	/*****************************************************/
	// by ninechapter using DP
	public boolean canJump2(int[] A) {
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
