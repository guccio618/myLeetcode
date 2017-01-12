
public class Q396_Coins_in_a_Line_III {
	/***************************************************/
	// by Jackie using DP
	public boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return false;
        } else if(values.length <= 2){
            return true;
        }
        
        int n = values.length;
        int[][] dp = new int[n][n];
        int sum = values[0];
        
        for(int i = 1; i < n; ++i){
            sum += values[i];    
        }
        
        for(int i = 0; i < n; ++ i){
            dp[i][i] = values[i];
        }
        
        for(int i = 0; i < n - 1; ++i){
            dp[i][i + 1] = Math.max(values[i], values[i + 1]);
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                int end = start + length;
                dp[start][end] = Math.max(Math.min(dp[start + 2][end], dp[start + 1][end - 1]) + values[start], Math.min(dp[start][end - 2], dp[start + 1][end - 1]) + values[end]);
            }
        }
        
        return 2 * dp[0][n - 1] > sum;
    }
	
	
	
	
	/***************************************************/
	// by Jackie using memory search
	public boolean firstWillWin2(int[] values) {
        if(values == null || values.length == 0){
            return false;
        } 
        
        int n = values.length;
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int sum = values[0];
        
        for(int i = 1; i < n; ++i){
            sum += values[i];    
        }
        
        return 2 * memorySearch(values, 0, n - 1, visited, dp) > sum;
    }
    
    public int memorySearch(int[] values, int x, int y, boolean[][] visited, int[][] dp){
        if(visited[x][y] == true){
            return dp[x][y];
        } 
        visited[x][y] = true;
        if(x == y){
            dp[x][y] = values[x];
        } else if(x + 1 == y){
            dp[x][y] = Math.max(values[x], values[y]);
        } else{
            int num1 = memorySearch(values, x + 2, y, visited, dp);
            int num2 = memorySearch(values, x + 1, y - 1, visited, dp);
            int num3 = memorySearch(values, x, y - 2, visited, dp);
            int num4 = num2;
            dp[x][y] = Math.max(Math.min(num1, num2) + values[x], Math.min(num3, num4) + values[y]);
        }
        
        return dp[x][y];
    }

	
	
//    /************************** main function *************************/
    
	public static void main(String[] args){
		Q396_Coins_in_a_Line_III t = new Q396_Coins_in_a_Line_III();
		int[] values = {1,2,3,4,5,6,7,8,13,11,10,9};
		System.out.println(t.firstWillWin(values));
	}
}
