
public class Q465_Kth_Smallest_Sum_In_Two_Sorted_Arrays {
	public int kthSmallestSum(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || k <= 0 || nums1.length * nums2.length < k){
           return 0;
        }
        int num = 0;
        int i = 1;
        while(i < nums1.length){
        	
           num = search(nums2, nums1[i]);
           System.out.println("i = " + i + ", num = " + num);
//           System.out.println("num = " + num);
           if(k - num - 1 == 0){
               return (nums1[i - 1] + nums2[num]);
           } else if(k - num - 1 < 0){
                break;
           } else {
               k -= (num + 1);
               i++;
           }
        }
        
        if(i == nums1.length){
        	k -= nums2.length;
        }
        System.out.println("i - 1 = " + (i - 1) + ", k - 1 = " + (k - 1));
        return nums1[i - 1] + nums2[k - 1];
    }
    
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target <= nums[mid]){
                right = mid;
            } else {
                left = mid;
            }
        }
        
//        System.out.println("left = " + left + ", right = " + right);
        
        if(nums[left] > target){
            return left - 1;
        } else if(nums[right] == target){
        	return left;
        } else if(nums[right] > target){
            return left;
        } else if(nums[right] <= target){
            return right;
        } else {
        	return right;
        }
    }
    
    
    
    public static void main(String[] args){
    	Q465_Kth_Smallest_Sum_In_Two_Sorted_Arrays t = new Q465_Kth_Smallest_Sum_In_Two_Sorted_Arrays();
    	int[] nums1 = {1,2,3,4};
    	int[] nums2 = {1,2,3,4};
    	System.out.println(t.kthSmallestSum(nums1, nums2, 15));
//    	System.out.println(t.kthSmallestSum(nums1, nums2, 4));
//    	System.out.println(t.kthSmallestSum(nums1, nums2, 8));
    }
}
