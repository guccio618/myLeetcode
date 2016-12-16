import java.util.ArrayList;
import java.util.List;

public class Q212_Word_Search_II {
	// by other
//	private TrieNode root;
//	private char[][] board;
//	private boolean[][] visited;
//	private List<String> res = new ArrayList<String>();
//	private int m;
//	private int n;
//	
//	class TrieNode{
//        TrieNode[] children;
//        char val;
//        boolean isEnd;
//        
//        public TrieNode(){
//            children = new TrieNode[26];
//            isEnd = false;
//        }
//    }
//	
//	public List<String> findWords(char[][] board, String[] words) {       
//        if(board == null || board.length == 0 || words.length  == 0){
//            return res;
//        }
//        this.board = board;
//        m = board.length;
//        n = board[0].length;
//        visited = new boolean[m][n];
//        StringBuffer sb = new StringBuffer();
//        root = new TrieNode();
//        
//        for(String str : words){
//        	addWord(str);
//        }
//        
//        for(int i = 0; i < m; ++i){
//        	for(int j = 0; j < n; ++j){
//        		helper(i, j, sb, root);
//        	}
//        }
//        return res;
//    }
//	
//	public void helper(int x, int y, StringBuffer sb, TrieNode node){
//		if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == true){
//			return;
//		}
//		if(search(node, board[x][y]) == true){
//			int pos = board[x][y] - 'a';
//			node = node.children[pos];
//			
//			visited[x][y] = true;
//			sb.append(board[x][y]);
//			
//			if(node.isEnd == true){
//				res.add(sb.toString());
//				node.isEnd = false;
//			}
//						
//			int[] dx = {1, -1, 0, 0};
//			int[] dy = {0, 0, 1, -1};
//		
//			for(int i = 0; i < 4; ++i){
//				int newX = x + dx[i];
//				int newY = y + dy[i];
//				helper(newX, newY, sb, node);
//			}
//		
//			sb.deleteCharAt(sb.length() - 1);
//			visited[x][y] = false;
//		}
//	}
//       
//    public void addWord(String word){
//        TrieNode node = root;
//        int len = word.length();
//        
//        for(int i = 0; i < len; ++i){
//            char c = word.charAt(i);
//            int pos = c - 'a';
//            if(node.children[pos] == null){
//                node.children[pos] = new TrieNode();
//                node.children[pos].val = c;
//            } 
//            node = node.children[pos];
//        }
//        node.isEnd = true;
//    }
//    
//    public boolean search(TrieNode node, char c){
//    	int pos = c - 'a';
//    	if(node.children[pos] == null){
//    		return false;
//    	} else{
//    		return true;
//    	}
//    }
    
    
    
    
    
    
    
    public List<String> findWords(char[][] board, String[] words) {
             List<String> ans = new ArrayList<String>();
             trieNode root = new trieNode();
             int row = board.length;
             int col = board[0].length;
             boolean[][] visited = new boolean[row][col];
            
             for(String str : words){
                 add(root, str);
             }
            
             for(int i = 0; i < row; ++i){
                 for(int j = 0; j < col; ++j){
                     helper(ans, board, i, j, visited, "", root);
                 }
             }
            
             return ans;
         }
        
         public void helper(List<String> ans, char[][] board, int x, int y, boolean[][] visited, String str, trieNode node){
             if(visited[x][y] == true){
                 return;
             }
             if(search(node, board[x][y]) == false){
                 return;
             }
            
             node = node.children[board[x][y] - 'a'];
             if(node.isWord == true){
                 ans.add(str + board[x][y]);
                 node.isWord = false;
             }
            
             int[] dx = {1, -1, 0, 0};
             int[] dy = {0, 0, 1, -1};
             visited[x][y] = true;
            
             for(int i = 0; i < 4; ++i){
                 int newX = x + dx[i];
                 int newY = y + dy[i];
                 if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                     helper(ans, board, newX, newY, visited, str + board[x][y], node);
                 }
             }
            
             visited[x][y] = false;
         }
        
         class trieNode{
             char val;
             boolean isWord;
             trieNode[] children;
            
             public trieNode(char v, boolean s){
                 val = v;
                 isWord = s;
                 children = new trieNode[26];
             }
            
             public trieNode(){
                 children = new trieNode[26];
             }
         }
        
         public void add(trieNode node, String word){
             char[] letters = word.toCharArray();
             for(int i = 0; i < letters.length; ++i){
                 int index = letters[i] - 'a';
                 if(node.children[index] == null){
                     node.children[index] = new trieNode(letters[i], false);
                 }
                 node = node.children[index];
             }
             node.isWord = true;
         }
        
         public boolean search(trieNode node, char c){
             int index = c - 'a';
             if(node.children[index] != null){
                 return true;
             } else {
                 return false;
             }
         }
    
    
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
