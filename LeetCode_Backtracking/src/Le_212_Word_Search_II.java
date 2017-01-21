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


public class Le_212_Word_Search_II {
	private TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return ans;
        }
        
        for(String word : words) {
            addWord(word);
        }
        
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                DFS(ans, board, visited, i, j, "", root);
            }
        }
        
        return ans;
    }
    
    public void DFS(List<String> ans, char[][] board, boolean[][] visited, int x, int y, String solution, TrieNode node) {
        if(visited[x][y] == true) {
            return;
        } 
        
        int pos = board[x][y] - 'a';
        
        if(node.children[pos] == null) {
            return;
        } 
        
        node = node.children[pos];
        solution += board[x][y];
        
        if(node.isWord == true) {
            ans.add(solution);
            node.isWord = false;
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                DFS(ans, board, visited, newX, newY, solution, node);
            }
        }
        
        visited[x][y] = false;
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        
        for(int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            
            if(node.children[pos] == null) {
                node.children[pos] = new TrieNode();
                node.children[pos].value = letters[i];
            }
            
            node = node.children[pos];
        }
        
        node.isWord = true;
    }
    
    
    class TrieNode {
        char value;
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            this.value = ' ';
            children = new TrieNode[26];
            isWord = false;
        }
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    /****************************** main function ****************************************/
    
    public static void main(String[] args){
    	Le_212_Word_Search_II t = new Le_212_Word_Search_II();
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
