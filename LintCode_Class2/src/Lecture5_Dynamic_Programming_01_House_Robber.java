
public class Lecture5_Dynamic_Programming_01_House_Robber {
	public long houseRobber(int[] A) {
        int n = A.length;
        long []res = new long[A.length];
        long ans = 0;
        if(n==0)
            return 0;
        if(n >= 1) 
            res[0] = A[0];
        if(n >= 2)
            res[1] = Math.max(A[0], A[1]);
        if(n >= 3)
            res[2] = Math.max(A[0]+A[2], A[1]);
        if(n > 2){
            for(int i = 3; i < n; i++) {
                res[i] = Math.max(res[i-3], res[i-2])+ A[i];
            }
        }
        for(int i =0 ; i < n; i++){
            ans = Math.max(ans,res[i]);
        }
        return ans;
    }
}
