import java.util.Comparator;
import java.util.PriorityQueue;
/*******
 * 
 有m个factory，k种颜色的糖果，有一个array表示每种颜色的糖果需要生产多少个。
 每个factory只能生产一种糖果而且不能改。假设每种糖果的生产速度一样，问怎么分配factory才能让最终的时间最短，分配完后不同颜色的factory是一起工作的。
 比如说两种颜色一个要生产2个一个要1个，有两个factory。那么最终的时间就要2。follow up是如果速度不一样要怎么做?
 
 * 
 * */


public class Factory_Candy {
	// producting time is the same
	public int findMinTime(int factoryNum, int candyNum, int[] candyNeed) {
		if(factoryNum <= 0 || candyNum <= 0 || candyNeed == null || candyNeed.length == 0 || factoryNum < candyNum) {
			return 0;
		}
		
		int availFactory = factoryNum - candyNum;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		
		for(int need : candyNeed) {
			maxHeap.offer(-need);
		}
		
		while(availFactory > 0) {
			int curMaxTime = -maxHeap.poll();
			int part1 = (curMaxTime%2 == 1) ? curMaxTime/2 + 1 : curMaxTime/2;
			int part2 = curMaxTime/2;
			maxHeap.offer(-part1);
			maxHeap.offer(-part2);
			availFactory--;
		}
		
		return -maxHeap.poll();
	}
	
	
	
	// follow up: if producing time is different
	public int findMinTime_FollowUp(int factoryNum, int candyNum, int[] candyNeed, int[] produceTime) {
		if(factoryNum <= 0 || candyNum <= 0 || candyNeed == null || candyNeed.length == 0 || factoryNum < candyNum) {
			return 0;
		} else if(candyNeed.length != produceTime.length) {
			return 0;
		}
		
		int availFactory = factoryNum - candyNum;
		int len = candyNeed.length;
		
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(len, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return -Long.compare(p1.totalTime, p2.totalTime);
			}
		});
		
		for(int i = 0; i < len; i++) {
			maxHeap.offer(new Pair(candyNeed[i], produceTime[i]));
		}
		
		while(availFactory > 0) {
			Pair p = maxHeap.poll();
			int num1 = (p.needNum%2 == 1) ? p.needNum/2 + 1 : p.needNum/2;
			int num2 = p.needNum/2;
			maxHeap.offer(new Pair(num1, p.needTimeEach));
			maxHeap.offer(new Pair(num2, p.needTimeEach));
			availFactory--;
		}
		
		return maxHeap.poll().totalTime;
	}
	
	class Pair {
		int needNum;
		int needTimeEach;
		int totalTime;
		
		public Pair(int needNum, int needTimeEach) {
			this.needNum = needNum;
			this.needTimeEach = needTimeEach;
			this.totalTime = needNum * needTimeEach;
		}
	}
	
	
	
	
	/***************************** main function **********************************/
	
	public static void main(String[] args) {
		Factory_Candy t = new Factory_Candy();
		int[] candyNeed = {3,6,9,3,5};
		int[] produceTime = {2,3,4,5,6};
		int factoryNum = 5;
		int candyNum = 5;		
		System.out.println(t.findMinTime(factoryNum, candyNum, candyNeed));
		System.out.println(t.findMinTime_FollowUp(factoryNum, candyNum, candyNeed, produceTime));
	}
}
