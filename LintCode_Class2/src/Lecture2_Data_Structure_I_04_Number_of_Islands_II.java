import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Lecture2_Data_Structure_I_04_Number_of_Islands_II {
	class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n, int m){
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int id = converttoId(i,j,m);
                    father.put(id, id); 
                }
            }
        }
        int find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = x;
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
                
        }
        
        void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    
    int converttoId(int x, int y, int m){
        return x*m + y;
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<Integer>();
        if(operators == null || operators.length == 0 || m <= 0 || n <= 0){
            return res;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][] isLand = new int[n][m];
        int len = operators.length;
        int count = 0;
        UnionFind uf = new UnionFind(n, m);
        
        for(int i = 0; i < len; ++i){
            int x = operators[i].x;
            int y = operators[i].y;
            if(isLand[x][y] != 1){
                isLand[x][y] = 1;
                count++;
                int id = converttoId(x, y, m);
                for(int j = 0; j < 4; ++j){
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < m && isLand[newX][newY] == 1){
                        int newId = converttoId(newX, newY, m);
                        int fa = uf.find(id);
                        int newFa = uf.find(newId);
                        if(fa != newFa){
                            uf.union(fa, newFa);
                            count--;
                        }
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
}
