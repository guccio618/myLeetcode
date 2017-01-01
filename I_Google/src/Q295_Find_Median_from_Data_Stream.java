import java.util.Queue;
import java.util.PriorityQueue;
/*****
 * 
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2

 * 
 * */


public class Q295_Find_Median_from_Data_Stream {
	/*******************************************************
	 * 应用heap来处理，解题思路：
	 *	(1). 跟median对比，先加入对应的minHeap或manHeap
	 *	(2). 进行调节
	 *	(3). 调节的条件： minHeap.size() < maxHeap.size() 或
	 *				   maxHeap.size() + 1 < minHeap.size()
	 * 
	 *******************************************************/
	
    private Queue<Integer> maxHeap = new PriorityQueue<Integer>();
    private Queue<Integer> minHeap = new PriorityQueue<Integer>();
    private int median;
    private int size = 0;

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(size++ == 0){
            median = num;
            return;
        }

        if(num < median){
            maxHeap.add(-num);
        } else{
            minHeap.add(num);
        }
        
        if(maxHeap.size() + 1 < minHeap.size()){      // 置换median的边界条件； 使用＋1会提高速度
            maxHeap.add(-median);
            median = minHeap.poll();
        } else if(maxHeap.size() > minHeap.size()){   // 置换median的边界条件
            minHeap.add(median);
            median = -maxHeap.poll();
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(size % 2 != 0){
            return median;
        } else{
            int median_2 = 0;
            if(maxHeap.size() > minHeap.size()){
                median_2 = -maxHeap.peek();            // 注意用 peek() !!!
            } else{
                median_2 = minHeap.peek();
            }
            return (median + median_2) / 2.0;
        }
    }
    
    
    
    
    
    
    
    
    
    /*********************** main function *******************************/
    
    public static void main(String[] args){
    	Q295_Find_Median_from_Data_Stream t = new Q295_Find_Median_from_Data_Stream();
    	t.addNum(0);
    	t.addNum(0);
    	System.out.println(t.findMedian());
    	double a = Double.MAX_VALUE;
    }
}
