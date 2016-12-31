
public class Lecture2_Binary_Search_01_Sqrt_x {
	/********************************************************************************************************
	 * Binary Search
	 * 		总结：
	 * 		(1). 适用于sorted array;
	 * 		(2). while判定条件选 left + 1 < right, 防止死循环;
	 * 		(3). mid = left + (right - left) / 2, 防止溢出；
	 * 		(4). 判断之后，选择left = mid 或 right = mid;
	 * 		(5). 当 nums[mid] ＝ target时(可能array里含多个和target相等的数)，如果找左边界，则需要往左移，则 right = mid;
	 * 			 如果找右边界，则需要往右移，则 left = mid;
	 * 		(6). 退出while后，进行后续处理，此时 left + 1 = right, 一般从左往右先判断left，再判断right，是否符合要求;
	 * 		
	 ********************************************************************************************************/
	
	public int sqrt(int x) {
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;   // 防止int溢出
            if (mid * mid < x) {
                start = mid;
            } 
            else if(mid * mid > x){
                end = mid;
            }
            else{
                return (int) mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}
