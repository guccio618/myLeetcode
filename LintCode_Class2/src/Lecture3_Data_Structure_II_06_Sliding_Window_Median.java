import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Lecture3_Data_Structure_II_06_Sliding_Window_Median {
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || k <= 0){
            return res;
        }
        if(k == 1){
            for(int i = 0; i < nums.length; ++i){
                res.add(nums[i]);
            }
            return res;
        }
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int median = nums[0];
        
        for(int i = 1; i < k; ++i){   // 前k个元素单独计算median
            if(nums[i] < median){
                maxHeap.add(-nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            
            if(maxHeap.size() + 1 < minHeap.size()){
                maxHeap.add(-median);
                median = minHeap.poll();
            } else if(minHeap.size() < maxHeap.size()){
                minHeap.add(median);
                median = -maxHeap.poll();
            }
        }
        
        res.add(median);
        
        for(int i = k; i < nums.length; ++i){
            if(maxHeap.contains(-nums[i - k])){         // nums[i - k] 在maxHeap上
        		maxHeap.remove(-nums[i - k]);
        	} else if(minHeap.contains(nums[i - k])){   // nums[i - k] 在minHeap上
        		minHeap.remove(nums[i - k]);
        	} 
        	else {                                      // nums[i - k] 在median上
        		if(maxHeap.size() > minHeap.size()){
        			median = -maxHeap.poll();
        		} else {
        			median = minHeap.poll();
        		}
        	}
        	
            if(nums[i] < median){
                maxHeap.add(-nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            
            if(maxHeap.size() + 1 < minHeap.size()){
                maxHeap.add(-median);
                median = minHeap.poll();
            } else if(minHeap.size() < maxHeap.size()){
                minHeap.add(median);
                median = -maxHeap.poll();
            }
            res.add(median);
        }
        
        return res;
    }
}
