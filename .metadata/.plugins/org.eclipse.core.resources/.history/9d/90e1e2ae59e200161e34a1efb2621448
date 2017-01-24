import java.util.*;
/*******
 * 
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
A partially filled sudoku which is valid.

Note:
	A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	
 * 
 * */

public class Q036_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        
        for(int i = 0; i < 9; i++){
            if(isValid(board, i, i, 0, 8) == false){   // check row
                return false;
            }
            
            if(isValid(board, 0, 8, i, i) == false){   // check col
                return false;
            }
        }
        
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                if(isValid(board, i, i + 2, j, j + 2) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int row_start, int row_end, int col_start, int col_end) {
        Set<Character> set = new HashSet<Character>();
        
        for(int i = row_start; i <= row_end; i++){
            for(int j = col_start; j <= col_end; j++){
                if(board[i][j] != '.'){
                    if(!set.contains(board[i][j])){
                        set.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
		
}
