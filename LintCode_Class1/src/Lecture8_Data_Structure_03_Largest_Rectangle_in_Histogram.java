import java.util.Stack;

/*********************************************************************************************
 * (1). 不可用DP做的原因：通常dp作用是使O(2^n)指数级别优化为O(n^2)，而O(n^2)优化为O(n)可以用栈，此题用单调栈
 * (2). 单调栈分递增和递减
 * (3). 枚举分析
 * (4). 递增栈可以记录从左到右的最大值或从右往左的最大值
 * (5). 时间负责度为O(n)，考虑每个数进出栈多少次来看时间复杂度
 *********************************************************************************************/

public class Lecture8_Data_Structure_03_Largest_Rectangle_in_Histogram {
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
				int width = stack.empty() ? i : i - stack.peek() - 1;  //必须如此，画图举例1,2,3,4,5,4,6,2
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
}
