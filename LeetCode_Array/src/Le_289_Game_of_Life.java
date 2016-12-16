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


public class Le_289_Game_of_Life {
	public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        
        int row = board.length, col = board[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int liveNum = getNeighborNum(board, i, j);
                
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
    
    public int getNeighborNum(int[][] board, int x, int y){
        int row = board.length, col = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int count = 0;
        
        for(int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if(newX >= 0 && newX < row && newY >= 0 && newY < col){
                count += (board[newX][newY] & 1);
            }
        }
        
        return count;
    }
}
