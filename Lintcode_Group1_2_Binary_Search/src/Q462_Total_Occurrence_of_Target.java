
public class Q462_Total_Occurrence_of_Target {
	// by Jackie
	public int totalOccurrence(int[] A, int target) {
		if(A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]){
            return 0;
        }
        int left = 0, right = A.length - 1;
        int leftBound = -1, rightBound = -1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target > A[mid]){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if(A[left] == target){
        	leftBound = left;
        } else if(A[right] == target){
        	leftBound = right;
        } else {
        	return 0;
        }
        
        left = 0;
        right = A.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target >= A[mid]){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if(A[right] == target){
        	rightBound = right;
        } else if(A[left] == target){
        	rightBound = left;
        } else {
        	return 0;
        }
        
        return (rightBound - leftBound + 1);
    }
}
