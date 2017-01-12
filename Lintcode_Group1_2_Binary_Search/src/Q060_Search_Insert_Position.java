
public class Q060_Search_Insert_Position {
	// by ninechapter, 优化过的程序
	public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0 || target <= A[0]){
            return 0;
        }
        if(target >= A[A.length - 1]){
            return (target == A[A.length - 1]) ? A.length - 1 : A.length;
        }
        
        int left = 0, right = A.length - 1;
        
        while(left + 1< right){
            int mid = left + (right - left) / 2;
            if(target >= A[mid]){
                left = mid;
            } 
            else{
                right = mid;
            }
        }
        if(A[left] >= target)
            return left;
        if(A[right] >= target)
            return right;
 
        return A.length;
    }
	
	
	// by Jackie
	public int searchInsert2(int[] A, int target) {
        if(A == null || A.length == 0 || target <= A[0]){
            return 0;
        }
        if(target >= A[A.length - 1]){
            return (target == A[A.length - 1]) ? A.length - 1 : A.length;
        }
        
        int left = 0, right = A.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(target > A[mid]){
                left = mid + 1;
            } else if(target < A[mid]){
                right = mid - 1;
            } else{
                return mid;
            }
        }
 
        return (A[right] > target) ? right : right + 1;
    }
}
