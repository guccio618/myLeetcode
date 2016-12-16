import java.util.*;


/******
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

 * 
 * 
 * */

public class Q454_4Sum_II {
	// Solution 1: time O(n^3), space O(n)
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || A.length == 0 || B == null  || B.length == 0 || C == null || C.length == 0 || D == null || D.length == 0) {
            return 0;
        }
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for(int num : D) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
          
        for(int num1 : A) {
            for(int num2 : B) {
                for(int num3: C) {
                    int sum = num1 + num2 + num3;
                    
                    if(map.containsKey(-sum)) {
                    	count += map.get(-sum);
                    }
                }
            }
        }
        
        return count;
    }
	
	// Solution 2: time O(n^2), O(n^2)
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || A.length == 0 || B == null  || B.length == 0 || C == null || C.length == 0 || D == null || D.length == 0) {
            return 0;
        }
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for(int num1 : A) {
            for(int num2 : B) {
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
          
        for(int num1 : C) {
            for(int num2 : D) {
                int sum = num1 + num2;
                    
                if(map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }
        
        return count;
    }
	
	
	
	
	
	public static void main(String[] args) {
		Q454_4Sum_II t = new Q454_4Sum_II();
		int[] A = {0,1,-1};
		int[] B = {-1,1,0};
		int[] C = {0,0,1};
		int[] D = {-1,1,1};
		
		System.out.println(t.fourSumCount(A, B, C, D));
	}
}
