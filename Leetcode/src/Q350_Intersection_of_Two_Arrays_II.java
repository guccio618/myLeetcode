import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Q350_Intersection_of_Two_Arrays_II {
	// solution 1: using two pointers, time O(nlogn), space O(n)
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        List<Integer> list = new LinkedList();
        
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] < nums2[index2]){
                index1++;
            } else if(nums1[index1] > nums2[index2]){
                index2++;
            } else {
                list.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        
        for(int num : list){
            ans[index++] = num;
        }
        
        return ans;
    }
	
	
	
	// solution 2: using two map, time O(n), space O(n)
	public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap();
        
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> list = new LinkedList();
        
        for(int num : nums2) {
            if(map.containsKey(num)) {
                list.add(num);
                int count = map.get(num);
                
                if(count == 1) {
                    map.remove(num);    
                } else {
                    map.put(num, count - 1);
                }
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        
        for(int num : list) {
            ans[index++] = num;           
        }
        
        return ans;
    }
}
