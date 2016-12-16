import java.util.*;

/*****
 * 
Given two arrays, write a function to compute their intersection.

Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
	Each element in the result must be unique.
	The result can be in any order.
 * 
 * */

public class Q349_Intersection_of_Two_Arrays {
	// solution 1: using one set, time O(nlogn), space O(n)
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Set<Integer> set = new HashSet();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        
        while(index1 < len1 && index2 < len2) {
            if(nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
                index1++;
                index2++;
            } else if(nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        
        int[] ans = new int[set.size()];
        int index = 0;
        
        for(int num : set) {
            ans[index++] = num;           
        }
        
        return ans;
    }
	
	
	
	// solution 2: using two sets, time O(n), space O(n)
	public int[] intersection2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        for(int n : nums1){
            set1.add(n);
        }
        
        for(int n : nums2){
            if(set1.contains(n)){
                set2.add(n);
            }
        }
        
        int[] ans = new int[set2.size()];
        int index = 0;
        
        for(int n : set2){
            ans[index++] = n;
        }
        
        return ans;
    }
}
