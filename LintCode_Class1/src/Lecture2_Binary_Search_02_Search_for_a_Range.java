
public class Lecture2_Binary_Search_02_Search_for_a_Range {
	/******************************************************************************
	 * Binary Search
	 * 		follow up: What if return a double, not integer?
	 * 		循环条件改为：while( (end - start) > 1e-6 ), 即10的-6次方，也可以是-7,-8次方
	 * 		
	 ******************************************************************************/
	
	public int[] searchRange(int[] A, int target) {
        if (A.length == 0) {
            return new int[]{-1, -1};
        }
        
        int start, end, mid;
        int[] bound = new int[2]; 
        
        // search for left bound
        start = 0; 
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;          // 寻找左边边界，有可能此时左边还有target，end左移
            } 
            else if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;      
            }
        }
        
        if (A[start] == target) {
            bound[0] = start;
        } 
        else if (A[end] == target) {
            bound[0] = end;
        }
        else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;       // 寻找右边边界，有可能此时右边还有target，start右移
            } 
            else if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;     
            }
        }
        
        if (A[end] == target) {
            bound[1] = end;
        }
        else if (A[start] == target) {
            bound[1] = start;
        }
        else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        
        return bound;
    }
	
	
	
	/************************************** main function **************************************/
	public static void main(String[] args){
		Lecture2_Binary_Search_02_Search_for_a_Range t = new Lecture2_Binary_Search_02_Search_for_a_Range();
		int[] nums = {1,2,2,3,3,3,3,3,3,3,4,5,6,7,8,9,9};
		int[] res = t.searchRange(nums, 3);
		System.out.println(res[0] + ", " + res[1]);
	}
}
