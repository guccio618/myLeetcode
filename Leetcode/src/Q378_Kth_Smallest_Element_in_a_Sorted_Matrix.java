import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {
	// by other
	public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                return left.val - right.val;
            }
        });
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0; i < col; i++){
            heap.offer(new Node(0, i, matrix[0][i]));
        }
        
        for(int i = 0; i < k - 1; i++){
            Node node = heap.poll();
            
            if(node.x == row - 1){
                continue;
            }
            
            heap.offer(new Node(node.x + 1, node.y, matrix[node.x + 1][node.y]));
        }
        
        return heap.poll().val;
    }
    
    class Node {
        int x;
        int y;
        int val;
        
        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
