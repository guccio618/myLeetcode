
public class Q458_Last_Position_of_Target {
	// by Jackie
	public int lastPosition(int[] A, int target) {
        if(A == null || A.length == 0 || target < A[0] || target > A[A.length-1]){
            return -1;
        }
        int left = 0, right = A.length-1;
        
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
        	return right;
        } else if(A[left] == target){
        	return left;
        } else{
        	return -1;
        }
    }
	
	public static void main(String[] args){
		Q458_Last_Position_of_Target t = new Q458_Last_Position_of_Target();
		int[] A = {1,2,2,4,5,5};
		System.out.println(t.lastPosition(A, 5));
	}
}
