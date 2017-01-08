import java.util.*;
/******
 * 
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
	Input:
	[[0,0],[1,0],[2,0]]

	Output:
	2

Explanation:
	The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

 * 
 * */

public class Q447_Number_of_Boomerangs {
	// using hashmap, time O(n^2), space O(n)
	public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        int ans = 0;
        int n = points.length;
        
        for(int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                
                int distance = getDistanceSqure(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int size = entry.getValue();
                
                if(size > 1) {
                    ans += size * (size - 1);
                }
            }
        }
        
        return ans;
    }
    
    public int getDistanceSqure(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
