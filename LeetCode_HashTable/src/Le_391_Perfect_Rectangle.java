import java.util.*;
/*******
 * 
Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false. Because there is a gap in the top center.

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.

 * 
 * */


public class Le_391_Perfect_Rectangle {
	/**********************************************************************************************************
	 * The right answer must satisfy two conditions:
	 * 	(1). the large rectangle area should be equal to the sum of small rectangles
	 * 	(2). count of all the points should be even, and that of all the four corner points should be one
	 **********************************************************************************************************/
	
	public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
        	return false;
        }

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        Set<String> set = new HashSet<String>();
        int area = 0;
        
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);  // area 累加 ！！！
            
            String s1 = rect[0] + " " + rect[1];    // 以此种方法存在set里；或者可以用Arrays.hashCode()来获取 ！！！
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
            
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4){
        	return false;
        } else {
        	return area == (x2-x1) * (y2-y1);    // 总面积相等
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/****************************************************************************************/
	// by Jackie using self-definded data structure
	class Point{
		int x; 
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}	
	}
	
	public boolean isRectangleCover2(int[][] rectangles) {
		Map<Point, Integer> map = new HashMap<Point, Integer>();
		int upBound = Integer.MIN_VALUE;
		int downBound = Integer.MAX_VALUE;
		int leftBound = Integer.MAX_VALUE;
		int rightBound = Integer.MIN_VALUE;
		Point[] myPoints = new Point[rectangles.length * 4];
		int index = 0;

		for (int[] rectangle : rectangles) {
			upBound = Math.max(upBound, Math.max(rectangle[1], rectangle[3]));
			downBound = Math.min(downBound, Math.min(rectangle[1], rectangle[3]));
			leftBound = Math.min(leftBound, Math.min(rectangle[0], rectangle[2]));
			rightBound = Math.max(rightBound, Math.max(rectangle[0], rectangle[2]));

			int[][] points = { 
					{ rectangle[0], rectangle[1] },
					{ rectangle[2], rectangle[1] },
					{ rectangle[0], rectangle[3] },
					{ rectangle[2], rectangle[3] } 
			};

			for (int i = 0; i < 4; i++) {
				myPoints[index++] = new Point(points[i][0], points[i][1]);
			}
		}

		Arrays.sort(myPoints, new Comparator<Point>() {
			public int compare(Point o1, Point o2) {
				if(o1.x != o2.x){
					return o1.x - o2.x;
				} else {
					return o1.y - o2.y;
				}
			}
		});
		
		int myIndex = 0;
		
		while(myIndex < myPoints.length){
			Point temp = myPoints[myIndex];
			int count = 0;
			
			while(myIndex < myPoints.length && myPoints[myIndex].x == temp.x && myPoints[myIndex].y == temp.y){
				count++;
				myIndex++;
			}
			
			map.put(temp, count);
		}

		for(Map.Entry<Point, Integer> entry : map.entrySet()){
			Point temp = entry.getKey();
			int count = entry.getValue();
			
			if( (temp.x == leftBound || temp.x == rightBound) && (temp.y == upBound || temp.y == downBound) ){
    			if(count != 1){
    				return false;
    			}
    		} else if(count % 2 != 0){
    			return false;
        	}			
		}

		return true;
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/****************************************** main function **********************************************/
	// by Jackie using hashcode, but will cause conflict when the test case is large
	public boolean isRectangleCover3(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int up = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for(int[] rectangle : rectangles){
        	up = Math.max(up, Math.max(rectangle[1], rectangle[3]));
        	down = Math.min(down, Math.min(rectangle[1], rectangle[3]));
        	left = Math.min(left, Math.min(rectangle[0], rectangle[2]));
        	right = Math.max(right, Math.max(rectangle[0], rectangle[2]));
        	
        	int[][] points = {
        			{rectangle[0], rectangle[1]},
        			{rectangle[2], rectangle[1]},
        			{rectangle[0], rectangle[3]},
        			{rectangle[2], rectangle[3]}
        	};
        	
        	int[] code = new int[4];   
        	
        	for(int i = 0 ; i < 4; i++){
        		code[i] = Arrays.hashCode(points[i]);
        		map.put(code[i], map.getOrDefault(code[i], 0) + 1);
        	}
        }
        
        System.out.println(up + "," + down + "," + left + "," + right);
        
        for(int[] rectangle : rectangles){
        	int[][] points = {
        			{rectangle[0], rectangle[1]},
        			{rectangle[2], rectangle[1]},
        			{rectangle[0], rectangle[3]},
        			{rectangle[2], rectangle[3]}
        	};
            
            int[] code = new int[4];
        	
        	for(int i = 0 ; i < 4; i++){
        		code[i] = Arrays.hashCode(points[i]);
        		int count = map.get(code[i]);
        		
        		if( (points[i][0] == left || points[i][0] == right) && (points[i][1] == up || points[i][1] == down) ){
        			if(count != 1){
        				return false;
        			}
        		} else if(count % 2 != 0){
        			return false;
            	}
        	}
        }
        
        return true;
    }
	
	
	
	public static void main(String[] args){
		Le_391_Perfect_Rectangle t = new Le_391_Perfect_Rectangle();
		int[][] rectangles = {
				{1,1,3,3},
				{3,1,4,2},
				{3,2,4,4},
				{1,3,2,4},
				{2,3,3,4}
		};
		
		int[][] rectangles2 = {  // false
				{1,1,2,3},
				{1,3,2,4},
				{3,1,4,2},
				{3,2,4,4}
		};
		
		int[][] rectangles3 = {  // false
				{1,1,3,3},
				{3,1,4,2},
				{1,3,2,4},
				{2,2,4,4}
		};
		
		int[][] rectangles4 = {
				{0,0,4,1},
				{0,0,4,1}
		};
		
		int[][] rectangles5 = {
				{1,1,2,3},
				{1,3,2,4},
				{3,1,4,2},
				{3,2,4,4}
		};
		
		int[][] rectangles6 = {
				{0,-1,1,0},
				{0,0,1,1},
				{0,1,1,2},
				{0,2,1,3},
				{0,3,1,4},
				{0,4,1,5}
		};
		
		System.out.println(t.isRectangleCover(rectangles6));
	}
}

