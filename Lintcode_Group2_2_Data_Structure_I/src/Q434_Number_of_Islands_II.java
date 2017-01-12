import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q434_Number_of_Islands_II {
	// by ninechapter using Union Find
	class UnionFind {
		HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

		UnionFind(int n, int m) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int id = converttoId(i, j, m);
					father.put(id, id);
				}
			}
		}

		int find(int x) {
			int parent = father.get(x);
			while (parent != father.get(parent)) {
				parent = father.get(parent);
			}
			return parent;
		}

		int compressed_find(int x) {
			int parent = father.get(x);
			while (parent != father.get(parent)) {
				parent = father.get(parent);
			}
			int temp = -1;
			int fa = x;
			while (fa != father.get(fa)) {
				temp = father.get(fa);
				father.put(fa, parent);
				fa = temp;
			}
			return parent;

		}

		void union(int x, int y) {
			int fa_x = find(x);
			int fa_y = find(y);
			if (fa_x != fa_y)
				father.put(fa_x, fa_y);
		}
	}

	int converttoId(int x, int y, int m) {
		return x * m + y;
	}

	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		int[][] island = new int[n][m];
		List<Integer> ans = new ArrayList<Integer>();
		UnionFind uf = new UnionFind(n, m);
		int count = 0;
		
		if (operators != null) {
			for (int i = 0; i < operators.length; i++) {
				count++;
				int x = operators[i].x;
				int y = operators[i].y;
				if (island[x][y] != 1) {
					island[x][y] = 1;
					int id = converttoId(x, y, m);
					
					for (int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if (0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) {
							int nid = converttoId(nx, ny, m);
							int fa = uf.find(id);
							int nfa = uf.find(nid);
							
							if (fa != nfa) {
								count--;
								uf.union(id, nid);
							}
						}
					}
				}
				ans.add(count);
			}
		}
		return ans;
	}
}
