
public class Q159_Find_Minimum_in_Rotated_Sorted_Array {
	// by Jackie
	// 分类
	public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        
        int left = 0, right = num.length - 1;
        int minValue = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left + right) / 2;
            minValue = Math.min(minValue, num[left]);  // 注意 
            minValue = Math.min(minValue, num[right]); // 注意
            minValue = Math.min(minValue, num[mid]);   // 注意
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
        return minValue;
    }
}
