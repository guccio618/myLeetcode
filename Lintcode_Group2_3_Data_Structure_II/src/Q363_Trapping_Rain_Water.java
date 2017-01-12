
public class Q363_Trapping_Rain_Water {
	/**************************************************************************************
	 * (1). 每一个height[i]上的蓄水数等于其 min(left[maxHeight], right[maxHeight]) - height[i];
	 * (2). 用memory分别记录当前结点对应的左边和右边的最大高度
	 **************************************************************************************/
	// by Jackie
	
	public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[0] = left[len - 1] = right[len - 1] = 0;
        int res = 0;
        
        for(int i = 1; i < len - 1; ++i){
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for(int i = len - 2; i > 0; --i){
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        
        for(int i = 1; i < len - 1; ++i){
            int waterNum = Math.min(left[i], right[i]) - height[i];
            if(waterNum > 0){
                res += waterNum;
            }
        }
        return res;
    }
}
