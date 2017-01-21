import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q296_Best_Meeting_Point {
	public int minTotalDistance(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        List<Integer> list_x = new ArrayList<Integer>();
        List<Integer> list_y = new ArrayList<Integer>();
        int row = grid.length, col = grid[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    list_x.add(i);
                    list_y.add(j);
                }
            }
        }
        
        return getDistance(list_x) + getDistance(list_y);
	}

	public int getDistance(List<Integer> list){
        int left = 0, right = list.size() - 1, distance = 0;
        Collections.sort(list);
        
        while(left < right){
            distance += list.get(right) - list.get(left);
            left++;
            right--;
        }
        
        return distance;
    }
	
	

	public static void main(String[] args){
		Q296_Best_Meeting_Point t = new Q296_Best_Meeting_Point();
		int[][] grid = {
				{1,0,0,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0}
		};
		
		System.out.println(t.minTotalDistance(grid));
	}
}
