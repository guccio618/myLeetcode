import java.util.Comparator;
import java.util.PriorityQueue;


public class Lecture3_Data_Structure_II_02_Trapping_Rain_Water_II {
	/************************************************************
	 * 防止漏水，需要从四周外围入手开始往里解题； 用heap维护外围墙的高度
	 * 时间复杂度为 n^2 * logn, heap最多是cn个数，其中c为线性的常数
	 * 
	 ************************************************************/
	
	int []dx = {1,-1,0,0};
	int []dy = {0,0,1,-1};
    
    public int trapRainWater(int[][] heights) {
        if (heights.length == 0){
			return 0;
		}
		PriorityQueue<Cell> q = new PriorityQueue<Cell>(1, new CellComparator());
		int n = heights.length;
		int m = heights[0].length;
		int[][] visit = new int[n][m];

		for (int i = 0; i < n; i++) {   // 初始化，从外往里，用heap设置从最外层的最低高度开始访问
			q.offer(new Cell(i, 0, heights[i][0]));
			q.offer(new Cell(i, m - 1, heights[i][m - 1]));
			visit[i][0] = 1;
			visit[i][m - 1] = 1;
		}
		
		for (int i = 0; i < m; i++) {
			q.offer(new Cell(0, i, heights[0][i]));
			q.offer(new Cell(n - 1, i, heights[n - 1][i]));
			visit[0][i] = 1;
			visit[n - 1][i] = 1;
		}
		
		int ans = 0;
		while (!q.isEmpty()) {
			Cell now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && visit[nx][ny] == 0) {
					visit[nx][ny] = 1;
					q.offer(new Cell(nx, ny, Math.max(now.h, heights[nx][ny])));  // heap维护的是外围墙的高度，因此是灌水后的高度
					ans = ans + Math.max(0, now.h - heights[nx][ny]);
				}
			}
		}
		return ans;
    }
    
    class Cell {
		public int x, y, h;

		Cell() {}

		Cell(int xx, int yy, int hh) {
			x = xx;
			y = yy;
			h = hh;
		}
	}

	class CellComparator implements Comparator<Cell> {
		@Override
		public int compare(Cell x, Cell y) {
		    return x.h - y.h;
		}
	}
}
