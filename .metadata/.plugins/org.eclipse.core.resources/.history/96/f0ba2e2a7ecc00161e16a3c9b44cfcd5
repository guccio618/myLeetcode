import java.util.ArrayList;
import java.util.List;
/*******
 * 
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

 * 
 * */

public class Q054_Spiral_Matrix {
	// test case: [[2,3]],  [[2], [3]],  [ ], [[1]], 
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix[0].length - 1;
        
        while(row_start <= row_end && col_start <= col_end){     // 注意有等号 ！！！
            for(int i = col_start; i <= col_end; ++i){
                ans.add(matrix[row_start][i]);
            }
            row_start++;
            
            for(int i = row_start; i <= row_end; ++i){
                ans.add(matrix[i][col_end]);
            }
            col_end--;
            
            if (row_start <= row_end) {          // 防止 test case [[2,3]],  [[2], [3]], 注意是row  ！！！
                for(int i = col_end; i >= col_start; --i){
                    ans.add(matrix[row_end][i]);
                }
            }
            row_end--;      // 移动继续，为了可以顺利退出，不会死循环，放在if之外 ！！！
            
            if(col_start <= col_end){            // 防止 test case [[2,3]],  [[2], [3]], 注意是col ！！！
                for(int i = row_end; i >= row_start; --i){
                    ans.add(matrix[i][col_start]);
                }
            }
            col_start++;   // 移动继续，为了可以顺利退出，不会死循环，放在if之外 ！！！
        }
        
        return ans;
    }
	
	
	
	
	
	/******************************** main function **************************************/  
	public static void main(String[] args){
		Q054_Spiral_Matrix t = new Q054_Spiral_Matrix();  
		int[][] matrix0 = {
				{3},
				{2}
		};
		
		int[][] matrix1 = {
				{2,3},
		};
		
		int[][] matrix2 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int[][] matrix3 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		
		List<Integer> res = t.spiralOrder(matrix1);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
		System.out.println();
		
//		List<Integer> res2 = t.spiralOrder(matrix2);
//		for(int i = 0; i < res2.size(); ++i){
//			System.out.print(res2.get(i) + ", ");
//		}
//		System.out.println();
//		
//		List<Integer> res3 = t.spiralOrder(matrix3);
//		for(int i = 0; i < res3.size(); ++i){
//			System.out.print(res3.get(i) + ", ");
//		}
	}
}
