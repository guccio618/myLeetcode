import java.util.*;


public class Q480_Sliding_Window_Median {
	// test case: [1] [k = 1], [2147483647,2147483647] [k = 2], 
	// [-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648] [k = 3]
	
	public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return new double[0];
        } else if(k > nums.length) {
            k = nums.length;
        }
        
        Queue<Double> maxHeap = new PriorityQueue<>();
        Queue<Double> minHeap = new PriorityQueue<>();
        Double median = null;
        int startPos = 0, len = nums.length;
        int index = 0;
        double[] ans = new double[len - k + 1];
                
        for(int i = 0; i < len; i++) {
            if(i - startPos + 1 > k) {
                if((double) nums[startPos] < median) {
                    maxHeap.remove(-(double) nums[startPos]);
                } else if((double) nums[startPos] > median){
                    minHeap.remove((double) nums[startPos]);
                } else {
                	median = (maxHeap.size() > minHeap.size()) ? -maxHeap.poll() : minHeap.poll();
                }
                
                startPos++;
            }
            
            if(median == null) {
            	median = (double) nums[i];
            } else if((double) nums[i] < median) {
                maxHeap.offer(-(double) nums[i]);
            } else {
                minHeap.offer((double) nums[i]);
            }
            
            while(maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.offer(-median);
                median = minHeap.poll();
            } 
            while(minHeap.size() < maxHeap.size()) {
                minHeap.offer(median);
                median = -maxHeap.poll();
            }
     
            if(i + 1 >= k) {
                if(k % 2 != 0) {
                    ans[index++] = (double) median;
                } else {
                    double num = (maxHeap.size() > minHeap.size()) ? -maxHeap.peek() : minHeap.peek();
                    ans[index++] = (median + num) / 2.0;
                }
            }
        }
        
        return ans;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************** main function ******************************************/
	
	public static void main(String[] args) {
		Q480_Sliding_Window_Median t = new Q480_Sliding_Window_Median();
//		int[] nums = {1,3,-1,-3,5,3,6,7};
//		int[] nums = {-1,-1,1,-1,-1,-1,1,1,1,1,-1,1,-1}; Integer.MAX_VALUE
		int[] nums = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE};
//		System.out.println(nums.length);
		int k = 3;
		double[] ans = t.medianSlidingWindow(nums, k);
		
		for(double elem : ans) {
			System.out.print(elem + " ");
		}
	}
}
