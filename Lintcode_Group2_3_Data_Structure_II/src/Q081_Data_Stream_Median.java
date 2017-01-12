import java.util.PriorityQueue;
import java.util.Queue;


public class Q081_Data_Stream_Median {
	// by ninechapter using two PriorityQueue
	public int[] medianII(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int median = nums[0];
        int len = nums.length;
        int[] res = new int[len];
        res[0] = median;
        
        for(int i = 1; i < len; ++i){
        	if(nums[i] < median){
        		maxHeap.add(-nums[i]);
        	} else {
        		minHeap.add(nums[i]);
        	}
        	
        	if(maxHeap.size() + 1 < minHeap.size()){      // 个数为偶数个时
        		maxHeap.add(-median);
        		median = minHeap.poll();
        	} else if(minHeap.size() < maxHeap.size()){   // 个数为奇数个时
        		minHeap.add(median);
        		median = -maxHeap.poll();
        	}
        	res[i] = median;
        }
        
        return res;
	}
}
