import java.util.Arrays;


public class Le_274_H_Index {
	// by other using sort
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        Arrays.sort(citations);
        int n = citations.length;
        int i = 0;
        
        while(i < n && citations[n - i - 1] > i){   // 注意这里是 n - i - 1
            i++;
        }
        
        return i;
    }
	
	
	
	// by other using bucket sort
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
	    for(int i = n; i >= 0; i--) {  // i means the number of articles which have been cited for i time
	        count += buckets[i];       // 注意这里用的是bucket而不是citation
	        if(count >= i) {
	            return i;
	        }
	    }
	    return 0;
    }
	
	
	public static void main(String[] args){
		Le_274_H_Index t = new Le_274_H_Index();
		int[] citations = {3, 0, 6, 1, 5}; // test case: {0}, {100}
		int[] citations2 = {6,7,3,6,6};
		System.out.println(t.hIndex(citations2));
	}
}
