import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*******************************************************************************************************************
 * 1. Build a minHeap of elements from the first row.
 * 2. Do the following operations k-1 times :
 * 		Every time when you poll out the root(Top Element in Heap), 
 * 		you need to know the row number and column number of that element(so we can create a tuple class here), 
 * 		replace that root with the next element from the same column.
 * 
 * 类似算分公式，分布式的做法，哪个column被取出，就以此column就补上下一个元素
 * 
 ********************************************************************************************************************/

public class Q373_Find_K_Pairs_with_Smallest_Sums {
	// by other, time complexity O(n * k * logn)
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<int[]>();
        
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return ans;
        }
        
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                return left.val - right.val;
            }
        });
        
        int len1 = nums1.length, len2 = nums2.length;
        
        for(int i = 0; i < len2; i++){
            heap.offer(new Node(0, i, nums1[0] + nums2[i]));
        }
        
        for(int i = 0; i < k && i < len1 * len2; i++){
            Node node = heap.poll();
            
            ans.add(new int[]{nums1[node.x], nums2[node.y]});
            
            if(node.x == len1 - 1){
                continue;
            }
            
            heap.offer(new Node(node.x + 1, node.y, nums1[node.x + 1] + nums2[node.y]));
        }
        
        return ans;
    }
    
    class Node{
        int x;
        int y;
        int val;
        
        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
	
    
    
    /**********************************************************************************/
    // by Jackie, time complexity O(n * n * logn)
	public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return ans;
        }
        
        Queue<Node2> heap = new PriorityQueue<Node2>(1, new Comparator<Node2>(){
            public int compare(Node2 left, Node2 right){
                return (left.x + left.y) - (right.x + right.y);
            }
        });
        
        int curMaxValue = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums1.length; i++){
            if(heap.size() >= k && curMaxValue <= nums1[i] + nums2[0]){
                break;
            }
            
            for(int j = 0; j < nums2.length; j++){
            	curMaxValue = Math.max(curMaxValue, nums1[i] + nums2[j]);
                heap.offer(new Node2(nums1[i], nums2[j]));
            }
        }
        
        for(int i = 0; i < k && !heap.isEmpty(); i++){
            Node2 node = heap.poll();
            ans.add(new int[]{node.x, node.y});
        }
        
        return ans;
    }
    
    class Node2{
        int x;
        int y; 
        
        public Node2(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public static void main(String[] arge){
    	Q373_Find_K_Pairs_with_Smallest_Sums t = new Q373_Find_K_Pairs_with_Smallest_Sums();
    	int[] nums1 = {1,1,2};
    	int[] nums2 = {1,2,3};
    	
    	t.kSmallestPairs(nums1, nums2, 2);
    }
    
}
