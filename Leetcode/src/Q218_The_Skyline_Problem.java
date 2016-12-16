import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Q218_The_Skyline_Problem {
	/***********************************************/
	// by other using TreeMap
	public List<int[]> getSkyline(int[][] buildings) {
		TreeMap<Integer, Integer> availableHeights = new TreeMap<>();
		List<int[]> res = new ArrayList<>(buildings.length);

		int len = buildings.length;
		if (len == 0) {
			return res;
		}

		Edge[] edges = new Edge[len * 2];
		for (int i = 0; i < len; ++i) {
			edges[i * 2] = new Edge(buildings[i][0], buildings[i][2], true);
			edges[1 + (i * 2)] = new Edge(buildings[i][1], buildings[i][2], false);
		}

		Arrays.sort(edges);
		int currentHeight = 0;
		availableHeights.put(0, 1);
		
		for (int i = 0, j; i < len * 2; i = j) {
			for (j = i; j < len * 2 && edges[i].x == edges[j].x; ++j) { // 同一个pos的结点需要放在一起处理
				Edge event = edges[j];
				if (!event.isStart) {
					int counter = availableHeights.get(event.height);
					if (counter == 1) {
						availableHeights.remove(event.height);
					} else {
						availableHeights.put(event.height, counter - 1);
					}
				} else {
					Integer counter = availableHeights.get(event.height);
					if (counter == null) {
						availableHeights.put(event.height, 1);
					} else {
						availableHeights.put(event.height, counter + 1);
					}
				}
			}

			int x = edges[i].x;
			int height = availableHeights.lastKey();
			if (height != currentHeight) {
				res.add(new int[] { x, height });
				currentHeight = height;
			}
		}
		return res;
	}

	class Edge implements Comparable<Edge> {
		int x, height;
		boolean isStart;

		public Edge(int a, int b, boolean c) {
			x = a;
			height = b;
			isStart = c;
		}

		@Override
		public int compareTo(Edge that) {
			return (x != that.x) ? x - that.x : Boolean.compare(that.isStart, isStart);
		}
	}
	
	
	
	/***********************************************/
	// by Jackie using Scan line
	public List<int[]> getSkyline2(int[][] buildings) {
		List<int[]> ans = new ArrayList<int[]>();
		if(buildings == null || buildings[0] == null){
			return ans;
		}
		
		Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
			public int compare(Node left, Node right){
				if(left.position != right.position){
					return left.position - right.position;
				} else {
					if(left.isStart == false){
						return -1;
					} else if(right.isStart == false){
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		
		Queue<Integer> q = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
			public int compare(Integer left, Integer right){
				return right - left;
			}
		});
		
		
		for(int row = 0; row < buildings.length; ++row){
			heap.offer(new Node(buildings[row][0], buildings[row][2], true));			
			heap.offer(new Node(buildings[row][1], buildings[row][2], false));
		}
		
		while(!heap.isEmpty()){
			Node temp1 = heap.poll();
			
			if(temp1.isStart == true){
				q.offer(temp1.height);
			} else {
				q.remove(temp1.height);
			}
			
			while(!heap.isEmpty() && temp1.position == heap.peek().position){  // 处理同一position上重复的高度值
				Node temp2 = heap.poll();
				
				if(temp2.isStart == true){
					q.offer(temp2.height);
				} else {
					q.remove(temp2.height);
				}
			}
			
			int[] result = new int[2];
			result[0] = temp1.position;
			if(q.isEmpty()){
				result[1] = 0;
			} else {
				result[1] = q.peek();
			}	
			if(ans.size() > 0 && result[1] == ans.get(ans.size() - 1)[1]){
				continue;
			} 
			ans.add(result);
		}
		
		return ans;
	}
	
	class Node{
		int position;
		int height;
		boolean isStart;
		
		public Node(int p, int h, boolean i){
			position = p;
			height = h;
			isStart = i;
		}
	}

	
	
	/************************* main function ***************************/

	public static void main(String[] args) {
		Q218_The_Skyline_Problem t = new Q218_The_Skyline_Problem();
		int[][] buildings = { 
			{1, 3, 3},
			{2, 4, 4},
			{5, 6, 1}
		};

		List<int[]> res = t.getSkyline(buildings);

		for (int i = 0; i < res.size(); ++i) {
			System.out.print("[" + res.get(i)[0] + ", " + res.get(i)[1] + "], ");
		}
	}
}
