
public class Le_004_Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return -1;
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n = len1 + len2;
        if(n % 2 == 1){
            return (double) findKthElement(nums1, 0, nums2, 0, n / 2 + 1);
        } else {
            return (findKthElement(nums1, 0, nums2, 0, n / 2) + findKthElement(nums1, 0, nums2, 0, n / 2 + 1)) / 2.0;
        }
    }
    
    public int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 >= nums1.length){
            return nums2[start2 + k - 1];
        } else if(start2 >= nums2.length){
            return nums1[start1 + k - 1];
        } else if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int element1 = (start1 + k/2 - 1 < nums1.length) ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int element2 = (start2 + k/2 - 1 < nums2.length) ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        
        if(element1 < element2){
            return findKthElement(nums1, start1 + k/2, nums2, start2, k - k/2);
        } else {
            return findKthElement(nums1, start1, nums2, start2 + k/2, k - k/2);
        }
    }
}
