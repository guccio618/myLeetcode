
public class Lecture2_Binary_Search_11_Search_in_Rotated_Sorted_Array {
	/************************************************************************************
	 * Binary Search
	 * 		分类讨论
	 * 		(1). 先判断mid的情况，mid是在左半部分或右半部分
	 * 		(2). 然后判断对应情况下，target的情况，target是否落在[start, mid]或者[mid, end]区间内
	 * 		
	 ************************************************************************************/
	
	public int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        int left = 0, right = A.length-1;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(A[mid] == target){
                return mid;
            }
            // mid在左半部分
            else if(A[mid] > A[left] || A[mid] > A[right]){
                if(target < A[mid] && target >= A[left]){   // 注意有等号，>=
                    right = mid;
                }
                else{
                    left = mid;
                }
            }
            // mid在右半部分
            else if(A[mid] < A[right] || A[mid] < A[left]){
                if(target > A[mid] && target <= A[right]){  // 注意有等号，<=
                    left = mid;
                }
                else{
                    right = mid;
                }
            }
            // 去除重复
            else{
                right--;
            }
        }
        
        // 从左往右检查，先从left开始到right
        if(A[left] == target){ 
            return left;
        }
        if(A[right] == target){
            return right;
        }
        return -1;
    }
}
