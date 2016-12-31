import java.util.Arrays;


public class Lecture4_Two_Pointers_11_The_Smallest_Difference {
	public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idA = 0, idB = 0; 
        int ans = Integer.MAX_VALUE;
        for(idA = 0; idA < A.length && idB < B.length; idA++) {
            while(idB + 1 < B.length) {
                if(B[idB + 1] > A[idA]) {
                    break;
                }
                idB++;
            }
            if(idB < B.length) {
                ans = Math.min(ans, Math.abs(B[idB]- A[idA]));
            }
            if(idB + 1 < B.length) {
                ans = Math.min(ans, Math.abs(B[idB + 1]- A[idA]));
            }
        }
        
        return ans;
    }
}
