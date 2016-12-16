import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;

/******
 * 
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

 * 
 * */


public class Le_239_Sliding_Window_Maximum {
	// solution 1: using priority queue, time is O(n^2), space O(n)
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override 
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        
        int startIndex = 0;
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        
        for(int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            
            if(i + 1 >= k) {
                if(i - startIndex + 1 > k) {
                    maxHeap.remove(nums[startIndex++]);
                }
                
                ans[index++] = maxHeap.peek(); 
            }
        }
        
        return ans;
    }
    
    
	
	// solution 2: using deque, time is O(n), space O(n)
    public int[] maxSlidingWindow2(int[] nums, int k) {
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
	

	
    
    
    
    
    
    /********************** main function **************************/
    
	public static void main(String[] args){
		Le_239_Sliding_Window_Maximum t = new Le_239_Sliding_Window_Maximum();
		int[] nums = {1, -1};
		int[] ans = t.maxSlidingWindow2(nums, 1);
		for(int i = 0; i < ans.length; ++i){
			System.out.print(ans[i] + ", ");
		}
	}
}
