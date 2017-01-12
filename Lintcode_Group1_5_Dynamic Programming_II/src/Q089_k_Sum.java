import java.util.Arrays;


public class Q089_k_Sum {
	/*******************************************************/
	// by ninechapter using DP
	public int kSum(int A[], int k, int target) {
		int n = A.length;
		int[][][] f = new int[n + 1][k + 1][target + 1];
		
		for (int i = 0; i < n + 1; i++) {
			f[i][0][0] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k && j <= i; j++) {
				for (int t = 1; t <= target; t++) {
					f[i][j][t] = 0;     // 此行必须要！！！
					
					if (t >= A[i - 1]) {
						f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
					}
					f[i][j][t] += f[i - 1][j][t];
				} // for t
			} // for j
		} // for i
		return f[n][k][target];
	}
	
	
	/*******************************************************/
	// by Jackie using recursive, but time limit exceeded
	private boolean[] visited;
    private int res = 0;
    
    public int kSum2(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        visited = new boolean[A.length];
        Arrays.sort(A);
        for(int i = 0; i < A.length; ++i){
        	helper(A, visited, i, k, 1, target);
        }
        return res;
    }
    
    public void helper(int A[], boolean[] visited, int pos, int k, int n, int sum){
        visited[pos] = true;
        sum -= A[pos];
        if(sum == 0 || n == k){
        	if(sum == 0 && n == k){
        		res++;
        	}
        	return;
        }
        for(int i = pos+1; i < A.length; ++i){
        	if(sum > 0){
        		helper(A, visited, i, k, n+1, sum);
        	}
        }       
        visited[pos] = false;
    }
    
    
    public static void main(String[] args){
    	Q089_k_Sum t = new Q089_k_Sum();
    	int[] nums = {1,4,6,8,10,13,15,17,18,21,23,26,27,28,29,30,32,35,36};
    	int[] A = {1,2,3,4};
    	System.out.println(t.kSum2(nums, 9, 133));
    }
}
