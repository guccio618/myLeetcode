/**************************************************************************
 * (1). 此题只需要纪录起始index和结尾的index， 
 * (3). 每次update，在startIndex处加上inc, 在endIndex+1 处加上 inc表示还原。
 * (2). 对求得的数组累加求和，结果即为所求。
 * 
 **************************************************************************/


public class Q370_Range_Addition {
	// by other, time complexity O(k + n), space O(1)
	public int[] getModifiedArray(int length, int[][] updates) {
        if(updates == null || updates.length == 0 || updates[0].length == 0){
            return new int[length];
        }
        
        int[] ans = new int[length];
        
        for(int[] update : updates){
            int startIndex = update[0];
            int endIndex = update[1];
            int inc = update[2];
            
            ans[startIndex] += inc;
            if(endIndex + 1 < length){
                ans[endIndex + 1] -= inc;
            } 
        }
        
        for(int i = 1; i < length; i++){
            ans[i] = ans[i - 1] + ans[i];
        }
        
        return ans;
    }
}
