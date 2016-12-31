import java.util.LinkedList;
import java.util.Queue;


public class Lecture2_Data_Structure_I_05_Surrounded_Regions {
	private Queue<Integer> queue = new LinkedList<Integer>();
	private char[][]board;
	private int row, col; 
     
    public void surroundedRegions(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0){
        	return;
        }
        queue = new LinkedList<Integer>();
        this.board = board;
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) { // **important**，初始化边界
            enqueue(i, 0);
            enqueue(i, col - 1);
        }

        for (int j = 1; j < col - 1; j++) { // **important**，初始化边界
            enqueue(0, j);
            enqueue(row - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / col,
                y = cur % col;

            if (board[x][y] == 'O') {    // 从边界是O的结点开始，bfs，记录所有可以到达的结点为D
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'D'){      // 与边界为D的结点相连的值也为D的结点
                	board[i][j] = 'O';
                }
                else if (board[i][j] == 'O'){
                	board[i][j] = 'X';
                }
            }
        }

        queue = null;
        board = null;
        row = 0;
        col = 0;
    }

    public void enqueue(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] == 'O'){  
            queue.offer(x * col + y);
        }
    }
}
