import java.util.Stack;

public class Le_084_Largest_Rectangle_in_Histogram {
	/****************************************************
	 * 波峰图算法 递增栈
	 * 
	 ****************************************************/
	// by ninechapter
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0){
            return 0;
        }    
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        
        for(int i = 0; i <= heights.length; ++i){
            int current = (i == heights.length) ? -1 : heights[i];
           
            while(!stack.isEmpty() && current <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                int area = h * w;
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        
        return max;
	}
	
	
	/*************************************************/
	// by other
	public int maxArea2(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
 
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (stack.empty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.empty() ? i : i - stack.peek() - 1;  // 注意，用i-stack.peek()-1保险，防止(3,6,5,2), i=2的情况，
				area = Math.max(area, height[start] * width);
				i--;   // 当前的height[i]由于没有入栈，因此，需要重新判断入栈
				System.out.println("L = " + width + ", start = " + start);
			}
		}
		while (!stack.empty()) {    // 防止到最后一直是递增的情况
			int start = stack.pop();
			int width = stack.empty() ? height.length : height.length - stack.peek() - 1; // 注意：start为最后一个时,width = height.length, 
			area = Math.max(area, height[start] * width);
		}
		return area;
	}
	
	
	/****************************************************/
	// by Jackie using DP, but exceed time limit
	public int largestRectangleArea3(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int len = height.length;
        long maxArea = Integer.MIN_VALUE;
        int[][] minHeight = new int[len][len];
        
        for(int i = 0; i < len; ++i){
            for(int j = i+1; j < len; ++j){
                minHeight[i][i] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0; i < len; ++i){
            minHeight[i][i] = height[i];
        }
        
        for(int i = 0; i < len; ++i){
            for(int j = i+1; j < len; ++j){
                minHeight[i][j] = Math.min(minHeight[i][j-1], height[j]);
                maxArea = Math.max(maxArea, minHeight[i][j] * (j-i));
            }
        }
        return (int) maxArea;
    }
	
	
	public static void main(String[] args){
		Le_084_Largest_Rectangle_in_Histogram t = new Le_084_Largest_Rectangle_in_Histogram();
//		int[] height = {3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3};
		int[] height = {1,5,3,6,2,1};
		System.out.println(t.largestRectangleArea(height));
	}
}
