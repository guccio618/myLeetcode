
public class Q079_Word_Search {
	/*************************************************************/
	// by other, faster
	public boolean exist(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int y=0; y<board.length; y++) {
	        for (int x=0; x<board[y].length; x++) {
	            if (exist(board, y, x, w, 0)) return true;
	        }
	    }
	    return false;
	}

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
	    if (i == word.length) return true;
	    if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
	    if (board[y][x] != word[i]) return false;

	    board[y][x] ^= 256;      // 转化为非ascii码，超过char范围，使之无法被访问，可以代替visited, nice
	    boolean exist = exist(board, y, x+1, word, i+1)
	        || exist(board, y, x-1, word, i+1)
	        || exist(board, y+1, x, word, i+1)
	        || exist(board, y-1, x, word, i+1);
	    board[y][x] ^= 256;
	    return exist;
	}
	
	
	/*************************************************************/
	// by Jackie using backtrack;
	public boolean exist2(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(backtrack(board, i, j, visited, word, 0) == true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean backtrack(char[][] board, int x, int y, boolean[][] visited, String word, int start){
        if(visited[x][y] == true){
            return false;
        } else if(start == word.length() - 1){  // 必须在这里判断，防止test case: [a], a  ！！！
        	return board[x][y] == word.charAt(start);
        } else if(board[x][y] != word.charAt(start)){
            return false;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(backtrack(board, newX, newY, visited, word, start + 1) == true){
                    return true;
                }
            }
        }
        
        visited[x][y] = false;
        return false;
    } 
    
    
 // 此方法不行，因为test case["a", a]无法通过，需要用if(index == word.length() - 1 && board[x][y] == word.charAt(index))
    // 判断，不能到index == word.length() 判断 !!!
    public boolean backtrack2(char[][] board, boolean[][] visited, int x, int y, String word, int index){
        if(index == word.length()){
            return true;
        } 
        if(visited[x][y] == true){
            return false;
        } 
        if(board[x][y] != word.charAt(index)){
            return false;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if(backtrack2(board, visited, newX, newY, word, index + 1) == true){
                    return true;
                }
            }
        }
        
        visited[x][y] = false;
        return false;
    }
    
    
    public static void main(String[] args){
    	Q079_Word_Search t = new Q079_Word_Search();
//    	char[][] board = {
//    						{'a','a','a','a'},
//    						{'a','a','a','a'},
//    						{'a','a','a','a'},
//    						{'a','a','a','a'},
//    						{'a','a','a','b'}    			
//    					 };
//    	System.out.println(t.exist(board, "aaaaaaaaaaaaaaaaaaaa"));
    	
    	char[][] board2 = {
    						{'A','B','C','E'},
    						{'S','F','C','S'},
    						{'A','D','E','E'}
    					  };
    	System.out.println(t.exist(board2, "ABCCED"));
    }
}
