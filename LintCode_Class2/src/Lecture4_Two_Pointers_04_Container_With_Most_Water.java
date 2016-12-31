
public class Lecture4_Two_Pointers_04_Container_With_Most_Water {
	public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int left = 0, right = n - 1; 
        int maxArea = -1;
        
        while(left < right){
            int H = Math.min(height[left], height[right]);
            int L = right - left;
            maxArea = Math.max(maxArea, H * L);
            while(left < right && height[left] <= H){
                left++;
            }
            while(left < right && height[right] <= H){
                right--;
            }
        }
        
        return maxArea;
    }
}
