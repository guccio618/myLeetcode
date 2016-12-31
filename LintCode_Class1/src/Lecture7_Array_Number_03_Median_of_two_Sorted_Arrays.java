
public class Lecture7_Array_Number_03_Median_of_two_Sorted_Arrays {
	/************************************************************
	 * Quick Select: 可以在无序数组里寻找第K大的数，O(n);
	 * 
	 ************************************************************/
	
	public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (
            findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
        ) / 2.0;
    }

    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k){		
		if (A_start >= A.length) {  // A数组到达末尾
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}

		if (k == 1) {               // 必须放置这里，放置有空数组的情况
			return Math.min(A[A_start], B[B_start]);
		}
		// 扔掉值低的array部分，因此，当长度不够时，使用integer.max_value表示
		int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;  
		int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
    
    
    
    /************************************************************************
	 * Merge two arrays and find the median, O(n1 + n2), space O(n1 + n2)
	 * 
	 ************************************************************************/
    
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // write your code here
        if( (nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0) ){
            return 0;
        }
        if(nums1 == null || nums1.length == 0){
            if(nums2.length == 1){
                return nums2[0];
            }
            else if(nums2.length % 2 == 0){
                return (nums2[nums2.length/2] + nums2[nums2.length/2-1]) / 2.0;
            }
            else{
                return nums2[nums2.length/2];
            }
        }
        if(nums2 == null || nums2.length == 0){
            if(nums1.length == 1){
                return nums1[0];
            }
            else if(nums1.length % 2 == 0){
                return (nums1[nums1.length/2] + nums1[nums1.length/2-1]) / 2.0;
            }
            else{
                return nums1[nums1.length/2];
            }
        }
        
        int len1 = nums1.length, len2 = nums2.length;
        double[] mergeNums = new double[len1 + len2];
        int len3 = len1 + len2;
        int x = 0, y = 0;
        for(int k = 0; k < len3; ++k){
            if(x < len1 && y >= len2){
                mergeNums[k] = nums1[x++];
            }
            else if(y < len2 && x >= len1){
                mergeNums[k] = nums2[y++];
            }
            else{
                if(nums1[x] < nums2[y]){
                    mergeNums[k] = nums1[x++];
                }
                else{
                    mergeNums[k] = nums2[y++];
                }
            }
        }
        
        if(len3 % 2 == 0){
            return (mergeNums[len3/2] + mergeNums[len3/2-1]) / 2.0;
        }
        else{
            return mergeNums[len3/2];
        }
    }
}
