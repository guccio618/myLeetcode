
public class Q063_Search_in_Rotated_Sorted_Array_II {
	/*************
	 * Star
	 *************/
	
	// by Jackie
	public boolean search(int[] A, int target) {
        if(A == null || A.length == 0){
            return false;
        }
        int left = 0, right = A.length-1;
        while(left + 1 < right){
        	int mid = left + (right - left) / 2; 
            if(A[mid] == target){
                return true;
            }
            else if(A[mid] > A[left] || A[mid] > A[right]){
                if(target < A[mid] && target >= A[left]){   // 注意有等号，>=
                    right = mid;
                }
                else{
                    left = mid;
                }
            }
            else if(A[mid] < A[right] || A[mid] < A[left]){
                if(target > A[mid] && target <= A[right]){  // 注意有等号，<=
                    left = mid;
                }
                else{
                    right = mid;
                }
            }
            else{
                right--;    // 排除重复，左移
            }
        }
        
        if(A[left] == target || A[right] == target){
            return true;
        }
        
        return false;
    }
	
	
	public static void main(String[] args){
		Q063_Search_in_Rotated_Sorted_Array_II t = new Q063_Search_in_Rotated_Sorted_Array_II();
		int[] A = {9,5,6,7,8,9,9,9,9,9,9};
		System.out.println(t.search(A, 8));
	}
}
