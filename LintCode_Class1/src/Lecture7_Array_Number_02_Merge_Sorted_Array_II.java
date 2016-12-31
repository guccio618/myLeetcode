import java.util.ArrayList;
import java.util.Collections;


public class Lecture7_Array_Number_02_Merge_Sorted_Array_II {
	/************************************************************
	 * Normal way:
	 * 		mergeSort
	 * 
	 ************************************************************/
	
	public int[] mergeSortedArray(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return nums2;
        }
        if(nums2 == null || nums2.length == 0){
            return nums1;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 + len2;
        int[] res = new int[len3];
        int i = 0, j = 0;
        
        for(int k = 0; k < len3; ++k){
            if(i < len1 && j == len2){
                res[k] = nums1[i++];
            } else if(i == len1 && j < len2){
                res[k] = nums2[j++];
            } else{
                if(nums1[i] < nums2[j]){
                    res[k] = nums1[i++];
                } else{
                    res[k] = nums2[j++];
                }
            }
        }
        return res;
    }
	
	
	
	/************************************************************
	 * Collection.sort
	 * 
	 ************************************************************/
	
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = B.size();
        for (int i = 0; i < len; ++i) 
            A.add(B.get(i));
        Collections.sort(A);
        return A;
    }
}
