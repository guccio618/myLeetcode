/*****
 * 
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.

 * 
 * */


public class Le_351_Android_Unlock_Patterns {
	private int[][] jumpStatus = new int[10][10];
    private boolean[] visited = new boolean[10];  
    
    public int numberOfPatterns(int m, int n) {
        jumpStatus[1][3] = jumpStatus[3][1] = 2;
        jumpStatus[4][6] = jumpStatus[6][4] = 5;
        jumpStatus[7][9] = jumpStatus[9][7] = 8;
        jumpStatus[1][7] = jumpStatus[7][1] = 4;
        jumpStatus[2][8] = jumpStatus[8][2] = 5;
        jumpStatus[3][9] = jumpStatus[9][3] = 6;
        jumpStatus[1][9] = jumpStatus[9][1] = jumpStatus[3][7] = jumpStatus[7][3] = 5;
        
        int count = 0;
        count += DFS(1, m, n, 1, 0) * 4;    // solutionLen 从1开始 ！！！
        count += DFS(2, m, n, 1, 0) * 4;
        count += DFS(5, m, n, 1, 0);
        return count;
    }
    
    public int DFS(int start, int m, int n, int solutionLen, int count) {
        if(solutionLen > n) {
            return count;
        } else if(solutionLen >= m) {
            count++;
        }
        
        visited[start] = true;
        
        for(int next = 1; next <= 9; next++) {    // next 从 1 - 9 ！！！
            int jumpNeed = jumpStatus[start][next];
            
            if(!visited[next] && (jumpNeed == 0 || visited[jumpNeed] == true)) {
                count = DFS(next, m, n, solutionLen + 1, count);
            }
        }
        
        visited[start] = false;
        return count;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    /******************************* main function *******************************************/
    
    public static void main(String[] args){
    	Le_351_Android_Unlock_Patterns t = new Le_351_Android_Unlock_Patterns();
    	System.out.println(t.numberOfPatterns(1, 2));
    }
}
