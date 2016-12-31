import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;


public class Lecture3_Data_Structure_II_03_Building_Outline {
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
}
