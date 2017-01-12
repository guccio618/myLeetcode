import java.util.Stack;


public class Q122_Largest_Rectangle_in_Histogram {	
	// by other
	public int largestRectangleArea(int[] height) {
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
				int width = stack.empty() ? i : i - stack.peek() - 1;
				area = Math.max(area, height[start] * width);
				i--;   
			}
		}
		while (!stack.empty()) {    
			int start = stack.pop();
			int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
			area = Math.max(area, height[start] * width);
		}
		return area;
    }
	
	// by ninechapter
		public int largestRectangleArea2(int[] height) {
	        if (height == null || height.length == 0) {
	            return 0;
	        }
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        int max = 0;
	        for (int i = 0; i <= height.length; i++) {
	            int curt = (i == height.length) ? -1 : height[i];
	            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
	                int h = height[stack.pop()];
	                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	                max = Math.max(max, h * w);
	            }
	            stack.push(i);
	        }
	        
	        return max;
	    }
}
