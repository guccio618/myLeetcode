/*******************
 * 
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 * 
 * */

public class Le_073_Set_Matrix_Zeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
		
        int row = matrix.length;  
        int col = matrix[0].length;  
        int i, j;  
          
        //先标记第一行和第一列是否有0  
        boolean firstRow = false, firstCol = false;  
        
        for (j = 0; j < col; j++) {  
            if (0 == matrix[0][j]) {  
                firstRow = true;  
                break;  
            }  
        }  
        for (i = 0; i < row; i++) {  
            if (0 == matrix[i][0]) {  
                firstCol = true;  
                break;  
            }  
        }  
           
        //从第二行第二列还是遍历，如果遇到0，则把它所在行和列的第一个值设为0     
        for (i = 1; i < row; i++) {  
            for (j = 1; j < col; j++) {  
                if (0 == matrix[i][j]) {  
                    matrix[i][0] = 0;  
                    matrix[0][j] = 0;  
                }  
            }  
        }  
          
        //把第一列的0所在行都设为0，把第一行的0所在列都设为0  
        for (i = 1; i < row; i++) {  
            if (0 == matrix[i][0]) {  
                for (j = 1; j < col; j++) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  
        for (j = 1; j < col; j++) {  
            if (0 == matrix[0][j]) {  
                for (i = 1; i < row; i++) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  
          
        //根据标记决定第一行和第一列是否全设为0  
        if (firstRow) {  
            for (j = 0; j < col; j++) {  
                matrix[0][j] = 0;  
            }  
        }  
        if (firstCol) {  
            for (i = 0; i < row; i++) {  
                matrix[i][0] = 0;  
            }  
        }  
    }
	
	
	
	
	
	
	
	
	/****************************************************/
	// by other
	public void setZeroes2(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int m = matrix.length, n = matrix[0].length;
		boolean row = false, col = false;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						row = true;
					else if (j == 0)
						col = true;
					else {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}
		for (int i = m - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--)
				if (i == 0 && row == true || j == 0 && col == true
						|| matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
		return;
	}
	
	
	public static void main(String[] args){
		Le_073_Set_Matrix_Zeroes t = new Le_073_Set_Matrix_Zeroes();
		int[][] matrix = {
				{1,2,3,0,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
		};
		t.setZeroes(matrix);
		
		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0 ; j < matrix[i].length; ++j)
				System.out.print(matrix[i][j] + ", ");
			System.out.println();
		}
	}
}
