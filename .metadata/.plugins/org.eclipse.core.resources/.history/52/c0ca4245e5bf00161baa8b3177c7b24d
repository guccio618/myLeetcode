/******
 * 
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 * 
 * */


public class Q042_Trapping_Rain_Water {
	/**************************************************************************************
	 * (1). 每一个height[i]上的蓄水数等于其 min(left[maxHeight], right[maxHeight]) - height[i];
	 * (2). 用memory分别记录当前结点对应的左边和右边的最大高度
	 * 对比题目见11题
	 * 
	 **************************************************************************************/
	// Solution 1: using two pointers, time is O(n), space is O(1)
	public int trap(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int waterCount = 0;
        
        while(left < right) {
            int smallestHeight = Math.min(height[left], height[right]);
            
            while(left < right && smallestHeight >= height[left]) {
                waterCount += smallestHeight - height[left];
                left++;
            }
            
            while(left < right && smallestHeight >= height[right]) {
                waterCount += smallestHeight - height[right];
                right--;
            }
        }
        
        return waterCount;
    }
	
	
	
	
	// Solution 2: using DP, time complexity O(n), space 0(n)
	public int trap3(int[] height) {
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
