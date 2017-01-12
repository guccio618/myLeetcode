import java.util.Arrays;
import java.util.Comparator;


public class Q139_Subarray_Sum_Closest {
	/******************************************
	 * Star 可以推广到最接近target的所有解的题目上
	 * 
	 ******************************************/
	// by ninechapter, 自定义数据的使用，nice! O(nlogn)
	
	public int[] subarraySumClosest(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            return new int[]{0, 0};
        }
        
        int[] res = new int[2];
        int len = nums.length;
        Pair[] sum = new Pair[len + 1];
        sum[0] = new Pair(0, 0);
        
        for(int i = 1; i <= len; ++i){
            sum[i] = new Pair(sum[i-1].sum + nums[i-1], i);
        }
        
        Arrays.sort(sum, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= len; ++i){
            if(min > sum[i].sum - sum[i-1].sum){   // 任意两段和的差最小的一个
                min = sum[i].sum - sum[i-1].sum;
                res[0] = (sum[i].index > sum[i-1].index) ? sum[i-1].index : sum[i].index;
                res[1] = (sum[i].index > sum[i-1].index) ? sum[i].index - 1: sum[i-1].index - 1;
            }
        }
        return res;   
    }
    
    private class Pair{
        public int sum;
        public int index;
        
        public Pair(int s, int i){
            sum = s;
            index = i;
        }
    }
    
    
    // by Jackie using DP, but time limit exceeded
    public int[] subarraySumClosest2(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            return new int[]{0 ,0};
        }
        
        int[] res = new int[2];
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sum = new int[len];
        sum[0] = nums[0];
        res[0] = res[1] = 0;
        
        for(int i = 1; i < len; ++i){
        	sum[i] = sum[i-1] + nums[i];
        	if(min > Math.abs(nums[i])){
         	   min = Math.abs(nums[i]);
         	   res[0] = res[1] = i;
            } 
        }  
        
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){            	
               if(min > Math.abs(sum[i]-sum[j]+nums[j])){
            	   min = Math.abs(sum[i]-sum[j]+nums[j]);
            	   res[0] = j;
            	   res[1] = i;
               } 
            }
        }
        return res;
    }
    
    
    public static void main(String[] args){
    	Q139_Subarray_Sum_Closest t = new Q139_Subarray_Sum_Closest();
    	int[] nums = {-10,-2,-3,-100,4,10,20,30};
    	int[] res = t.subarraySumClosest(nums);
    	int[] res2 = t.subarraySumClosest2(nums);
    	System.out.println(res[0] + ", " + res[1]);
    	System.out.println(res2[0] + ", " + res2[1]);
    }
}
