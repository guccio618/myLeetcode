import java.util.*;

/********
 * 
Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).

Note:

There are at least 3 and at most 10,000 points.
Coordinates are in the range -10,000 to 10,000.
You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.
Example 1:

[[0,0],[0,1],[1,1],[1,0]]

Answer: True

Explanation:
Example 2:

[[0,0],[0,10],[10,10],[10,0],[5,5]]

Answer: False

Explanation:

 * 
 * */

public class Q469_Convex_Polygon {
	/***********************************************************************
	 * Slope of line segment (p1, p2): σ = (y2 - y1)/(x2 - x1)
	 * Slope of line segment (p2, p3): τ = (y3 - y2)/(x3 - x2)
	 * 
	 * If  σ < τ, the orientation is counterclockwise (left turn)
	 * If  σ = τ, the orientation is collinear
	 * If  σ > τ, the orientation is clockwise (right turn)
	 * 
	 * Using above values of σ and τ, we can conclude that, 
	 * the orientation depends on sign of  below expression: 
	 * 		(y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1)
	 * 
	 * Above expression is negative when σ < τ, i.e., counterclockwise
	 * Above expression is 0 when σ = τ, i.e., collinear
	 * Above expression is positive when σ > τ, i.e., clockwise
	 * 
	 ***********************************************************************/
		
	public boolean isConvex(List<List<Integer>> points) {
        if(points == null || points.size() == 0) {
            return false;
        }
        
        int flag = 0;
        
        for (int i = 0; i < points.size(); i++) {
            int angle = getAngle(points, i);
            
            if (angle == 0) {  // collinear
                continue;
            }
            
            if (flag == 0) {   // first element in the array
                flag = angle > 0 ? 1 : -1;
            } else if (flag > 0 != angle > 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public int getAngle(List<List<Integer>> points, int i) {
        List<Integer> c = points.get(i % points.size());
        List<Integer> b = points.get((i + 1) % points.size());
        List<Integer> a = points.get((i + 2) % points.size());
        // (y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1)
        return (a.get(1) - b.get(1)) * (b.get(0) - c.get(0)) - (b.get(1) - c.get(1)) * (a.get(0) - b.get(0));
    }
}
