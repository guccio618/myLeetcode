import java.util.*;


public class Other_K_Closest_Point {
	// test case:
	// points is empty
	// points does not contain k elements
	// there will be duplicate point in kth element, for example k = 2,  target: [0, 0], point[1, 1], point[2, 2], point[2, 2]
	
	public Point[] find_K_Closest_Point(Point[] points, Point target, int k) {
		if(points == null || points.length == 0) {
			return new Point[0];
		}
		
		Queue<Point> maxHeap = new PriorityQueue<Point>(k + 1, new Comparator<Point>(){
			public int compare(Point p1, Point p2) {
				double distance1 = getDistance(target, p1);
				double distance2 = getDistance(target, p2);
				
				if(distance1 < distance2) {
					return 1; 
				} else if(distance1 > distance2) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		for(Point p : points) {
			maxHeap.offer(p);
			
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		Point[] ans = new Point[maxHeap.size()];
		int index = maxHeap.size() - 1;
		
		while(!maxHeap.isEmpty()) {
			ans[index++] = maxHeap.poll(); 
		}
		
		return ans;
	}
	
	public double getDistance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
