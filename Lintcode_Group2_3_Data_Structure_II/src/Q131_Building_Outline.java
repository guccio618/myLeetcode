import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Q131_Building_Outline {
	/***********************************************/
	// by other using TreeMap
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
		TreeMap<Integer, Integer> availableHeights = new TreeMap<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

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

		int start = 0, end = 0;
		
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
				end = x;
				if(currentHeight != 0){
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(start);
					list.add(end);
					list.add(currentHeight);
					res.add(list);
				}
				start = x;
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
	
	
	
	
	/************************* main function ***************************/

	public static void main(String[] args) {
		Q131_Building_Outline t = new Q131_Building_Outline();
		int[][] buildings = { 
			{1, 3, 3},
			{2, 4, 4},
			{5, 6, 1}
		};

		ArrayList<ArrayList<Integer>> res = t.buildingOutline(buildings);

		for (int i = 0; i < res.size(); ++i) {
			System.out.print("[" + res.get(i).get(0) + ", " + res.get(i).get(1) + ", " + res.get(i).get(2) + "], ");
		}
	}
}
