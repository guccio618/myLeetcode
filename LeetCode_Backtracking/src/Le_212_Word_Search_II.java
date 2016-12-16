import java.util.ArrayList;
import java.util.List;

public class Le_212_Word_Search_II {
	private TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words.length == 0){
            return ans; 
        }
        
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(String word : words){
            insert(word);
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                backtrack(ans, "", i, j, board, visited, root);
            }
        }
        
        return ans;
    }
    
    public void backtrack(List<String> ans, String path, int x, int y, char[][] board, boolean[][] visited, TrieNode node){
        if(visited[x][y] == true){
            return;
        } else if(search(node, board[x][y]) == false){
            return;
        }
        
        node = node.child[board[x][y] - 'a'];   // 注意，先对node = node.child[position]操作 ！！！
        if(node.isWord == true){
            ans.add(path + board[x][y]);
            node.isWord = false;
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                backtrack(ans, path + board[x][y], newX, newY, board, visited, node);
            }
        }
        
        visited[x][y] = false;
    }
    
    public void insert(String str){
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for(int i = 0; i < letters.length; i++){
            if(node.child[letters[i] - 'a'] == null){
                node.child[letters[i] - 'a'] = new TrieNode();
                node.child[letters[i] - 'a'].val = letters[i];
            }
            node = node.child[letters[i] - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(TrieNode node, char c){
        if(node.child[c - 'a'] == null){
            return false;
        } else {
            return true;
        }
    }
    
    class TrieNode {
        char val;
        TrieNode[] child;
        boolean isWord;
        
        public TrieNode(){
            child = new TrieNode[26];
            isWord = false;
        }
    }
}
