import java.util.PriorityQueue;
import java.util.Queue;

/*******************************************************
 * 应用heap来处理，解题思路：
 *	(1). 跟median对比，先加入对应的minHeap或manHeap
 *	(2). 进行调节
 *	(3). 调节的条件： minHeap.size() < maxHeap.size() 或
 *				   maxHeap.size() + 1 < minHeap.size()
 * 
 *******************************************************/

public class Le_295_Find_Median_from_Data_Stream {
	private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;
    private int median = 0;
    private int size = 0;
    
    public Le_295_Find_Median_from_Data_Stream(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(size++ == 0){
            median = num;
            return;
        } 

        if(num < median){
            maxHeap.offer(-num);
        } else {
            minHeap.offer(num);
        }
        
        if(maxHeap.size() + 1 < minHeap.size()){
            maxHeap.offer(-median);
            median = minHeap.poll();
        } else if(minHeap.size() < maxHeap.size()){
            minHeap.offer(median);
            median = -maxHeap.poll();
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(size % 2 != 0){
            return median;
        } else {
            int median_2 = 0;
            if(minHeap.size() > maxHeap.size()){
                median_2 = minHeap.peek();
            } else {
                median_2 = -maxHeap.peek();
            }
            
            return (median + median_2) / 2.0;
        }
    }
}
