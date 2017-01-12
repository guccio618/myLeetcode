/*********
 * 
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
	Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
	In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems? 
 * 
 * 
 * */

public class Le_289_Game_of_Life {
	/********************************************************************************************************
	 * (1). use 2 bits to store 2 states: [2nd bit, 1st bit] = [next state, current state]
	 * 		- 00  dead (next) <- dead (current)
	 * 		- 01  dead (next) <- live (current)  
	 * 		- 10  live (next) <- dead (current)  
	 * 		- 11  live (next) <- live (current) 
	 * 
	 * (2). Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
	 * (3). For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.
	 * 			Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
	 * 			Transition 00 -> 10: when board == 0 and lives == 3.
	 * 		To get the current state, simply do: board[i][j] & 1
	 * 		To get the next state, simply do: board[i][j] >> 1
	 * 
	 ********************************************************************************************************/
	
	// solution 1: naive, time is O(n^2), space is O(n^2)
	public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        
        int row = board.length, col = board[0].length;
        int[][] tempBoard = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int liveNum = getLiveNeighborNum(board, i, j);
                
                if(board[i][j] == 1 && liveNum >= 2 && liveNum <= 3){
                	tempBoard[i][j] = 1;
                } else if(board[i][j] == 0 && liveNum == 3){
                	tempBoard[i][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = tempBoard[i][j];
            }
        }
    }
    
    public int getLiveNeighborNum(int[][] board, int x, int y){
        int row = board.length, col = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int count = 0;
        
        for(int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < row && newY >= 0 && newY < col && board[newX][newY] == 1){
                count++;
            }
        }
        
        return count;
    }
	
    
    
    
	
	// follow up: solution 2, in place
	public void gameOfLife2(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        
        int row = board.length, col = board[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int liveNum = getNeighborNum2(board, i, j);
                
                if(board[i][j] == 1 && liveNum >= 2 && liveNum <= 3){
                    board[i][j] = 3;
                } else if(board[i][j] == 0 && liveNum == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] >>= 1;
            }
        }
    }
    
    public int getNeighborNum2(int[][] board, int x, int y){
        int row = board.length, col = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int count = 0;
        
        for(int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < row && newY >= 0 && newY < col){  // 这里必须用 board[newX][newY] & 1, 用位运算的方法读取前一天的状态 ！！！
                count += (board[newX][newY] & 1);
            }
        }
        
        return count;
    }
}
