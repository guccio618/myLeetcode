import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.awt.geom.*;
/**********
 * 
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * */


public class Q149_Max_Points_on_a_Line {
	/**************************************************************
	 * 两点斜率相同：  slope = (y2 - y1) / (x2 - x1);
	 * 考虑到三种情况： slope = 0, slope = Infinite, slope = other
	 * 同时还要注意全是same point的情况，如：[1, 1], [1, 1], [1, 1]的情况
	 * test case: [0, 0].
	 * 
	 **************************************************************/
	// test case:
    // 		points is empty
    // 		points contains only one element
    // 		contains duplicate points
    // 		all the point in the points have the same coordinate value
	
	// solution 1:
	public int maxPoints(Point[] points) {
		if(points == null || points.length == 0){
            return 0;
        } else if(points.length <= 2){
            return points.length;
        }
        
        int n = points.length;
        int globalMax = 0;
        
        for(int i = 0; i < n; i++){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int samePoint = 0;
            double slope = 0;
            int localMax = 0;
            
            for(int j = i + 1; j < n; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    samePoint++;
                    continue;
                } 
                
                if(points[i].x == points[j].x){   
                    slope = Double.MAX_VALUE;
                } else if(points[i].y == points[j].y){    // 防止[2,3], [3,3], [5,3]导致的－0.0， 0.0不同
                	slope = 0;
                } else {
                    slope = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                }
                
                map.put(slope, map.getOrDefault(slope, 1) + 1);  // 注意这里必需put 1 + 1而不是 1 ！！！
            }
            
            for(Map.Entry<Double, Integer> entry : map.entrySet()){
                localMax = Math.max(localMax, entry.getValue());
            }
            
            if(samePoint == n - 1 - i){      // 防止全是相同点的情况，此时需要把自身这个点加进来，如：[1, 1], [1, 1], [1, 1] ！！！
            	samePoint++;
            }
            
            globalMax = Math.max(globalMax, localMax + samePoint);
        }
        
        return globalMax;
    }
	
	
	
	// solution 2: sometimes, double will lead to incorrect answer, so try to use self-define class Slope
	public int maxPoints2(Point[] points) {
		if(points == null || points.length == 0) {
			return 0;
		}
		
		int n = points.length;
		int globalMax = 0;
		
		for(int i = 0; i < n; i++) {
			Map<Slope, Integer> map = new HashMap();
			int samePoints = 0;
			int localMax = 0;
			Slope slope = null;
			
			for(int j = i + 1; j < n; j++) {
				if(points[i].x == points[j].x && points[i].y == points[j].y) {
					samePoints++;
					continue;
				}				
				
				if(points[i].x == points[j].x) {
					slope = new Slope(0, 1);
				} else if(points[i].y == points[j].y) {
					slope = new Slope(1, 0);
				} else {
					int x = points[i].x - points[j].x;
					int y = points[i].y - points[j].y;
					int gcd = findGCD(x, y);
					x /= gcd;
					y /= gcd;
					
					if(x * y < 0 && x < 0) {
                        x = -x;
                        y = -y;
                    }
					
					slope = new Slope(x, y);
				}							
				
				map.put(slope, map.getOrDefault(slope, 1) + 1);
			}
			
			for(Map.Entry<Slope, Integer> entry : map.entrySet()) {
				localMax = Math.max(localMax, entry.getValue());
			}
			
			if(n - 1 - i == samePoints) {
				samePoints++;
			}
			
			globalMax = Math.max(globalMax, localMax + samePoints);
		}
		
		return globalMax;
	}
	
	public int findGCD(int a, int b) {
		if(a < b) {
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		
		do {
			int temp = a % b;
			a = b;
			b = temp;
		} while(b != 0);
		
		return a;
	}
	
	class Slope {
		int x;
		int y;
		
		public Slope(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.x == ((Slope)obj).x && this.y == ((Slope)obj).y;
		}
		
		@Override
		public int hashCode(){
			int[] array = {x, y};
			return Arrays.hashCode(array);
		}       
	}
	
	
	
	
	
	
	
	
	
	
	
	/*********************************** main function *****************************************/
	
	public static void main(String[] args){
		Q149_Max_Points_on_a_Line t = new Q149_Max_Points_on_a_Line();
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(-1, -1);
		points[2] = new Point(2, 2);
		System.out.println(t.maxPoints2(points));
		
	}
}

class Point{
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
