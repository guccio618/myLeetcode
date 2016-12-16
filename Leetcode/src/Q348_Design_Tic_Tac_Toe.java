
public class Q348_Design_Tic_Tac_Toe {
	private int[] rows;
    private int[] cols;
    private int diagonal = 0;
    private int antiDiagonal = 0;
    private int size = 0;
    
    /** Initialize your data structure here. */
    public Q348_Design_Tic_Tac_Toe(int n) {
        rows = new int[n];
        cols = new int[n];
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int num = (player == 1) ? 1 : -1;
        
        rows[row] += num;
        cols[col] += num;
        
        if(col == row){
            diagonal += num;
        } 
        
        if(col + row == size - 1){
            antiDiagonal += num;
        }
        
        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size){
            return player;
        } else {
            return 0;
        }
    }
}
