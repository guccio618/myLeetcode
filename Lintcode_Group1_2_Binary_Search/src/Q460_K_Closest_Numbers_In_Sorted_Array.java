
public class Q460_K_Closest_Numbers_In_Sorted_Array {
	// by Jackie
	public int[] kClosestNumbers(int[] A, int target, int k) {
        if(A == null || A.length == 0 || k <= 0 || k > A.length){
            return new int[0];
        }
        int len = A.length;
        int[] res = new int[k];
        int left = 0, right = len - 1;
        
        while(left + 1 < right){    // O(logn)
            int mid = left + (right - left) / 2;
            if(target > A[mid]){
                left = mid;
            } else{
                right = mid;
            }
        }

        for(int index = 0; index < k; ++index){    // O(k)
            if(left >= 0 && right >= len){
                res[index] = A[left--];
            } else if(left < 0 && right < len){
                res[index] = A[right++];
            } else{
                if(Math.abs(A[left] - target) <= Math.abs(A[right] - target)){
                    res[index] = A[left--];
                } else{
                    res[index] = A[right++];
                }
            }
        }
        
        return res;
    }
	
	
	
	/****************************** main function *********************************/
	public static void main(String[] args){
		Q460_K_Closest_Numbers_In_Sorted_Array t = new Q460_K_Closest_Numbers_In_Sorted_Array();
		int[] nums = {1,4,6,10,20};
		int[] res = t.kClosestNumbers(nums, 21, 4);
		
		for(int i = 0; i < res.length; ++i){
			System.out.print(res[i] + ", ");
		}
	}
}
