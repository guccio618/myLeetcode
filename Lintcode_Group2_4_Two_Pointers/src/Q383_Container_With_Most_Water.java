
public class Q383_Container_With_Most_Water {
	// by Jackie
	public int maxArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int maxArea = -1;
        int left = 0, right = len - 1;
        
        while(left < right){
            int H = Math.min(heights[left], heights[right]);
            int L = right - left;
            maxArea = Math.max(maxArea, H * L);
            while(left < right && heights[left] <= H){
                left++;
            }
            while(left < right && heights[right] <= H){
                right--;
            }
        }
        return maxArea;
    }
}
