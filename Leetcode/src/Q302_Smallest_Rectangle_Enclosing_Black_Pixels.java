
public class Q302_Smallest_Rectangle_Enclosing_Black_Pixels {
	// by other using binary search, O(n * lgm + m * lgn)
	public int minArea(char[][] image, int x, int y) {
	    int row = image.length, col = image[0].length;
	    int left = searchColumns(image, 0, y, 0, row, true);
	    int right = searchColumns(image, y, col, 0, row, false);
	    int top = searchRows(image, 0, x, left, right, true);
	    int bottom = searchRows(image, x, row, left, right, false);
	    return (right - left) * (bottom - top);
	}
	
	public int searchColumns(char[][] image, int left, int right, int top, int bottom, boolean opt) {
	    while (left < right) {
	        int k = top, mid = (left + right) / 2;
	        
	        while (k < bottom && image[k][mid] == '0') {
	        	++k;
	        }
	        
	        if (k < bottom == opt) { // 表示找到
	            right = mid;
	        } else {
	            left = mid + 1;     // 注意这里要 ＋1 ！！！
	        }
	    }
	    
	    return left;
	}
	
	public int searchRows(char[][] image, int top, int bottom, int left, int right, boolean opt) {
	    while (top < bottom) {
	        int k = left, mid = (top + bottom) / 2;
	        
	        while (k < right && image[mid][k] == '0') {
	        	++k;
	        }
	        
	        if (k < right == opt) {  // 表示找到
	            bottom = mid;
	        } else {
	            top = mid + 1;      // 注意这里要 ＋1 ！！！
	        }
	    }
	    
	    return top;
	}
	
	
	
	/*****************************************************************/
	// by Jackie using DFS, but exceed time limit
	private int left = 0, right = 0, up = 0, down = 0;
    
    public int minArea2(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }
        
        int row = image.length, col = image[0].length;
        left = right = y;
        up = down = x;
        boolean[][] visited = new boolean[row][col];
        
        traver(image, visited, x, y);
        return (right - left + 1) * (up - down + 1);
    }
    
    public void traver(char[][] image, boolean[][] visited, int x, int y){
        if(visited[x][y] == true){
            return;
        }
        
        visited[x][y] = true;
        left = Math.min(left, y);
        right = Math.max(right, y);
        up = Math.max(up, x);
        down = Math.min(down, x);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == '1'){
                traver(image, visited, newX, newY);
            }
        }
    }
}
