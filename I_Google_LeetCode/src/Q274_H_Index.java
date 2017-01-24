import java.util.Arrays;
/******
 * 
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

 * 
 * */

public class Q274_H_Index {
	// solution 1: using sort + binary serach, time is O(nlogn + logn), space is O(1)
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int len = citations.length;
        int left = 0, right = citations.length - 1;
        int ans = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                ans = len - mid;
                right = mid - 1;
            }
        }
        
        return ans;
    }
		
	
	
	// solution 2: using bucket sort, time is O(n), space is O(n)
	public int hIndex2(int[] citations) {
		int n = citations.length;
	    int[] buckets = new int[n + 1];
	    for(int c : citations) {
	        if(c >= n) {
	            buckets[n]++;        // bucket存放的是被引用n次的文章有多少篇
	        } else {
	            buckets[c]++;
	        }
	    }
	    
	    int count = 0;
	    for(int i = n; i >= 0; i--) { // i means the number of articles which have been cited for i time
	        count += buckets[i];      // 注意这里用的是bucket而不是citation
	        if(count >= i) {
	            return i;
	        }
	    }
	    return 0;
    }
	
	
	
	
	
	
	
	
	
	
	
	/***********************************************************/
	
	public static void main(String[] args){
		Q274_H_Index t = new Q274_H_Index();
		int[] citations = {3, 0, 6, 1, 5}; // test case: {0}, {100}
		int[] citations2 = {6,7,3,6,6};
		System.out.println(t.hIndex(citations2));
	}
}
