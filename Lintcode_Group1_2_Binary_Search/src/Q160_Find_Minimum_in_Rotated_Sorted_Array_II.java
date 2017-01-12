
public class Q160_Find_Minimum_in_Rotated_Sorted_Array_II {
	// by Jackie
	public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        int minVal = Integer.MAX_VALUE;
        int left = 0, right = num.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            minVal = Math.min(minVal, num[left]);
            minVal = Math.min(minVal, num[right]);
            minVal = Math.min(minVal, num[mid]);
            if(num[mid] > num[left] || num[mid] > num[right]){
                left = mid + 1;
            }
            else if(num[mid] < num[right] || num[mid] < num[left]){
                right = mid - 1;
            }
            else{
                right--;
            }
        }
        return minVal;
    }
}
