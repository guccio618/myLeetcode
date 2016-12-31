import java.util.*;

public class Shorted_Job_First {
	/*********************************************************************************
	 * 一个处理器要处理⼀堆request，⼀次只能处理⼀条，如果它有⼏个积压着的requests，
	 * 它会先执⾏持续时间短的那个；对于持续时间相等的requests，先执⾏最早到达处理器的request。
	 * 问平均每个request要等多久才能被处理。input：requestTimes[]，每个request到达处理器的时间;
	 * durations[] 每个request要处理的持续时间。 两个数组是⼀一对应的，并已按requestTimes[] 
	 * 从⼩到⼤排序过
	 * 
	 *********************************************************************************/
	
	public float Solution(int[] Atime, int[] Etime) {
		if (Atime == null || Etime == null || Atime.length != Etime.length) {
			return 0;
		}

		int index = 0, len = Atime.length;
		int waitTime = 0, curTime = 0;

		Queue<Process> queue = new PriorityQueue<Process>(len, new Comparator<Process>() {
			public int compare(Process p1, Process p2) {
				if (p1.exeTime != p2.exeTime) {
					return p1.exeTime - p2.exeTime;
				} else {
					return p1.arrTime - p2.arrTime;
				}
			}
		});

		while (!queue.isEmpty() || index < len) {
			if (!queue.isEmpty()) {
				Process cur = queue.poll();
				waitTime += curTime - cur.arrTime;
				curTime += cur.exeTime;

				while (index < len && curTime >= Atime[index]) { // 这里有等于号 ！！！
					queue.offer(new Process(Atime[index], Etime[index]));
					index++;
				}
			} else {
				queue.offer(new Process(Atime[index], Etime[index]));
				curTime = Atime[index];
				index++;
			}
		}

		return (float) waitTime / len;
	}

	
	
	
	
	
	
	/************************/
	
	class Process {
		int arrTime;
		int exeTime;

		public Process(int a, int e) {
			arrTime = a;
			exeTime = e;
		}
	}
}
