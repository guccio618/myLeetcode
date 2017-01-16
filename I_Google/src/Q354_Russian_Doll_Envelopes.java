import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/******
 * 
You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another if and only if both the width and height of one envelope
is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can 
Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 * 
 * 
 * */

public class Q354_Russian_Doll_Envelopes {
	/***************************************************************************************
	 * 需要注意的是Binary Search： 
	 * 		(1). 使用Arrays.binarySearch和使用List手动实现两种方式
	 * 		(2). Arrays.binarySearch时，注意len == index, 表示插入点大于当前list长度，因此len++
	 * 		(3). Arrays.sort时候需要注意，left[0] == right[0]时，return right[1] - left[1]， 
	 * 		顺序如下：[5, 6], [5, 5]这样才能保证结果正确
	 * 
	 ***************************************************************************************/
	
	// test case: [4, 5], [4, 6] ->  [4, 6], [4, 5]
	// solution 1: using DP, time O(n^2), space O(n)
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        } else if(envelopes.length == 1) {
            return 1;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {   // 这里的顺序是 先 array1[0] - array2[0] 再 array2[1] - array1[1] ！！！
                return array1[0] != array2[0] ? array1[0] - array2[0] : array2[1] - array1[1];
            }
        });
        
        int len = envelopes.length;
        int[] dp = new int[len];
        int maxLen = 1;
        
        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            
            for(int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
	
	
	
	// solution 2: using binarySearch, time O(nlogn), space O(n)
	public int maxEnvelopes2(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        } else if(envelopes.length == 1) {
            return 1;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] array1, int[] array2) {     // 这里的顺序是 先 array1[0] - array2[0] 再 array2[1] - array1[1] ！！！
                return array1[0] != array2[0] ? array1[0] - array2[0] : array2[1] - array1[1];
            }
        });
        
        int len = envelopes.length;
        int[] dp = new int[len];
        int maxLen = 0;
        
        for(int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, maxLen, envelope[1]);
            index = (index < 0) ? -(index + 1) : index;
            dp[index] = envelope[1];
            
            if(index == maxLen) {       // index == dpLen时，dpLen++ ！！！
                maxLen++;
            }
        }
        
        return maxLen;
    }
    

	
	// solution 3: using Binary Search, time complexity is O(nlogn)
    public int maxEnvelopes3(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] left, int[] right){
                if(left[0] != right[0]){
                    return left[0] - right[0];
                } else {
                    return right[1] - left[1];
                }
            }
        });
    
        List<Integer> list = new ArrayList<Integer>();
        
        for(int[] envelope : envelopes){
            updateList(list, envelope[1]);
        }
        
        return list.size();
    }
    
    public void updateList(List<Integer> list, int target){
        if(list.size() == 0 || target > list.get(list.size() - 1)){
            list.add(target);
        }
        
        int pos = findPos(list, target);
        list.set(pos, target);
    }
    
    public int findPos(List<Integer> list, int target){
        if(target < list.get(0)){
            return 0;
        }
        
        int left = 0, right = list.size() - 1;
        
        while(left + 1 < right){
            int midIndex = left + (right - left) / 2;
            int mid = list.get(midIndex);
            
            if(mid < target){
                left = midIndex;
            } else {
                right = midIndex;
            }
        }
        
        if(list.get(left) >= target){
            return left;
        } else if(list.get(right) >= target){
            return right;
        } else {
            return right + 1;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    /**********************************************************************************************************/
	// by Jackie using DP, time complexity is O(n^2)
    public int maxEnvelopes4(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        
        int len = envelopes.length;
        int[] dp = new int[len];
        int maxLen = 1;
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] left, int[] right){
                if(left[0] != right[0]){
                    return left[0] - right[0];
                } else {
                    return left[1] - right[1];
                }
            }
        });
        
        for(int i = 0; i < len; i++){
            dp[i] = 1;
        }
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        
        return maxLen;
    }

    
        
    public static void main(String[] args){
    	Q354_Russian_Doll_Envelopes t = new Q354_Russian_Doll_Envelopes();
    	int[][] envelopes = {
//    			{5,4}, {6,4}, {6,7}, {2,3}
    			{4,5}, {4,6} //, {6,7}, {2,3}, {1,1}
    	};
    	
    	System.out.println(t.maxEnvelopes(envelopes));
    }
}
