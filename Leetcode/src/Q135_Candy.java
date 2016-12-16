import java.util.Arrays;


public class Q135_Candy {
	/******************************************************/
	// by other
	public int candy(int[] ratings) {
	    int candies[] = new int[ratings.length];        
	    Arrays.fill(candies, 1);        // Give each child 1 candy
	    
	 // Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
	    for (int i = 1; i < candies.length; i++){
	        if (ratings[i] > ratings[i - 1]) 
	        	candies[i] = (candies[i - 1] + 1);
	    }
	    
	 // Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
	    for (int i = candies.length - 2; i >= 0; i--) {
	        if (ratings[i] > ratings[i + 1]) 
	        	candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
	    }
	    
	    int sum = 0;        
	    for (int candy : candies)  
	        sum += candy;        
	    return sum;
	}
	
	
	/******************************************************/
	// by Jackie but a little bit slow
	public int candy2(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int len = ratings.length;
        int[] index = new int[len];
        int[] x = new int[len];
        int[] candyNum = new int[len];
        for(int i = 0; i < len; ++i){
            index[i] = i;
            x[i] = ratings[i];
            candyNum[i] = 1;
        }
        Quicksort(x, 0, len - 1, index);
        int count = 0;
        int pos = 0;
        for(int i = 0; i < len; ++i){
            pos = index[i];
            if(pos > 0 && ratings[pos] > ratings[pos-1]){
                candyNum[pos] = (candyNum[pos] > candyNum[pos-1]) ? candyNum[pos] : candyNum[pos-1] + 1;
            }
            if(pos+1 < len && ratings[pos] > ratings[pos+1]){
                candyNum[pos] = (candyNum[pos] > candyNum[pos+1]) ? candyNum[pos] : candyNum[pos+1] + 1;
            }
            count += candyNum[pos];
        }
        return count;
    }

    
    public void Quicksort(int[] x, int left, int right, int[] index){   // 时间最理想O(n*logn)，最差O(n^2)，
		if(left >= right) return;                          // 空间O(logn)，不稳定
		int i = left, j = right;
		double pivot = (x[left]+x[right])/2.0;  // pivot必须用double
		while(i < j){
			while(i < right && x[i] < pivot) i++;  // 右边界的判定
			while(j > left && x[j] >= pivot) j--;  // 左边界的判定
			if(i < j){
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
				int t = index[i];
				index[i] = index[j];
				index[j] = t;
			}
		}
		if(j > left)                         // 分割
			Quicksort(x, left, j, index);
		if(right > j+1)
			Quicksort(x, j+1, right, index);		
	}
}
