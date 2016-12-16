import java.util.Queue;
import java.util.PriorityQueue;

public class Q295_Find_Median_from_Data_Stream {
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
    
    
    public static void main(String[] args){
    	Q295_Find_Median_from_Data_Stream t = new Q295_Find_Median_from_Data_Stream();
    	t.addNum(0);
    	t.addNum(0);
    	System.out.println(t.findMedian());
    	double a = Double.MAX_VALUE;
    }
}
