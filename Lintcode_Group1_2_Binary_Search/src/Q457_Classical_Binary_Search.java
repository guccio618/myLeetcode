
public class Q457_Classical_Binary_Search {
	// by Jackie
	public int findPosition(int[] A, int target) {
		if(A == null || A.length == 0 || target < A[0] || target > A[A.length-1]){
            return -1;
        }
        int left = 0, right = A.length - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target < A[mid]){
            	right = mid;
            }
            else if(target > A[mid]){
                left = mid;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
