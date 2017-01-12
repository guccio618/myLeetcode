import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q360_Sliding_Window_Median {
	// by Jackie using Priority Queued
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || k <= 0){
            return res;
        }
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        int median = nums[0];
        
        for(int i = 1; i < k; ++i){
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
        
        for(int i = k; i <= nums.length - k + 1; ++i){
        	if(maxHeap.contains(-nums[i - k])){
        		maxHeap.remove(-nums[i - k]);
        	} else if(minHeap.contains(nums[i - k])){
        		minHeap.remove(nums[i - k]);
        	} else {
        		if(maxHeap.size() > minHeap.size()){
        			median = maxHeap.poll();
        		} else {
        			median = minHeap.poll();
        		}
        	}
        	
        	System.out.println("i = " + i + ": median = " + median);
            
            if(nums[i] < median){
                maxHeap.add(-nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            
            if(maxHeap.size() + 1 < minHeap.size()){
                maxHeap.add(-median);
                median = minHeap.poll();
                System.out.println("2: median = " + median);
            } else if(minHeap.size() < maxHeap.size()){
                minHeap.add(median);
                median = -maxHeap.poll();
                System.out.println("3: median = " + median);
            }
            System.out.println("4: median = " + median);
            res.add(median);
        }
        
        return res;
    }
	
	
	
	public static void main(String[] args){
		Q360_Sliding_Window_Median t = new Q360_Sliding_Window_Median();
		int[] nums = {1,2,7,7,2,10,3,4,5};
		ArrayList<Integer> res = t.medianSlidingWindow(nums, 2);
		
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
	}
}
