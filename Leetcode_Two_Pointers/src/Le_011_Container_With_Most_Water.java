/*************************************************************************
 *  Given n non-negative integers a1, a2, ..., an, where each represents 
 *  a point at coordinate (i, ai). n vertical lines are drawn such that 
 *  the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 *  which together with x-axis forms a container, such that the container 
 *  contains the most water.
 *  Note: You may not slant the container.
 *  
 *  对比题目见42题
 *  
 *  test case: [1, 1]
 *************************************************************************/


public class Le_011_Container_With_Most_Water {
	public int maxArea(int[] height) {
        if(height == null || height.length <= 1) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while(left < right) {
            int smallestHeight = Math.min(height[left], height[right]); // 定一个最低／最高值，低于它的往中间跑
            maxArea = Math.max(maxArea, smallestHeight * (right - left));
            
            while(left < right && smallestHeight >= height[left]) {
                left++;
            }
            
            while(left < right && smallestHeight >= height[right]) {
                right--;
            }
        }
        
        return maxArea;
    }
}
