import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class Lecture3_Data_Structure_II_07_Sliding_Window_Maximum {
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for(int i = 0; i < nums.length; ++i){
        	while((!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])) {  // 在i之前的元素，不大于nums[i]的元素没有必要记录，因为j肯定比i先剔除出
    			deque.pollLast();                                            // windows k的范围，因此，只要i存在，最大值肯定不会是nums[j]
    		} 
        	deque.offer(i);
        	if(i - deque.peekFirst() + 1 > k){   // 当当前index比第一个的index大k, 超过k的范围，应该剔除
        		deque.removeFirst();
        	}
        	if(i >= k - 1){                      // i至少需要大于k以后才开始存入ans
        		ans.add(nums[deque.peekFirst()]);
        	}
        }
        return ans;
    }
}
