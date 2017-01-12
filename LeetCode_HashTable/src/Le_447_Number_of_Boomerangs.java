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

public class Le_447_Number_of_Boomerangs {
	// using hashmap, time O(n^2), space O(n)
	public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        int ans = 0;
        int len = points.length;
        
        for(int i = 0; i < len; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int j = 0; j < len; j++) {
                if(i == j) {
                    continue;
                }
                
                int distance = getDistanceSqure(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) { // 对于每一个点Point[i]都进行处理 ！！！
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
    
    
    
    
    
    // follow up: find out all the solution of boomeranges    
    public List<int[][]> numberOfBoomerangs_follow_up(int[][] points) {
    	List<int[][]> ans = new ArrayList<>();
    	
    	if(points == null || points.length == 0 || points[0].length == 0) {
            return ans;
        }
        
        int len = points.length;
        
        for(int i = 0; i < len; i++) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            
            for(int j = 0; j < len; j++) {
                if(i == j) {
                    continue;
                }
                
                int distance = getDistanceSqure(points[i], points[j]);
                
                if(!map.containsKey(distance)) {
                	List<int[]> list = new ArrayList<>();
                	list.add(points[i]);
                	list.add(points[j]);
                	map.put(distance, list);
                } else {
                	map.get(distance).add(points[j]);
                }
            }
            
            for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
                List<int[]> list = entry.getValue();
                
                if(list.size() > 2) {
                    int[] point1 = list.get(0);
                    
                    for(int x = 1; x < list.size(); x++) {
                    	for(int y = 1; y < list.size(); y++) {
                    		if(x == y) {
                    			continue;
                    		}
                    		
                    		int[][] array = {point1, list.get(x), list.get(y)};
                    		ans.add(array);
                    	}
                    }
                }
            }
        }
        
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /******************************** main function **************************************/
    
    public static void main(String[] args) {
    	Le_447_Number_of_Boomerangs t = new Le_447_Number_of_Boomerangs();
    	int[][] points = {
    			{0,0}, {1,0}, {2,0}
    	};
    	
    	System.out.println(t.numberOfBoomerangs(points));
    	List<int[][]> ans = t.numberOfBoomerangs_follow_up(points);
    	
    	for(int[][] elem : ans) {
    		for(int[] point : elem) {
    			System.out.print("[" + point[0] + ", " + point[1] + "], ");
    		}
    		System.out.println();
    	}
    }
}
