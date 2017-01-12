
public class Q062_Search_in_Rotated_Sorted_Array {
	/*************
	 * Star
	 *************/
	
	// by Jackie
	public int search(int[] num, int target) {
		if(num == null || num.length == 0){
            return 0;
        }
        int minVal = Integer.MAX_VALUE;
        int left = 0, right = num.length-1;
        while(left + 1 < right){
        	int mid = left + (right - left) / 2; 
            minVal = Math.min(minVal, num[left]);
            minVal = Math.min(minVal, num[right]);
            minVal = Math.min(minVal, num[mid]);
            if(num[mid] > num[left] || num[mid] > num[right]){        // 若mid出现在左边，此时最小值应该在右边，因此left右移
                left = mid;
            }
            else if(num[mid] < num[right] || num[mid] < num[left]){   // 若mid出现在右边，此时最小值应该在左边，因此right左移
                right = mid;
            }
            else{                                                     // 去除重复，往左靠
                right--;
            }
        }
        return Math.min(minVal, Math.min(num[left], num[right]));
    }
}
