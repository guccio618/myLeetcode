import java.util.Stack;
/*********
 * 
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 6.
 * 
 * */

/**************************************************************************
 * 注意： 最大的矩形的底部不一定出现在最后一行，因此需要每行遍历，运用O(n^2)的时间复杂度
 * 
 **************************************************************************/

public class Q085_Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] heights = new int[row][col];
        int maxArea = 0;
        
        for(int i = 0; i < col; i++){
            heights[0][i] = matrix[0][i] - '0';
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            Stack<Integer> stack = new Stack<Integer>();
            
            for(int j = 0; j <= col; j++){
                int curHeight = (j == col) ? Integer.MIN_VALUE : heights[i][j];
                
                while(!stack.isEmpty() && curHeight <= heights[i][stack.peek()]){
                    int H = heights[i][stack.pop()];
                    int L = stack.isEmpty() ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, H * L);
                }
                
                stack.push(j);
            }
        }
        
        return maxArea;
    }
	
	
	
	
	
	
	/*** main function ***/
	public static void main(String[] args){
		Q085_Maximal_Rectangle t = new Q085_Maximal_Rectangle();
		char[][] matrix = {
				{'0', '0'},
				{'0', '0'}
		};
		
		System.out.println(t.maximalRectangle(matrix));
	}
}
