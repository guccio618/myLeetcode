import java.util.Arrays;
import java.util.Comparator;


public class Le_179_Largest_Number {
	public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return new String();
        }
        
        int n = nums.length;
        String[] arrays = new String[n];
        StringBuffer builder = new StringBuffer();
        
        for(int i = 0; i < n; i++){
            arrays[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(arrays, new Comparator<String>(){
            public int compare(String left, String right){  // compare 非常巧！！！
                String compare1 = left + right;
                String compare2 = right + left;
                return compare2.compareTo(compare1);
            }
        });
        
        for(int i = 0; i < n; i++){
            builder.append(arrays[i]);
        }
        
        String ans = builder.toString();
        int index = 0;
        
        while(index < ans.length() - 1 && ans.charAt(index) == '0'){
            index++;
        }
        
        return ans.substring(index);
    }
	
	
	
	public static void main(String[] args){
		String str1 = "3273";  // compareTo 返回符号表示哪一边的字符串小，返回值表示第一个不同的字符之间的差值
		String str2 = "327";
		System.out.println(str1.compareTo(str2));
	}
}
