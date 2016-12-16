import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q000_Data_Structure_PriorityQueue_I {
	private String name;
	private int population;

	//Q000_PriorityQueue是自己定义的数据类型，存放于priorityqueue里
	public Q000_Data_Structure_PriorityQueue_I(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return this.name;
	}

	public int getPopulation() {
		return this.population;
	}

	public String toString() {
		return getName() + " - " + getPopulation();
	}
	
	public static void main(String args[]) {
		
		//如果想实现按照自己的意愿进行优先级排列的队列的话，需要实现Comparator接口；
		//如果不实现Comparator,则优先队列按从小到大排列，字符串按字母顺序排列
		Comparator<Q000_Data_Structure_PriorityQueue_I> OrderIsdn = new Comparator<Q000_Data_Structure_PriorityQueue_I>() {			
			public int compare(Q000_Data_Structure_PriorityQueue_I o1, Q000_Data_Structure_PriorityQueue_I o2) {
				int numbera = o1.getPopulation();
				int numberb = o2.getPopulation();
				if (numberb > numbera) {
					return 1;
				} else if (numberb < numbera) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		
		// 此处参数11为initialsize, 第二个参数是comparator；另外优先队列也有无参构造函数
		Queue<Q000_Data_Structure_PriorityQueue_I> priorityQueue = new PriorityQueue<Q000_Data_Structure_PriorityQueue_I>(11, OrderIsdn);
		
		Q000_Data_Structure_PriorityQueue_I t1 = new Q000_Data_Structure_PriorityQueue_I("t1", 1);
		Q000_Data_Structure_PriorityQueue_I t3 = new Q000_Data_Structure_PriorityQueue_I("t3", 3);
		Q000_Data_Structure_PriorityQueue_I t2 = new Q000_Data_Structure_PriorityQueue_I("t2", 2);
		Q000_Data_Structure_PriorityQueue_I t4 = new Q000_Data_Structure_PriorityQueue_I("t4", 0);
		priorityQueue.add(t1);
		priorityQueue.add(t3);
		priorityQueue.add(t2);
		priorityQueue.add(t4);
		System.out.println(priorityQueue.poll().toString());
	}
}
