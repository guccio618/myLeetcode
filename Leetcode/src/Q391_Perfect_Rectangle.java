import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Q391_Perfect_Rectangle {
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
	
	public boolean isRectangleCover(int[][] rectangles) {
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

	

	/****************************************************************************************/
	// by Jackie using hashcode, but will cause conflict when the test case is large
	public boolean isRectangleCover2(int[][] rectangles) {
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
		Q391_Perfect_Rectangle t = new Q391_Perfect_Rectangle();
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

