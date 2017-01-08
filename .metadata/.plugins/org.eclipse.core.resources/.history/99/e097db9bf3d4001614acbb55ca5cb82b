import java.util.*;


public class Q447_Number_of_Boomerangs {
	// time O(n^2), space O(n)
	public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        int ans = 0;
        int n = points.length;
        
        for(int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap();
            
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
