import java.util.*;

public class Sliding_Window_Minimum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		
		int len = nums.length;
		int[] ans = new int[len - k + 1];
		int index = 0;		
		Deque<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!q.isEmpty() && nums[i] < nums[q.peekLast()]) {
				q.pollLast();
			}
			
			q.offer(i);
			
			if(i - q.peekFirst() + 1 > k){
				q.pollFirst();
			}
			
			if (i + 1 >= k) {
				ans[index++] = nums[q.peek()];
			}
		}
		return ans;
	}
}
