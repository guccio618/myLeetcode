
/****************************************************
 * (1). DP + backtrack
 * (2). jumps[i][j] 表示从i跳到j需要经过的格子号
 * 
 ****************************************************/

public class Le_351_Android_Unlock_Patterns {
	private int[][] jumps = new int[10][10];
    private boolean[] visited = new boolean[10];
    
    
    public int numberOfPatterns(int m, int n) {
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        
        int count = 0;
        count += DFS(1, 1, 0, m, n) * 4;    // 注意这里的solutionLen 的值为1， count 的值为0 ！！！
        count += DFS(2, 1, 0, m, n) * 4;
        count += DFS(5, 1, 0, m, n);
        return count;
    }
    
    private int DFS(int start, int solutionLen, int count, int m, int n) {
        if(solutionLen >= m){
            count++;
        }
        
        solutionLen++;
        if(solutionLen > n){
            return count;
        }
        
        visited[start] = true;
        
        for(int next = 1; next <= 9; next++){
            int jump = jumps[start][next];
            if(!visited[next] && (jump == 0 || visited[jump] == true)){   // 注意这里的写法！！！ jump == 0表示相邻的格子，因此不需要check中间的格子是否已经被访问过 ！！！
                count = DFS(next, solutionLen, count, m, n);              // count 这里的写法， 相当于 count += ！！！
            }
        }
        
        visited[start] = false;
        return count;
    }

    
    
    public static void main(String[] args){
    	Le_351_Android_Unlock_Patterns t = new Le_351_Android_Unlock_Patterns();
    	System.out.println(t.numberOfPatterns(1, 2));
    }
}
