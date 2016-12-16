
public class Maze {
	public int Solution(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		
		int row = matrix.length, col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];

		if(backtrack(matrix, visited, 0, 0) == true){
			return 1;
		} else {
			return 0;
		}
	}
	
	public boolean backtrack(int[][] matrix, boolean[][] visited, int x, int y){
		if(visited[x][y] == true || matrix[x][y] == 1){
			return false;
		} else if(matrix[x][y] == 9){
			return true;
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length){
				if(backtrack(matrix, visited, newX, newY) == true){
					return true;
				}
			}
		}
		
		visited[x][y] = false;
		return false;
	}
	
	
	
	
	/********************* main function ***********************/
	
	public static void main(String[] args){
		Maze t = new Maze();
		int[][] matrix = {
				{0, 0, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{1, 0, 0, 0, 9}
				
		};
		
		int[][] matrix2 = {{9}};
		
		System.out.println(t.Solution(matrix));
		
		
	}
}
