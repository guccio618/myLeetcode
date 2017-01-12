
public class Q183_Wood_Cut {
	/*************
	 * Star
	 *************/
	
	// by ninechapter
	public int woodCut(int[] L, int k) {
        if(L == null || L.length == 0){
            return 0;
        }
        int len = L.length;
        int maxLen = 0;
        for(int i = 0; i < len; ++i){
            maxLen = Math.max(maxLen, L[i]);
        }
        int left = 1, right = maxLen;
        while(left + 1 < right){
        	int mid = left + (right - left) / 2;  // 这么写不会越界，mid = (left + right) / 2会越界
            if(countHelper(L, mid) >= k){         // 当有duplicate时，选大的，因此尽量往右靠
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(countHelper(L, right) >= k){
            return right;
        }
        if(countHelper(L, left) >= k){
            return left;
        }
        return 0;
    }
    
    public int countHelper(int[] L, int len){
        int sum = 0;
        for(int i = 0; i < L.length; ++i){
            sum += L[i] / len;
        }
        return sum;
    }
    
    
    public static void main(String[] args){
    	Q183_Wood_Cut t = new Q183_Wood_Cut();
    	int[] L = {2147483644,2147483645,2147483646,2147483647};
    	System.out.println(t.woodCut(L, 4));
    }
}
