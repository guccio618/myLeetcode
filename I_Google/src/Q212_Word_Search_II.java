import java.util.ArrayList;
import java.util.List;
/*******
 * 
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

 * 
 * */


public class Q212_Word_Search_II {
	private Trie root = new Trie();
  
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return ans;
        }
        
        for(String word : words) {
            addWord(word);
        }
        
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                backtrack(ans, board, i, j, visited, root, "");
            }
        }
        
        return ans;
    }
    
    public void backtrack(List<String> ans, char[][] board, int x, int y, boolean[][] visited, Trie node, String solution) {
        if(visited[x][y] == true) {
            return ;
        } 
        
        int pos = board[x][y] - 'a';
        
        if(node.child[pos] == null || node.child[pos].value != board[x][y]) {
            return ;
        } 
        
        solution += board[x][y];
        node = node.child[pos];
        
        if(node.isWord == true) {
            ans.add(solution);
            node.isWord = false;
        }
        
        visited[x][y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                backtrack(ans, board, newX, newY, visited, node, solution);
            }
        }
        
        visited[x][y] = false;
    }
    
    public void addWord(String word) {
        char[] letters = word.toCharArray();
        Trie node = root;
        
        for(int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            
            if(node.child[pos] == null) {
                node.child[pos] = new Trie();
                node.child[pos].value = letters[i];
            }
            
            node = node.child[pos];
        }
        
        node.isWord = true;
    }
        
    class Trie {
        char value;
        boolean isWord;
        Trie[] child;
        
        public Trie() {
            value = ' ';
            isWord = false;
            child = new Trie[26];
        }
    }
    
    
    
    
    
    
    
    
    
    /****************************** main function ****************************************/
    
    public static void main(String[] args){
    	Q212_Word_Search_II t = new Q212_Word_Search_II();
    	char[][] board = {
    			{'a'},
    			{'a'}
    	};
    	String[] words = {"a"};
    	List<String> res = t.findWords(board, words);
    	
    	for(int i = 0; i < res.size(); ++i){
    		System.out.println(res.get(i));
    	}
    }
}
