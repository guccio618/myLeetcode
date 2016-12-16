import java.util.Stack;


/**************************************************************************
 * 注意： 最大的矩形的底部不一定出现在最后一行，因此需要每行遍历，运用O(n^2)的时间复杂度
 * 
 **************************************************************************/

public class Le_085_Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] heights = new int [row][col];
        int maxArea = 0;
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(i == 0){
                    heights[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                } else {
                    heights[i][j] = (matrix[i][j] == '1') ? heights[i - 1][j] + 1 : 0;
                }
            }
        }
        
        for(int i = 0; i < row; ++i){
        	Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j <= col; ++j){
                int currentHeight = (j == col) ? -1 : heights[i][j];  // j取到col，用于清除最后的col-1
                while(!stack.isEmpty() && currentHeight <= heights[i][stack.peek()]){
                    int h = heights[i][stack.pop()];
                    int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(j);
            }
//            stack.pop();    // 去除j = col的那次特例
        }
        
        return maxArea;
    }
	
	
	
	public static void main(String[] args){
		Le_085_Maximal_Rectangle t = new Le_085_Maximal_Rectangle();
		char[][] matrix = {
				{'0', '0'},
				{'0', '0'}
		};
		
		System.out.println(t.maximalRectangle(matrix));
	}
}
