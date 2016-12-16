import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;


public class Le_239_Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
	
	
	
	// by Jackie using heap
	public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || k <= 0 || nums.length < k){
            return new int[0];
        } else if(k == 1){
            return nums;
        }
        
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        Queue<Integer> heap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < k; i++){
            heap.offer(-nums[i]);
        }
        
        ans[0] = -heap.peek();
        
        for(int i = k; i < nums.length; i++){
            heap.remove(-nums[i - k]);
            heap.offer(-nums[i]);
            ans[i - k + 1] = -heap.peek();
        }
        
        return ans;
    }
}
