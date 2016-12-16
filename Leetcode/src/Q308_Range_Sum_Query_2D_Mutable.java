
public class Q308_Range_Sum_Query_2D_Mutable {
	private int[][] matrix;
    private int[][] colSum;

    public Q308_Range_Sum_Query_2D_Mutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;   
        }
        
        this.matrix = matrix;
        int row = matrix.length;
        int col = matrix[0].length;
        colSum = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                colSum[i][j] = (i == 0) ? matrix[i][j] : colSum[i - 1][j] + matrix[i][j]; 
            }
        }
    }

    public void update(int row, int col, int val) {
        for(int i = row; i < matrix.length; i++) {
            colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
        }
        
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        
        for(int i = col1; i <= col2; i++) {
            int topPart = (row1 == 0) ? 0 : colSum[row1 - 1][i];
            ans += colSum[row2][i] - topPart;
        }
        
        return ans;
    }
    
    
    
    
    public static void main(String[] args) {
    	int[][] matrix = {
    			{2, 4},
    			{-3, 5}
    	};
    	
    	Q308_Range_Sum_Query_2D_Mutable t = new Q308_Range_Sum_Query_2D_Mutable(matrix);
    	t.update(0, 1, 3);
    	t.update(1, 1, -3);
    	t.update(0, 1, 1);
    	System.out.println(t.sumRegion(0, 0, 1, 1));
    }
}
