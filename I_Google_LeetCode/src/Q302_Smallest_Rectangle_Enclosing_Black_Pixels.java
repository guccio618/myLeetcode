/******
 * 
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

 * 
 * */

public class Q302_Smallest_Rectangle_Enclosing_Black_Pixels {
	// solution 1: using DFS, time is O(m*n)
	private int left = 0, right = 0, up = 0, down = 0;

	public int minArea2(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0) {
			return 0;
		}

		int row = image.length, col = image[0].length;
		left = right = y;
		up = down = x;
		boolean[][] visited = new boolean[row][col];

		traver(image, visited, x, y);
		return (right - left + 1) * (up - down + 1);
	}

	public void traver(char[][] image, boolean[][] visited, int x, int y) {
		if (visited[x][y] == true) {
			return;
		}

		visited[x][y] = true;
		left = Math.min(left, y);
		right = Math.max(right, y);
		up = Math.max(up, x);
		down = Math.min(down, x);
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == '1') {
				traver(image, visited, newX, newY);
			}
		}
	}

	
	
	// solution 2: using binary search, time is O(m*logn + n*logm);
	public int minArea(char[][] image, int x, int y) {
		if(image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        int left = findMinBound(image, 0, y, true);
        int right = findMaxBound(image, y, image[0].length - 1, true);
        
        int top = findMaxBound(image, x, image.length - 1, false);
        int bottom = findMinBound(image, 0, x, false);
 
        return (right - left + 1) * (top - bottom + 1);
	}

	public int findMinBound(char[][] image, int min, int max, boolean horizontal) {
	    while (min + 1 < max) {
	        int mid = min + (max - min) / 2;
	        
	        if (!hasBlackPixel(image, mid, horizontal)) {
				min = mid;
			} else {				
				max = mid;
			}
	    }
	    
	    if(hasBlackPixel(image, min, horizontal)) {
	        return min;
	    } else {
	        return max;
	    }
	}

	public int findMaxBound(char[][] image, int min, int max, boolean horizontal) {
	    while (min + 1 < max) {
	        int mid = min + (max - min) / 2;
	        
	        if (!hasBlackPixel(image, mid, horizontal)) {
	            max = mid;
	        } else {
	            min = mid;
	        }
	    }
	    
	    if(hasBlackPixel(image, max, horizontal)) {
	        return max;
	    } else {
	        return min;
	    }
	}

	public boolean hasBlackPixel(char[][] image, int mid, boolean horizontal) {
	    if (horizontal) {
	        for (int i = 0; i < image.length; i++) {
	            if (image[i][mid] == '1') {
	                return true;
	            }
	        }
	    } else {
	        for (int j = 0; j < image[0].length; j++) {
	            if (image[mid][j] == '1') {
	                return true;
	            }
	        }
	    }
	    
	    return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/**************************** main function ************************************/

	public static void main(String[] args) {
		Q302_Smallest_Rectangle_Enclosing_Black_Pixels t = new Q302_Smallest_Rectangle_Enclosing_Black_Pixels();
		String[] strs = { "0010", "0110", "0100" };

		char[][] image = { strs[0].toCharArray(), strs[1].toCharArray(), strs[2].toCharArray() };

		System.out.println(t.minArea(image, 0, 2));
	}
}
