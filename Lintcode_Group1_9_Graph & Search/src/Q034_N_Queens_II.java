
public class Q034_N_Queens_II {
	// by Jackie
	private int res = 0;
	
	public int totalNQueens(int n) {
        if(n <= 0){
            return 0;
        }
        int[] x = new int[n + 1];
        helper(x, 1, n);
        return res;
    }
    
    public void helper(int[] x, int row, int n){
        if(row <= n){
            for(int i = 1; i <= n; ++i){
                x[row] = i;
                if(valid(x, row)){
                    helper(x, row + 1, n);
                }
            }
        } else{
            res++;
        }
    }
    
    public boolean valid(int[] x, int row){
        for(int i = 1; i < row; ++i){
            if(x[i] == x[row] || Math.abs(i - row) == Math.abs(x[i] - x[row])){
                return false;
            }
        }
        return true;
    }
    
    
    
    public static void main(String[] args){
    	Q034_N_Queens_II t = new Q034_N_Queens_II();
    	System.out.println(t.totalNQueens(1));
    }
}
