import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/******
 * 
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note: 
	You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * */

public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {
	// time is O( (n+k)*logn )
	public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        Queue<Pair> heap = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.val - p2.val;
            }
        });
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0; i < col; i++){
            heap.offer(new Pair(0, i, matrix[0][i]));
        }
        
        for(int i = 0; i < k - 1; i++){
        	Pair node = heap.poll();
            
            if(node.x == row - 1){
                continue;
            }
            
            heap.offer(new Pair(node.x + 1, node.y, matrix[node.x + 1][node.y]));
        }
        
        return heap.poll().val;
    }
    
    class Pair {
        int x;
        int y;
        int val;
        
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
