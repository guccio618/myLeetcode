
public class Q064_Merge_Sorted_Array {
	// by Jackie
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if(A == null || A.length == 0){
            A = B;
            return;
        }
        if(B == null || B.length == 0){
            return;
        }
        
        int x = m-1, y = n-1, k = m+n-1;  // 从后往前，防止A[x]把A[k]给覆盖
        while(k >= 0){
            if(x >= 0 && y < 0){
                A[k--] = A[x--];
            }
            else if(x < 0 && y >= 0){
                A[k--] = B[y--];
            }
            else{
                if(A[x] > B[y]){
                    A[k--] = A[x--];
                }
                else{
                    A[k--] = B[y--];
                }
            }
        }
    }
	
	
	public static void main(String[] args){
		Q064_Merge_Sorted_Array t = new Q064_Merge_Sorted_Array();
		int[] A = {1,2,3}, B = {4,5};
		t.mergeSortedArray(A, 3, B, 2);
		for(int i = 0; i < A.length; ++i){
			System.out.print(A[i] + ", ");
		}
	}
}
