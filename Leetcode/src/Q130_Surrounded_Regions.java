import java.util.LinkedList;
import java.util.Queue;
/******
 * 
Given a 2D board containing 'X' and 'O' (the letter O), 
capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

 * 
 * */

public class Q130_Surrounded_Regions {
	/*******************************************************************
	 * 矩阵用iterator进行bfs的方法： q里存 i * col + col
	 *  (1). 结点引入3态。
	 *  (2). 从边界入手，可以遍历到的结点改为第三态D
	 *  (3). 将第三态D的结点改为O, 将原来为O的结点改为X
	 *  
	 *******************************************************************/
	
	public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        Queue<Integer> queue = new LinkedList();
        int row = board.length, col = board[0].length;
        
        for(int i = 0; i < row; i++) {
            enqueue(board, i, 0, col, queue);
            enqueue(board, i, col-1, col, queue);
        }
        
        for(int i = 0; i < col; i++) {
            enqueue(board, 0, i, col, queue);
            enqueue(board, row-1, i, col, queue);
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / col;
            int y = index % col;
            board[x][y] = 'D';
            
            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(newX >= 0 && newX < row && newY >= 0 && newY < col && board[newX][newY] == 'O') {
                    enqueue(board, newX, newY, col, queue);
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'D'){
                	board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                	board[i][j] = 'X';
                }
            }
        }
    }
    
    public void enqueue(char[][] board, int x, int y, int col, Queue<Integer> queue) {
        if(board[x][y] == 'O') {
            queue.offer(x * col + y);
        }
    }
	
    
    
    
    
    
    
    
 
	// by ninechapter
//	private Queue<Integer> queue = new LinkedList<Integer>();
//	private char[][]board;
//	private int row, col;
//	
//	public void solve(char[][] board) {
//        if (board.length == 0 || board[0].length == 0){
//        	return;
//        }
//        
//        queue = new LinkedList<Integer>();
//        this.board = board;
//        row = board.length;
//        col = board[0].length;
//
//        for (int i = 0; i < row; i++) { // **important**
//            enqueue(i, 0);
//            enqueue(i, col - 1);
//        }
//
//        for (int j = 1; j < col - 1; j++) { // **important**  
//            enqueue(0, j);
//            enqueue(row - 1, j);
//        }
//
//        while (!queue.isEmpty()) {
//            int cur = queue.poll();
//            int x = cur / col,
//                y = cur % col;
//
//            if (board[x][y] == 'O') {
//                board[x][y] = 'D';
//            }
//
//            enqueue(x - 1, y);
//            enqueue(x + 1, y);
//            enqueue(x, y - 1);
//            enqueue(x, y + 1);
//        }
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == 'D'){
//                	board[i][j] = 'O';
//                } else if (board[i][j] == 'O'){
//                	board[i][j] = 'X';
//                }
//            }
//        }
//        
//        queue = null;
//        board = null;
//        row = 0;
//        col = 0;
//    }
//
//    public void enqueue(int x, int y) {
//        if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] == 'O'){  
//            queue.offer(x * col + y);
//        }
//    }
	

    
/********************** main function *****************************/    
    
    public static void main(String[] args){
    	Q130_Surrounded_Regions t = new Q130_Surrounded_Regions();
//    	char[][] board = {
//    			{'X', 'X', 'X', 'X'},
//    			{'X', 'O', 'O', 'X'},
//    			{'X', 'X', 'O', 'X'},
//    			{'X', 'O', 'X', 'X'}
//    	};
    	
    	char[][] board = {
    			{'O','O', 'O'},
    			{'O','O', 'O'},
    			{'O','O', 'O'}
    	};
    	
    	t.solve(board);
    	for(int i = 0; i < board.length; ++i){
    		for(int j = 0; j < board[i].length; ++j){
    			System.out.print(board[i][j] + ", ");
    		}
    		System.out.println();
    	}
    }
}
