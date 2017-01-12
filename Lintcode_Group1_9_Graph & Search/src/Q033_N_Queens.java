import java.util.ArrayList;


public class Q033_N_Queens {
	// by Jackie
	ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(n <= 0){
            return res;
        }
        
        int[] position = new int[n + 1];
        int row = 1, col = 1;
        while(row <= n){
            while(col <= n){
                if(valid(position, row, col)){
                    position[row] = col;
                    col = 1;
                    break;
                } else{
                    col++;
                }
            }
            
            if(position[row] == 0){
                if(row == 1){
                    return res;
                } else{
                    row--;
                    col = position[row] + 1;
                    position[row] = 0;
                    continue;
                }
            } 
        
            if(row == n){
                res.add(getString(position));
                col = position[row] + 1;
                position[row] = 0;
            } else{
                row++;
            }
        }
        return res;
    }
    
    public boolean valid(int[] position, int row, int col){
        for(int i = 1; i < row; ++i){
            if(position[i] == col || Math.abs(i - row) == Math.abs(position[i] - col)){
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<String> getString(int[] position){
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 1; i < position.length; ++i){
            StringBuffer sb = new StringBuffer();
            for(int j = 1; j < position.length; ++j){
                if(j == position[i]){
                    sb.append("Q");
                } else{
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    
    public static void main(String[] args){
    	Q033_N_Queens t = new Q033_N_Queens();
    	ArrayList<ArrayList<String>> res = t.solveNQueens(2);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.println(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
