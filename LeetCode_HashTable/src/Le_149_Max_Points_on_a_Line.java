import java.util.HashMap;
import java.util.Map;

/**************************************************************
 * 两点斜率相同：  slope = (y2 - y1) / (x2 - x1);
 * 考虑到三种情况： slope = 0, slope = Infinite, slope = other
 * 同时还要注意全是same point的情况，如：[1, 1], [1, 1], [1, 1]的情况
 * test case: [0, 0]
 * 
 **************************************************************/

public class Le_149_Max_Points_on_a_Line {
	public int maxPoints(Point[] points) {
		if(points == null || points.length == 0){
            return 0;
        } else if(points.length <= 2){
            return points.length;
        }
        
        int n = points.length;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int samePoint = 0;
            double slope = 0;
            int localMax = 0;
            
            for(int j = i + 1; j < n; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    samePoint++;
                    continue;
                } else if(points[i].x == points[j].x){   
                    slope = Double.MAX_VALUE;
                } else if(points[i].y == points[j].y){    // 防止[2,3], [3,3], [5,3]导致的－0.0， 0.0不同
                	slope = 0;
                } else {
                    slope = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                }
                
                if(!map.containsKey(slope)){
                    map.put(slope, 2);                    // 注意这里必需put 2而不是 1, 表示此斜率下有2个点 ！！！
                } else {               	
                    map.put(slope, map.get(slope) + 1);
                }
            }
            
            for(Map.Entry<Double, Integer> entry : map.entrySet()){
                localMax = Math.max(localMax, entry.getValue());
            }
            
            if(samePoint == n - i - 1){      // 防止全是相同点的情况，此时需要把自身这个点加进来，如：[1, 1], [1, 1], [1, 1] ！！！
            	samePoint++;
            }
            
            ans = Math.max(ans, localMax + samePoint);
        }
        
        return ans;
    }
	

	
	
	
	public static void main(String[] args){
		Le_149_Max_Points_on_a_Line t = new Le_149_Max_Points_on_a_Line();
		Point[] points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, 1);
		System.out.println(t.maxPoints(points));
	}
}

class Point{
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
