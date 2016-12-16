import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*******************************************
(1). Comparator                
/*******************************************/

public class Q179_Largest_Number {    // 注意test case： 0，0，0，0
	// by Ninechapter
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new String();
		}

		String[] strs = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			strs[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
		}

		String result = sb.toString();
		int index = 0;

		while (index < result.length() - 1 && result.charAt(index) == '0') {
			index++;
		}

		return result.substring(index);
    }
	    
	
	
	/**************************************************************/
    // by Jackie using priorityqueue
	public String largestNumber2(int[] nums) {
        if(nums == null || nums.length == 0){
            return new String();
        }
        
        Queue<String> heap = new PriorityQueue<String>(1, new Comparator<String>(){
            public int compare(String left, String right){
                String str1 = left + right;
                String str2 = right + left;
                return str2.compareTo(str1);
            }
        });
        
        StringBuilder builder= new StringBuilder();
        boolean zeroFlag = true;
        
        for(int num : nums){
            if(num != 0){
                zeroFlag = false;
            }
            heap.offer(Integer.toString(num));
        }
        
        if(zeroFlag == true){  // 需要作是否全是0的判断 ！！！
            return "0";
        }
        
        while(!heap.isEmpty()){
            builder.append(heap.poll());
        }

        return builder.toString();
    }
	
	
	
	public static void main(String[] args){
		Q179_Largest_Number l = new Q179_Largest_Number();
		int[] nums = {0, 0, 0};
//		int[] nums = {999999998,999999997,999999999};
		System.out.println(l.largestNumber(nums));
		System.out.println(l.largestNumber2(nums));
	}
}
