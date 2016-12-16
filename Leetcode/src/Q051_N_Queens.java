import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Q051_N_Queens {
	/**********************************************************************/
	// by Jackie using backtrack(recursive)
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if(n <= 0){
            return ans;
        }
        
        int[] position = new int[n + 1];
        backtrack(ans, position, 1, n);
        return ans;
    }
    
    public void backtrack(List<List<String>> ans, int[] position, int curRow, int n){
        if(curRow > n){
            ans.add(getStr(position));
        } else {
            for(int i = 1; i <= n; i++){
                position[curRow] = i;
                if(isValid(position, curRow) == true){
                    backtrack(ans, position, curRow + 1, n);
                }
            }
        }
    }
    
    public boolean isValid(int[] position, int curRow){
        for(int i = 1; i < curRow; i++){
            if(position[i] == position[curRow] || Math.abs(position[i] - position[curRow]) == Math.abs(i - curRow)){
                return false;
            }
        }
        return true;
    }
    
    public List<String> getStr(int[] position){
        List<String> list = new ArrayList<String>();
        int n = position.length - 1;
        
        for(int i = 1; i <= n; i++){
            StringBuffer builder = new StringBuffer();
            for(int j = 1; j <= n; j++){
                if(position[i] == j){
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            list.add(builder.toString());
        }
        
        return list;
    }
    
    
    public static void main(String[] args){
    	Q051_N_Queens t = new Q051_N_Queens();
    	List<List<String>> res = t.solveNQueens(8);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	} 
    	System.out.println("size = " + res.size());
    }
}
