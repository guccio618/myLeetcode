
public class Le_052_N_Queens_II {
private int count = 0;
    
    public int totalNQueens(int n) {
        if(n <= 0){
            return 0;
        }
        
        int[] position = new int[n + 1];
        helper(position, 1, n);
        return count;
    }
    
    public void helper(int[] position, int row, int n){
        if(row > n){
            count++;
            return;
        }
        
        for(int i = 1; i <= n; i++){
            position[row] = i;
            if(isValid(position, row)){
                helper(position, row + 1, n);
            }
        }
    }
    
    public boolean isValid(int[] position, int row){
        for(int i = 1; i < row; i++){
            if(position[row] == position[i] || Math.abs(row - i) == Math.abs(position[row] - position[i])){
                return false;
            }
        }
        return true;
    }
    
    
}
