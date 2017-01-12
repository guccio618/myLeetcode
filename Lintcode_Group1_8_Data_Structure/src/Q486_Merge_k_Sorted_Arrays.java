import java.util.ArrayList;
import java.util.List;


public class Q486_Merge_k_Sorted_Arrays {
	// by Jackie using Divide and Conquer
	public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0){
            return res;
        }
        
        int len = arrays.length;
        int[] a = mergekSortedArrays(arrays, 0, len-1);
        for(int i = 0; i < a.length; ++i){
            res.add(a[i]);
        }
        return res;
    }
    
    
    public int[] mergekSortedArrays(int[][] arrays, int start, int end){
        if(start == end){
            return arrays[start];
        }
        int mid = (start + end) / 2;
        int[] array1 = mergekSortedArrays(arrays, start, mid);
        int[] array2 = mergekSortedArrays(arrays, mid+1, end);
        int len = array1.length + array2.length;
        int[] array3 = new int[len];
        
        int i = 0, j = 0;
        for(int k = 0; k < len; ++k){
            if(i < array1.length && j >= array2.length){
                array3[k] = array1[i++];
            } else if(i >= array1.length && j < array2.length){
                array3[k] = array2[j++];
            } else{
                if(array1[i] > array2[j]){
                    array3[k] = array2[j++];
                } else{
                    array3[k] = array1[i++];
                }
            }
        }
        return array3;
    }
    
    
    
    public static void main(String[] args){
    	Q486_Merge_k_Sorted_Arrays t = new Q486_Merge_k_Sorted_Arrays();
    	int[][] arrays = { {1, 3, 5, 7},
    						{2, 4, 6},
    						{0, 8, 9, 10, 11}
    					 };
    	List<Integer> res = t.mergekSortedArrays(arrays);
    	for(int i = 0; i < res.size(); ++i){
    		System.out.print(res.get(i) + ", ");
    	}
    	System.out.println();
    }
}
