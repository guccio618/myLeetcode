import java.util.Deque;
import java.util.LinkedList;


public class Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        
        Deque<Integer> dq = new LinkedList<>();
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int index = 0;
        
        for(int i = 0; i < len; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            
            while(i - dq.peekFirst() + 1 > k) {
                dq.pollFirst();
            }
            
            if(i + 1 >= k) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        
        return ans;
    }
}
