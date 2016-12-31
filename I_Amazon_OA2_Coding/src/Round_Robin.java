import java.util.*;
/**************************************************************************************************
 * 一个处理器要处理一堆request，一次只能处理一条，每次执行一个任务最多执行时间q，接着执行等待着的下一个任务。
 * 若前一个任务没执行完则放到队尾，等待下一次执行。假设只要有任务开始以后cpu是不会空闲的，也就是说cpu开始后
 * 如果空闲了就说明没有任务了，另外Robin Round最后返回值是float。
 * 
 **************************************************************************************************/

public class Round_Robin {
	public float Solution(int[] Atime, int[] Etime, int q) {
		if (Atime == null || Etime == null || Atime.length != Etime.length || Atime.length != Etime.length || q <= 0){
			return 0;
		}
		
		int len = Atime.length;
		Queue<Process> queue = new LinkedList<Process>();
		int curTime = 0, waitTime = 0;
		int index = 0;
		
		while (!queue.isEmpty() || index < len) {
			if (!queue.isEmpty()) {
				Process cur = queue.poll();
				waitTime += curTime - cur.arrTime;
				curTime += Math.min(cur.exeTime, q);
				
				while(index < len && curTime >= Atime[index]){            // 这里有等号 ！！！
					queue.offer(new Process(Atime[index], Etime[index]));
					index++;
				}
				
				if (cur.exeTime > q){
					queue.offer(new Process(curTime, cur.exeTime - q));   // 注意这里用的是curTime ！！！
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

		Process(int arr, int exe) {
			arrTime = arr;
			exeTime = exe;
		}
	}
}
