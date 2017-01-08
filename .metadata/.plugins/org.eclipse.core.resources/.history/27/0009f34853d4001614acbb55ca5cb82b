import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Q401_Binary_Watch {
	public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        
        if(num < 0 || num > 10) {
            return ans;
        }
        
        int[] lights = new int[10];
        
        backtrack(ans, lights, 0, num, 0);
        return ans;
    }
    
    public void backtrack(List<String> ans, int[] lights, int currentNum, int num, int start) {
        if(currentNum == num) {
            int base = 1;
            int part1 = 0;
            
            for(int i = 3; i >= 0; i--) {
                if(lights[i] == 1) {
                    part1 += base;
                }
                base *= 2;
            }
            
            if(part1 >= 12) {
                return;
            }
            
            base = 1;
            int part2 = 0;
            
            for(int i = 9; i >= 4; i--) {
                if(lights[i] == 1) {
                    part2 += base;
                }
                base *= 2;
            }
            
            if(part2 >= 60) {
                return;
            }
            
            String str2 = Integer.toString(part2);
            str2 = str2.length() == 1 ? "0" + str2 : str2;
            ans.add(Integer.toString(part1) + ":" + str2);
            return;
        } else if (start == lights.length) {
            return;
        }
        
        for(int i = start; i < lights.length; i++) {
            lights[i] = 1;
            backtrack(ans, lights, currentNum + 1, num, i + 1);
            lights[i] = 0;
        }
    }
	
	
    
	public List<String> readBinaryWatch2(int num) {
		List<String> ans = new ArrayList<String>();
		
		if(num < 0 || num > 10){
			return ans;
		}
		
		for(int i = 0; i <= num; i++){
			if(i <= 4 && num - i <= 6){
				parse(ans, i, num - i);
			}
		}
		
		return ans;
    }
	
	public void parse(List<String> ans, int upNum, int downNum){
		Set<Integer> left = new HashSet<Integer>();
		Set<Integer> right = new HashSet<Integer>();
		boolean[] flag_left = new boolean[4];
		boolean[] flag_right = new boolean[6];
		backtrack(upNum, left, 0, flag_left);
		backtrack(downNum, right, 0, flag_right);
		
		for(int leftNum : left){
			for(int rightNum : right){
				StringBuilder builder = new StringBuilder();
				String rightStr = rightNum < 10 ? "0" + Integer.toString(rightNum) : Integer.toString(rightNum);
				builder.append(leftNum).append(":").append(rightStr);
				ans.add(builder.toString());
			}
		}
	}
	
	public void backtrack(int lightNum, Set<Integer> set, int solution, boolean[] flag){
		if(flag.length == 4 && solution >= 12){    // 12:00不算？？？
			return ;
		} else if(flag.length == 6 && solution > 59){
			return ;
		} else if(lightNum == 0){
			set.add(solution);
			return ;
		}
				
		for(int i = 0; i < flag.length; i++){
			if(flag[i] == false){
				flag[i] = true;
				backtrack(lightNum - 1, set, solution + (1 << i), flag);
				flag[i] = false;
			}
		}
	}

	
	
	public static void main(String[] args){
		Q401_Binary_Watch t = new Q401_Binary_Watch();
		List<String> ans = t.readBinaryWatch(2);
		
		for(String str : ans){
			System.out.println(str);
		}
	}
}
