
public class Lecture2_Binary_Search_10_Find_Minimum_in_Rotated_Sorted_Array_II {
	/*************************************************************************************
	 * Binary Search
	 * 		分类讨论
	 * 		(1). 先判断mid的情况，mid是在左半部分或右半部分
	 * 		(2). 然后判断对应情况下，target的情况，target是否落在[start, mid]或者[mid, end]区间内
	 * 		(3). 期间需要用一个minValue变量来记录出现过的最小值
	 * 		
	 *************************************************************************************/
	
	public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        int minVal = Integer.MAX_VALUE;
        int left = 0, right = num.length-1;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            minVal = Math.min(minVal, num[left]);
            minVal = Math.min(minVal, num[right]);
            minVal = Math.min(minVal, num[mid]);
            if(num[mid] > num[left] || num[mid] > num[right]){        // 若mid出现在左边，此时最小值应该在右边，因此left右移
                left = mid;
            }
            else if(num[mid] < num[right] || num[mid] < num[left]){   // 若mid出现在右边，此时最小值应该在左边，因此right左移
                right = mid;
            }
            else{                                                     // 去除重复
                right--;
            }
        }
        return Math.min(minVal, Math.min(num[left], num[right]));
    }
}
