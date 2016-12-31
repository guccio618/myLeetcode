import java.util.ArrayList;


public class Lecture2_Data_Structure_I_08_Word_Search_II {
	private TrieNode root;
	private char[][] board;
	private boolean[][] visited;
	private ArrayList<String> res = new ArrayList<String>();
	private int m;
	private int n;
	
	class TrieNode{
        TrieNode[] children;
        char val;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
	
	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words){       
        if(board == null || board.length == 0 || words.size()  == 0){
            return res;
        }
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        StringBuffer sb = new StringBuffer();
        root = new TrieNode();
        
        for(String str : words){
        	addWord(str);
        }
        
        for(int i = 0; i < m; ++i){
        	for(int j = 0; j < n; ++j){
        		helper(i, j, sb, root);
        	}
        }
        return res;
    }
	
	public void helper(int x, int y, StringBuffer sb, TrieNode node){
		if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == true){
			return;
		}
		if(search(node, board[x][y]) == true){
			int pos = board[x][y] - 'a';
			node = node.children[pos];
			
			visited[x][y] = true;
			sb.append(board[x][y]);
			
			if(node.isEnd == true){
				res.add(sb.toString());
				node.isEnd = false;
			}
						
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
		
			for(int i = 0; i < 4; ++i){
				int newX = x + dx[i];
				int newY = y + dy[i];
				helper(newX, newY, sb, node);
			}
		
			sb.deleteCharAt(sb.length() - 1);
			visited[x][y] = false;
		}
	}
       
    public void addWord(String word){
        TrieNode node = root;
        int len = word.length();
        
        for(int i = 0; i < len; ++i){
            char c = word.charAt(i);
            int pos = c - 'a';
            if(node.children[pos] == null){
                node.children[pos] = new TrieNode();
                node.children[pos].val = c;
            } 
            node = node.children[pos];
        }
        node.isEnd = true;
    }
    
    public boolean search(TrieNode node, char c){
    	int pos = c - 'a';
    	if(node.children[pos] == null){
    		return false;
    	} else{
    		return true;
    	}
    }
}
