
public class Q289_Game_of_Life {
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
