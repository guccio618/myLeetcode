
public class Q052_N_Queens_II {
	/********************************************************/
	// by Jackie using backtrack (recursive)
	private int count = 0;
    
    public int totalNQueens(int n) {
        if(n <= 0){
            return 0;
        }
        
        int[] position = new int[n + 1];
        backtrack(position, 1, n);
        return count;
    }
    
    public void backtrack(int[] position, int row, int n){
        if(row > n){
            count++;
        } else {
            for(int i = 1; i <= n; i++){
                position[row] = i;
                if(isValid(position, row) == true){
                    backtrack(position, row + 1, n);
                }
            }    
        }
    }
    
    public boolean isValid(int[] position, int curRow){
        for(int i = 1; i < curRow; i++){
            if(position[i] == position[curRow] || (Math.abs(i - curRow) == Math.abs(position[i] - position[curRow]))){
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args){
    	Q052_N_Queens_II t = new Q052_N_Queens_II();
    	System.out.println(t.totalNQueens(8));
    }
}
