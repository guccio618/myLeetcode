
public class Q459_Closest_Number_in_Sorted_Array {
	// by Jackie
	public int closestNumber(int[] A, int target) {
		if(A == null || A.length == 0){
            return -1;
        }
        if(target < A[0]){
            return 0;
        }
        if(target > A[A.length - 1]){
            return A.length - 1;
        }
        int left = 0, right = A.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target > A[mid]){
                left = mid;
            }
            else if(target < A[mid]){
                right = mid;
            }
            else{
                return mid;
            }
        }
        
        if(Math.abs(A[left] - target) > Math.abs(A[right] - target)){
            return right;
        } else{
            return left;
        }
    }
}
