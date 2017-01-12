
public class Q123_Word_Search {
	private boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            if(word == null || word.length() == 0){
                return true;
            } else{
                return false;
            }
        }
        
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        boolean res = false;
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == word.charAt(0)){
                    res = res || backtrack(board, i, j, word, 0);
                }
            }
        }
        
        return res;
    }
    
    public boolean backtrack(char[][] board, int x, int y, String word, int pos){
    	if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
    		return false;
    	} else if(visited[x][y] == true){
            return false;
        } else if(pos == word.length() - 1 && word.charAt(pos) == board[x][y]){
            return true;
        } else if(pos < word.length() && word.charAt(pos) != board[x][y]){
            return false;
        }
    	
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean res = false;
    
        visited[x][y] = true;
        for(int i = 0; i < dx.length; ++i){
            int newX = x + dx[i];
            int newY = y + dy[i];
            res = res || backtrack(board, newX, newY, word, pos + 1);
        }
        visited[x][y] = false;
        return res;
    }
    
    
    public static void main(String[] args){
    	Q123_Word_Search t = new Q123_Word_Search();
    	char[][] board = {
    			{'A', 'B', 'C', 'E'},
    			{'S', 'F', 'C', 'S'},
    			{'A', 'D', 'E', 'E'}
    	};
    	System.out.println(t.exist(board, "ABCCED"));
    }
}
