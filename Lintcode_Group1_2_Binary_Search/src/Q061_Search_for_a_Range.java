
public class Q061_Search_for_a_Range {
	// by Jackie
	public int[] searchRange(int[] A, int target) {
		int res[] = {-1, -1};
        if(A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]){
            return res;
        }
        int left = 0, right = A.length - 1;
        
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
            res[0] = left;
        } else if(A[right] == target){
            res[0] = right;
        } else{
            res[0] = res[1] = -1;
            return res;
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
            res[1] = right;
        } else if(A[left] == target){
            res[1] = left;
        } else{
            res[0] = res[1] = -1;
        }
        return res;
    }
	
	
	public static void main(String[] args){
		Q061_Search_for_a_Range t = new Q061_Search_for_a_Range();
		int[] num = {5,5,5,5,5,5,5,5,5,5};
		int[] res = t.searchRange(num, 5);
		for(int i = 0; i < res.length; ++i){
			System.out.print(res[i] + ", ");
		}
	}
}
