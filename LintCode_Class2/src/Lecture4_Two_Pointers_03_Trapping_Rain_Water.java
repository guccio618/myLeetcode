
public class Lecture4_Two_Pointers_03_Trapping_Rain_Water {
	public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        
        for(int i = 1; i < n; ++i){
            left[i] = Math.max(left[i - 1], height[i]);
        }
        
        for(int i = n - 2; i >= 0; --i){
            right[i] = Math.max(right[i + 1], height[i]);
        }
        
        for(int i = 1; i < n - 1; ++i){
            ans += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        
        return ans;
    }
}
