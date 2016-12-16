import java.util.ArrayList;
import java.util.List;


public class Q228_Summary_Ranges {
	public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return ans;
        }
        
        int start = nums[0];
        int numNeed = start + 1;
        int len = nums.length;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] == numNeed) {
                numNeed++;
            } else {
                ans.add(getStr(start, numNeed - 1));
                start = nums[i];
                numNeed = start + 1;
            }
        }

        ans.add(getStr(start, numNeed - 1));
        return ans;
    }
    
    public String getStr(int start, int end) {
        StringBuilder builder = new StringBuilder();
        
        if (start == end) {
            builder.append(start);
        } else {
            builder.append(start).append("->").append(end);
        }
        
        return builder.toString();
    }
	
	
	
	// by Jackie
	public List<String> summaryRanges2(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        int len = nums.length;
        int index = 0;
        int start = 0, end = 0;
        
        while(index < len){
            start = nums[index];
            
            while(index + 1 < len && nums[index] + 1 == nums[index + 1]){
                index++;
            }
            
            end = nums[index];
            ans.add(getStr2(start, end));
            index++;
        }
        
        return ans;
    }
    
    public String getStr2(int num1, int num2){
        if(num1 == num2){
            return Integer.toString(num1);
        } else {
            String str = Integer.toString(num1) + "->" + Integer.toString(num2);
            return str;
        }
    }
	
    
    
	//by jackie
	public ArrayList<String> summaryRanges3(int[] nums) {
		ArrayList<String> res = new ArrayList<String>();
        int n = nums.length;
        int front = 0, back = 0;
        for(int i = 0; i < n; i++){
            if(i < n-1 && nums[i+1] - nums[i] == 1){  //注意当处理数组最后一个元素时，
                front = i;                            //如果连续，则在此步内就会停止
                while(i < n-1 && nums[i+1] - nums[i] == 1)
                    i++;
                back = i;                             
                res.add(Integer.toString(nums[front]) + "->" + Integer.toString(nums[back]));
            }
            else{
            	res.add(Integer.toString(nums[i]));
            }
        }
        return res;
    }

	
	public static void main(String[] args){
		Q228_Summary_Ranges test = new Q228_Summary_Ranges();
		int[] array = {-2147483648,-2147483647,2147483647};
		 List<String> list = test.summaryRanges(array);
		 for(int i = 0; i < list.size(); i++)
			 System.out.print(list.get(i) + ", ");
		 System.out.println();
	}
}
