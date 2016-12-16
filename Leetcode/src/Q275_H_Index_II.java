
public class Q275_H_Index_II {
	/************************************************/
	// by other, O(logn)
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }

        int len = citations.length;
        int left = 0, right = len - 1;
        int ans = 0;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(citations[mid] < len - mid){
                left = mid + 1;
            } else {
                ans = len - mid;
                right = mid - 1;
            }
        }
        
        return ans;
    }
	
	
	
	/************************************************/
	// by other, O(n)
	public int hIndex2(int[] citations) {
        int n = citations.length;
        int ans = 0;
        
        for(int i = n - 1; i >= 0 && citations[i] >= n - i; --i){
            ans = n - i;
        }
        
        return ans;
    }
}
