import java.util.PriorityQueue;
import java.util.Comparator;

public class Q364_Trapping_Rain_Water_II {
	// by ninechapter using PriorityQueue;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };

	public int trapRainWater(int[][] heights) {
		if (heights.length == 0){
			return 0;
		}
		PriorityQueue<Cell> q = new PriorityQueue<Cell>(1, new CellComparator());
		int n = heights.length;
		int m = heights[0].length;
		int[][] visit = new int[n][m];

		for (int i = 0; i < n; i++) {
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
					q.offer(new Cell(nx, ny, Math.max(now.h, heights[nx][ny])));   // 存入的高度为此时加上水后的高度
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

	
	
	
	/*************************** main function *********************************/
	
	public static void main(String[] args) {
		Q364_Trapping_Rain_Water_II t = new Q364_Trapping_Rain_Water_II();
		int[][] heights = { 
				{ 12, 13, 0, 12 }, 
				{ 13, 4, 13, 12 },
				{ 13, 8, 10, 12 }, 
				{ 12, 13, 12, 12 }, 
				{ 13, 13, 13, 13 } 
		};
		System.out.println(t.trapRainWater(heights));
	}
}
