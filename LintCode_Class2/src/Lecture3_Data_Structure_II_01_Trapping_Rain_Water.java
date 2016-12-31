
public class Lecture3_Data_Structure_II_01_Trapping_Rain_Water {
	/****************************************************
	 * 取决于左边的最高和右边最高中的最小值，减去当前高度的差
	 * 
	 ****************************************************/
	
	public int trapRainWater(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[0] = left[len - 1] = right[len - 1] = 0;
        int res = 0;
        
        for(int i = 1; i < len - 1; ++i){
            left[i] = Math.max(left[i - 1], heights[i - 1]);
        }
        for(int i = len - 2; i > 0; --i){
            right[i] = Math.max(right[i + 1], heights[i + 1]);
        }
        
        for(int i = 1; i < len - 1; ++i){
            int waterNum = Math.min(left[i], right[i]) - heights[i];
            if(waterNum > 0){
                res += waterNum;
            }
        }
        return res;
    }
}
