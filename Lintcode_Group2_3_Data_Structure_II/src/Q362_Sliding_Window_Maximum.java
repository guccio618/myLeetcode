import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q362_Sliding_Window_Maximum {
	/****************************************************************************
	 * 用一个linkedlist保存进入窗口的数的index. 例如： 1，3，－1，先存入1，如果3出现, 
	 * 则1没有可能是最大值. 所以可以移除1. 然后-1出现. 这个时候不能移除3. 因为3可能是最大值.  
	 * 也就是说如果后出现的数比先出现的数要大, 则可以删除之前的数. 当list顶部的index超出窗口时,
	 * 则移除. 这样list中的数应该是降序排列, 分别是[最大的数, 第2大的数, 第3大的数, ....]
	 * 
	 ****************************************************************************/
	// by ninechapter using stack
	
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        for(int i = 0; i < nums.length; ++i){
        	while((!deque.isEmpty() && nums[i] > nums[deque.peekLast()])) {
    			deque.pollLast();    // 保证
    		} 
        	deque.offer(i);
        	if(i - deque.peekFirst() + 1 > k){
        		deque.removeFirst();
        	}
        	if(i >= k - 1){          // 至少从0开始访问到k个数后才开始存入res
        		res.add(nums[deque.peekFirst()]);
        	}
        }
        return res;
    }
	
	public int[] maxSlidingWindow3(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Deque<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; ++i){
            while(!list.isEmpty() && nums[i] > nums[list.peek()]){
                list.pollLast();
            }
            list.offer(i);
            if(i - list.peek() + 1 > k){
                list.pollFirst();
            }
            if(i >= k - 1){
                res.add(nums[list.peek()]);
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); ++i){
            ans[i] = res.get(i);
        }
        return ans;
    }
	
	// by Jackie but exceed time limit
	public ArrayList<Integer> maxSlidingWindow2(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return res;
        }
        if(k == 1){
            for(int i = 0; i < nums.length; ++i){
                res.add(nums[i]);
            }
            return res;
        }
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < k; ++i){
            maxHeap.add(-nums[i]);
        }
        
        res.add(-maxHeap.peek());
        
        for(int i = 1; i <= nums.length - k; ++i){
            maxHeap.remove(-nums[i - 1]);
            maxHeap.add(-nums[i + k - 1]);
            res.add(-maxHeap.peek());
        }
        return res;
    }
	
	
	
	public static void main(String[] args){
		Q362_Sliding_Window_Maximum t = new Q362_Sliding_Window_Maximum();
		int[] nums = {1,2,7,7,2,10,3,4,5};
		ArrayList<Integer> res = t.maxSlidingWindow(nums, 2);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
