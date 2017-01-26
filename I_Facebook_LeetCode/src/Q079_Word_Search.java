/********
 * 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
Show Company Tags
Hide Tags

 * 
 * */


public class Q079_Word_Search {
	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            if (word == null || word.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(backtrack(board, word, 0, i, j, visited) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean backtrack(char[][] board, String word, int start, int x, int y, boolean[][] visited) {
        if(visited[x][y] == true) {
            return false;
        } else if(board[x][y] != word.charAt(start)) {
            return false;
        } else if(start == word.length() - 1) {   // 必须在这里判断，防止test case: [a], a  ！！！
            return true;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if(backtrack(board, word, start + 1, newX, newY, visited) == true) {
                    return true;
                }
            }
        }
        
        visited[x][y] = false;
        return false;
    }
	
	
	
    
    
    
    
    
    
    
    /****************************************************************************************************************/
    
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
