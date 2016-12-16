
public class Le_275_H_Index_II {
	// by other
	public int hIndex(int[] citations) {
        int n = citations.length;
        int ans = 0;
        
        for(int i = n - 1; i >= 0 && citations[i] >= n - i; --i){
            ans = n - i;
        }
        
        return ans;
    }
}
