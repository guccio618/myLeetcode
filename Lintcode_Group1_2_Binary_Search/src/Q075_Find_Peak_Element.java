
public class Q075_Find_Peak_Element {
	/**************************************************************
	 * 	Star
	 * 	将mid分成4种情况：
	 * 		(1). mid在上升区间， 此时由于尾部必有下降区间，因此去除左边的部分
	 * 		(2). mid在下降区间， 此时由于头部必有上升区间，因此去除右边的部分
	 * 		(3). mid在波峰， 返回
	 * 		(4). mid在波谷， 去除左边或右边都可以
	 **************************************************************/
	
	// by ninichapter
	public int findPeak(int[] A) {
        int start = 1, end = A.length - 2;  // 1.答案在之间，2.不会出界 
        while(start + 1 <  end) {
        	int mid = start + (end - start) / 2; 
            if(A[mid] < A[mid - 1]) {       // 下降阶段，因此去除mid右边部分
                end = mid;
            } 
            else if(A[mid] < A[mid + 1]) {  // 上升阶段，因此去除mid左边部分
                start = mid;
            } 
            else {
                end = mid;                  // 波峰或波谷
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else { 
            return start;
        }
    }
	
	
	// by other
	public int findPeak2(int[] nums) {
        // write your code here
        int N = nums.length;
        if (N == 1) {
            return 0;
        }

        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
