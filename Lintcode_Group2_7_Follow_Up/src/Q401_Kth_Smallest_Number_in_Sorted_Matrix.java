import java.util.PriorityQueue;
import java.util.Queue;


public class Q401_Kth_Smallest_Number_in_Sorted_Matrix {
	public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix[0] == null || k <= 0 || matrix.length * matrix.length < k){
            return 0;
        }
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        int n = matrix.length;
        int ans = 0;
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                maxHeap.add(-matrix[i][j]);
                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }
        
        ans = -maxHeap.peek();
        
        return ans;
    }
	
	
	public static void main(String[] args){
		Q401_Kth_Smallest_Number_in_Sorted_Matrix t = new Q401_Kth_Smallest_Number_in_Sorted_Matrix();
		int[][] matrix = {
				{1,5,7},
				{3,7,8},
				{4,8,9}
		};
		
		System.out.println(t.kthSmallest(matrix, 4));
	}
}
